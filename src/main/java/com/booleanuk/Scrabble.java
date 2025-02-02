package com.booleanuk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Scrabble {

    private String word;
    private HashMap<Character, Integer> letterScores = new HashMap<>();
    public Scrabble(String word) {
        this.word = word;

        letterScores.put('A', 1);
        letterScores.put('E', 1);
        letterScores.put('I', 1);
        letterScores.put('O', 1);
        letterScores.put('U', 1);
        letterScores.put('L', 1);
        letterScores.put('N', 1);
        letterScores.put('R', 1);
        letterScores.put('S', 1);
        letterScores.put('T', 1);
        letterScores.put('D', 2);
        letterScores.put('G', 2);
        letterScores.put('B', 3);
        letterScores.put('C', 3);
        letterScores.put('M', 3);
        letterScores.put('P', 3);
        letterScores.put('F', 4);
        letterScores.put('H', 4);
        letterScores.put('V', 4);
        letterScores.put('W', 4);
        letterScores.put('Y', 4);
        letterScores.put('K', 5);
        letterScores.put('J', 8);
        letterScores.put('X', 8);
        letterScores.put('Q', 10);
        letterScores.put('Z', 10);

    }

    public int score() {
        int result = 0;
        boolean isDouble = false;
        boolean isTriple = false;
        boolean doubleWord = false;
        boolean tripleWord = false;

        //checking the brackets [dog]
        if(word.length() > 1){
            if(word.charAt(0) == '{' && word.charAt(word.length() - 1) == '}'){
                doubleWord = true;
                word = word.substring(1, word.length()-1);
            }
            else if (word.charAt(0) == '[' && word.charAt(word.length() - 1) == ']'){
                tripleWord = true;
                word = word.substring(1, word.length()-1);
            }
            System.out.println(word);
        }

        char[] letters = word.toCharArray();

        for (char c : letters){
            c = Character.toUpperCase(c);

            if(c == '{' && word.charAt(0) != '{' && word.charAt(word.length() - 1) != '}')
                isDouble = true;

            if (c == '[' && word.charAt(0) != '[' && word.charAt(word.length() - 1) != ']')
                isTriple = true;

            if(letterScores.containsKey(c)){
                int score = letterScores.get(c);

                if(isDouble)
                    score *= 2;

                if (isTriple)
                    score *= 3;

                isDouble = false;
                isTriple = false;
                result += score;
            }
        }


        if(doubleWord) { result *= 2; }
        if(tripleWord) { result *= 3; }

        return result;
    }

}
