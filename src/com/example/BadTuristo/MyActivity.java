package com.example.BadTuristo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.hardware.Camera;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MyActivity extends Activity {

    private Switch mSwitch;
    private Camera camera;
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mDotSound, mDashSound;
    private Context mContext;
    private TextView outputMorze;
    private EditText inputText;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContext = this;

        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        mAssetManager = getAssets();

        // получим идентификаторы
        mDotSound = loadSound("e.wav");
        mDashSound = loadSound("t.wav");
        mSwitch = (Switch) findViewById(R.id.switch_light);
        ImageButton noizButton = (ImageButton) this.findViewById(R.id.noizButton);
        inputText = (EditText) this.findViewById(R.id.editText);
        outputMorze = (TextView) this.findViewById(R.id.textView);
        ImageButton lightButton = (ImageButton) this.findViewById(R.id.lightButton);
        noizButton.setOnClickListener(onClickSoundListener);
        lightButton.setOnClickListener(onClickLightListener);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (camera == null) {
                    camera = Camera.open();
                }
                Camera.Parameters parameters = camera.getParameters();
                if (!isChecked) {
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(parameters);
                    camera.startPreview();
                } else {
                    for (int i=0; i<outputMorze.getText().toString().length();i++){
                        String equal = Character.toString(outputMorze.getText().toString().charAt(i));
                        if(equal.equals("_")){
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            camera.setParameters(parameters);
                            camera.startPreview();
                            try {
                                TimeUnit.MILLISECONDS.sleep(900);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            camera.setParameters(parameters);
                            camera.startPreview();
                            try {
                                TimeUnit.MILLISECONDS.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }if(equal.equals(".")){
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            camera.setParameters(parameters);
                            camera.startPreview();
                            try {
                                TimeUnit.MILLISECONDS.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                            camera.setParameters(parameters);
                            camera.startPreview();
                            try {
                                TimeUnit.MILLISECONDS.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
    }
        @Override
        public void onDestroy() {
            camera.release();
            super.onDestroy();
        }



    View.OnClickListener onClickSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.noizButton) {

                    for(int i=0; i<outputMorze.getText().toString().length();i++){
                        String equal = Character.toString(outputMorze.getText().toString().charAt(i));
                        if(equal.equals("_")){
                            playSound(mDashSound);
                            try {
                                TimeUnit.MILLISECONDS.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }if(equal.equals(".")){
                            playSound(mDotSound);
                            try {
                                TimeUnit.MILLISECONDS.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

            }
        }
    };
    View.OnClickListener onClickLightListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.lightButton) {
                    morzing(inputText);
            }
        }
    };
    private void morzing (EditText iT){
     String input = iT.getText().toString();
        String output="";
        MorzeDictionary dict = new MorzeDictionary();
        ArrayList<String> dictionary = dict.getDictionary();
    for (int i = 0; i<input.length(); i++){
        for(int j = 0; j<dictionary.size(); j++ ){
            char c = input.charAt(i);
            char b = dictionary.get(j).charAt(0);
            if(c == b){
               output = output + (dictionary.get(j+1));
                break;
            }
        }

    }
    outputMorze.setText(transformate(output));
    }
    private String transformate(String out){
        String dotDash="";
        for(int i=0; i<out.length()-4; i++){
            if (out.substring(i,i+4).equals("&pik")){
            dotDash=dotDash+" . ";
        }if(out.substring(i,i+4).equals("&pii")){
                dotDash=dotDash+" _ ";
            }
        }
        return dotDash;
    }
    private void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }
}



