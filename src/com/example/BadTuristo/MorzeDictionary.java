package com.example.BadTuristo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ���� on 05.07.2015.
 */
public class MorzeDictionary {

    private HashMap<Character,String> dictionary = new HashMap<>();


 public MorzeDictionary(){
     this.dictionary.put('a', ".-");
     this.dictionary.put('b', "-...");
     this.dictionary.put('c', "-.-.");
     this.dictionary.put('d', "-...");
     this.dictionary.put('e', ".");
     this.dictionary.put('f', "..-.");
     this.dictionary.put('g', "--.");
     this.dictionary.put('h', "....");
     this.dictionary.put('i', "..");
     this.dictionary.put('j', ".---");
     this.dictionary.put('k', "-.-");
     this.dictionary.put('l', ".-...");
     this.dictionary.put('m', "--");
     this.dictionary.put('n', "-.");
     this.dictionary.put('o', "---");
     this.dictionary.put('p', ".--.");
     this.dictionary.put('q', "--.-");
     this.dictionary.put('r', ".-.");
     this.dictionary.put('s', "...");
     this.dictionary.put('t', "-");
     this.dictionary.put('u', "..-");
     this.dictionary.put('v', "...-");
     this.dictionary.put('w', ".--");
     this.dictionary.put('x', "-..-");
     this.dictionary.put('y', "-.--");
     this.dictionary.put('z', "--..");

     this.dictionary.put('�', ".-");
     this.dictionary.put('�', "-...");
     this.dictionary.put('�', "-.-.");
     this.dictionary.put('�', "-...");
     this.dictionary.put('�', ".");
     this.dictionary.put('�', "..-.");
     this.dictionary.put('�', "--.");
     this.dictionary.put('�', "....");
     this.dictionary.put('�', "..");
     this.dictionary.put('�', ".---");
     this.dictionary.put('�', "-.-");
     this.dictionary.put('�', ".-...");
     this.dictionary.put('�', "--");
     this.dictionary.put('�', "-.");
     this.dictionary.put('�', "---");
     this.dictionary.put('�', ".--.");
     this.dictionary.put('�', "--.-");
     this.dictionary.put('�', ".-.");
     this.dictionary.put('�', "...");
     this.dictionary.put('�', "-");
     this.dictionary.put('�', "..-");
     this.dictionary.put('�', "...-");
     this.dictionary.put('�', ".--");
     this.dictionary.put('�', "-..-");
     this.dictionary.put('�', "-..-");
     this.dictionary.put('�', "-.--");
     this.dictionary.put('�', "---.");
     this.dictionary.put('�', "----");
     this.dictionary.put('�', "..--");
     this.dictionary.put('�', ".-.-");
     this.dictionary.put('�', "..-..");
     this.dictionary.put('�', "--..");

     this.dictionary.put('1', ".----");
     this.dictionary.put('2', "..---");
     this.dictionary.put('3', "...--");
     this.dictionary.put('4', "....-");
     this.dictionary.put('5', ".....");
     this.dictionary.put('6', "-....");
     this.dictionary.put('7', "--...");
     this.dictionary.put('8', "---..");
     this.dictionary.put('9', "----.");
     this.dictionary.put('0', "-----");

     this.dictionary.put(',', ".-.-.-");
     this.dictionary.put('.', "......");
     this.dictionary.put(';', "-.-.-");
     this.dictionary.put(':', "---...");
     this.dictionary.put('?', "..--..");
     this.dictionary.put('�', "-..-.");
     this.dictionary.put('(', "-.--.-");
     this.dictionary.put(')', "-.--.-");
     this.dictionary.put('"', ".-..-.");
     this.dictionary.put('!', "--..--");
     this.dictionary.put('-', "-....-");
     this.dictionary.put('/', "-..-.");
     this.dictionary.put(' ', "/");


    }

    public HashMap<Character,String> getDictionary() {
        return dictionary;
    }
}
