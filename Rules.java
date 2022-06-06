import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class is used to generate all possible words given the startWord and
 * rules.
 * 
 * @author William Moss
 * @version 1.0
 */
public class Rules {
    private final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private Set<String> usedWords; // Is used to ensure that no duplicates words are generated. Decided to check it
                                   // here for simplicity and to allow any object to be used in future

    /**
     * Constructor for the Rules class
     */
    public Rules() {
        usedWords = new HashSet<>();
    }

    /**
     * Generate all possible words given the startWord.
     * 
     * @param currWord the word to start with
     * @return a list of all possible words
     */
    public List<String> generateWords(String currWord) {
        List<String> words = new LinkedList<>();

        // Generate all possible words to add to the list
        generateWordsWithLetterAdded(currWord, words);
        generateWordsWithLetterRemoved(currWord, words);
        generateWordsWithLetterReplaced(currWord, words);
        generateWordsWithLettersSwapped(currWord, words);

        return words;
    }

    /**
     * Generate the words in the dictionary by adding a letter to the current word
     * 
     * @param currWord the current word
     * @param words    the list of words to add to
     */
    private void generateWordsWithLetterAdded(String currWord, List<String> words) {
        for (int i = 0; i <= currWord.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                String newWord = currWord.substring(0, i) + alphabet[j] + currWord.substring(i);

                if (usedWords.add(newWord)) {
                    words.add(newWord);
                }
            }
        }
    }

    /**
     * Generate the words in the dictionary by removing a letter from the current
     * word
     * 
     * @param currWord the current word
     * @param words    the list of words to add to
     */
    private void generateWordsWithLetterRemoved(String currWord, List<String> words) {
        for (int i = 0; i < currWord.length(); i++) {
            String newWord = currWord.substring(0, i) + currWord.substring(i + 1);

            if (usedWords.add(newWord)) {
                words.add(newWord);
            }

        }
    }

    /**
     * Generate the words in the dictionary by replacing a letter in the current
     * word
     * 
     * @param currWord the current word
     * @param words    the list of words to add to
     */
    private void generateWordsWithLettersSwapped(String currWord, List<String> words) {
        for (int i = 0; i < currWord.length() - 1; i++) {
            for (int j = i + 1; j < currWord.length(); j++) {
                String newWord = currWord.substring(0, i) + currWord.charAt(j) + currWord.substring(i + 1, j)
                        + currWord.charAt(i) + currWord.substring(j + 1);

                if (usedWords.add(newWord)) {
                    words.add(newWord);
                }
            }
        }
    }

    /**
     * Generate the words in the dictionary by replacing a letter in the current
     * word
     * 
     * @param currWord the current word
     * @param words    the list of words to add to
     */
    private void generateWordsWithLetterReplaced(String currWord, List<String> words) {
        for (int i = 0; i < currWord.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                String newWord = currWord.substring(0, i) + alphabet[j] + currWord.substring(i + 1);

                if (usedWords.add(newWord)) {
                    words.add(newWord);
                }
            }
        }
    }
}
