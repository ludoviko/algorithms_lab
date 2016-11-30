package com.algorithms.searchString.morse;

import java.util.*;

/**
 * Program to decipher a morse message.
 */

public class MorseDecipher {
    public static Map<Character, String> LettersToMorse;
    public static ReadData Words;
    public static Map<String, String> DictionaryToMorse;
    private static final String PathToFile = "src/main/java/....../google1000.txt";
    private String phrase;

    static {
        LettersToMorse = new HashMap<Character, String>();
        LettersToMorse.put('A', ".-");
        LettersToMorse.put('B', "-...");
        LettersToMorse.put('C', "-.-.");
        LettersToMorse.put('D', "-..");
        LettersToMorse.put('E', ".");
        LettersToMorse.put('F', "..-.");
        LettersToMorse.put('G', "--.");
        LettersToMorse.put('H', "....");
        LettersToMorse.put('I', "..");
        LettersToMorse.put('J', ".---");
        LettersToMorse.put('K', "-.-");
        LettersToMorse.put('L', ".-..");
        LettersToMorse.put('M', "--");
        LettersToMorse.put('N', "-.");
        LettersToMorse.put('O', "---");
        LettersToMorse.put('P', ".--.");
        LettersToMorse.put('Q', "--.-");
        LettersToMorse.put('R', ".-.");
        LettersToMorse.put('S', "...");
        LettersToMorse.put('T', "-");
        LettersToMorse.put('U', "..-");
        LettersToMorse.put('V', "...-");
        LettersToMorse.put('W', ".--");
        LettersToMorse.put('X', "-..-");
        LettersToMorse.put('Y', "-.--");
        LettersToMorse.put('Z', "--..");

        Words = new ReadData(PathToFile);
        Words.loadData();

        wordsToMorse(Words.getList());
    }

    public MorseDecipher(String phrase) {
        this.phrase = phrase;
    }

    public static void wordsToMorse(List<String> wordsList) {
        DictionaryToMorse = new HashMap<String, String>();

        for (String s : wordsList) {
            DictionaryToMorse.put(s, translateToMorse(s));
        }
    }

    public static String translateToMorse(String word) {
        String morse = "";

        for (int i = 0; i < word.length(); i++) {
            morse += LettersToMorse.get(word.toUpperCase().charAt(i));
        }

        return morse;
    }

    public List<String> subSolution(String morse) {
        List<String> subsolutions = new ArrayList<String>();
        String submorse = "";

        for (String s : Words.getList()) {
            submorse = DictionaryToMorse.get(s);

            if (morse.startsWith(submorse)) {
                subsolutions.add(s);
            }
        }
        return subsolutions;
    }

    public String decipher(String morse) {
        String solution = "";
        String submorse = "";
        List<String> subsolutions = new ArrayList<String>();
        String morseAux = morse;

        List<String> usedWords = new ArrayList<String>();
        // “.--..-..-.-.-----.-----....--...-.-.-..-....--.-......----.”

        List<String> englishWords = Words.getList();

        while (true) {
            subsolutions = subSolution(morse);

            String w;
            w = getLongest(subsolutions);
            if (w.length() == 0) {
                break;
            }

            submorse = DictionaryToMorse.get(w);

            if (morse.startsWith(submorse)) {
                morse = morse.substring(submorse.length());
                solution += w;
                if (subsolutions.size() > 1 && subsolutions.contains(w)) {
                    usedWords.add(w);
                }
            }
            if (morse.length() == 0) {
                subsolutions.add(solution);
                morse = morseAux;
                break;
            }
        }

        return solution;
    }

    private String getLongest(List<String> list) {
        String longest = "";

        for (String s : list) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
     /*
        Set<Map.Entry<Character, String>> set = LettersToMorse.entrySet();

        Iterator<Map.Entry<Character, String>> itera = set.iterator();

        Map.Entry<Character, String> entry;
        while (itera.hasNext()) {
            entry = itera.next();
            System.out.format("%s %s %n", entry.getKey(), entry.getValue());
        }

        for (String s : Words.getList()) {
            System.out.println(s);
        }
*/
        String data;
        data = ".--..-..-.-.-----.-----....--...-.-.-..-....--.-......----.";
        MorseDecipher morseDecipher = new MorseDecipher(data);
        System.out.println(morseDecipher.decipher(data));
    }
}
