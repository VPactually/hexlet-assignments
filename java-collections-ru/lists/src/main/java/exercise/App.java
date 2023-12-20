package exercise;

import java.util.*;

// BEGIN
public class App {
    public static void main(String[] args) {
        System.out.println("Result of scrabble = " + scrabble("thlxertwq", "hexlet")); //false
        System.out.println("Result of scrabble = " + scrabble("begsdhhtsexoult", "Hexlet")); //true
        System.out.println("Result of scrabble = " + scrabble("jvayu", "java")); //false
        System.out.println("Result of scrabble = " + scrabble("rkqodlw", "woRld")); //true
    }

    public static boolean scrabble(String symbols, String word) {
        if (symbols.isEmpty() || word.isEmpty()) {
            return false;
        }

        var listOfSymbols = new ArrayList<>(Arrays.asList(symbols.toLowerCase().split("")));
        var listOfWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));

        listOfSymbols.retainAll(listOfWord);
        Collections.sort(listOfSymbols);
        Collections.sort(listOfWord);

        return listOfSymbols.size() > listOfWord.size() || listOfSymbols.equals(listOfWord);
    }
}
//END
