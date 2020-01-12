package com.ivan.polovyi.challenge;


import java.util.ArrayList;
import java.util.List;

public class BracketsPairs {

    public static void main(String[] args) {
        String[] brackets = {"{([])}"};

        checkBracketsPairsFirstAttempt(brackets);
        checkBracketsPairsSecondAttempt(brackets);
    }

    public static String[] checkBracketsPairsSecondAttempt(String[] bracketsInput) {
        MAIN_LOOP:
        for (int i = 0; i < bracketsInput.length; i++) {

            //check if length of a String is even
            if (bracketsInput[i].length() % 2 != 0) {
                bracketsInput[i] = "NO";
            } else {
                ArrayList<Character> characters = new ArrayList<Character>();
                for (char bracket : bracketsInput[i].toCharArray()) {

                    switch (bracket) {
                        case '{':
                            characters.add('}');
                            break;

                        case '[':
                            characters.add(']');
                            break;

                        case '(':
                            characters.add(')');
                            break;
                        default:
//                            System.out.println(i+" "+characters + " " + bracketsInput[i] + " " + bracket);
                            if (characters.get(characters.size() - 1).equals(bracket)) {
                                characters.remove(characters.size() - 1);
                            } else {
                                bracketsInput[i] = "NO";
                                continue MAIN_LOOP;
                            }

                    }
                }
                bracketsInput[i] = "YES";
            }

        }
        return bracketsInput;
    }

    public static String[] checkBracketsPairsFirstAttempt(String[] bracketsInput) {

        //loop over input array

        for (int i = 0; i < bracketsInput.length; i++) {
            //check if length of a String is even

            if (bracketsInput[i].length() % 2 != 0) {
                bracketsInput[i] = "NO";
            } else {
                //replace all non brackets char in a String
                // create 6 ArrayLists for each type of brackets
                List<Character> curlyBrOpen = new ArrayList<Character>(),
                        curlyBrClose = new ArrayList<Character>(),
                        squareBrOpen = new ArrayList<Character>(),
                        squareBrClose = new ArrayList<Character>(),
                        parenthesisOpen = new ArrayList<Character>(),
                        parenthesisClose = new ArrayList<Character>();

                //create an array of chars from given String
                for (char bracket : bracketsInput[i].toCharArray()) {

                    switch (bracket) {
                        case '{':
                            curlyBrOpen.add(bracket);
                            break;
                        case '}':
                            curlyBrClose.add(bracket);
                            break;
                        case '[':
                            squareBrOpen.add(bracket);
                            break;
                        case ']':
                            squareBrClose.add(bracket);
                            break;
                        case '(':
                            parenthesisOpen.add(bracket);
                            break;
                        case ')':
                            parenthesisClose.add(bracket);
                            break;
                    }

                }
                //in a switch statement add brackets to corresponding ArrayList
                // in a if statement add  sizes of corresponding brackets and check if it is odd or even, than set string accordingly
                if ((curlyBrOpen.size() + curlyBrClose.size()) % 2 == 0
                        && (squareBrOpen.size() + squareBrClose.size()) % 2 == 0
                        && (parenthesisOpen.size() + parenthesisClose.size()) % 2 == 0) {
                    bracketsInput[i] = "YES";
                } else {
                    bracketsInput[i] = "NO";
                }

            }

        }

        return bracketsInput;
    }
}
