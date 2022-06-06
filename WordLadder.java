import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class is used to create the word ladder.
 * 
 * @author William Moss
 * @version 1.0
 * @see Dictionary
 * @see Rules
 */
public class WordLadder {
    private Dictionary dictionary;
    private Rules rule;

    /**
     * Constructor for the WordLadder class.
     * 
     * @param dictionary the dictionary to use
     */
    public WordLadder(Dictionary dictionary) {
        this.dictionary = dictionary;
        rule = new Rules();
    }

    /**
     * Constructor for the WordLadder class.
     * 
     * @param dictionary_filename the filename of the dictionary to use
     */
    public WordLadder(String dictionary_filename) {
        this.dictionary = new Dictionary(dictionary_filename);
        rule = new Rules();
    }

    /**
     * Find the shortest word ladder from startWord to endWord.
     * 
     * @param startWord the word we start with
     * @param endWord   the word we want to end with
     */
    public List<String> findShortestLadder(String startWord, String endWord) {
        // Ensure that the endWord is in the dictionary
        dictionary.addWord(endWord);

        // Makes a queue to store the word lists we need to check
        // NOTE: We will store the word lists in a queue because we want to know the
        // previous words of each word
        Queue<List<String>> queue = new LinkedList<>();

        // Add the first word in the queue
        List<String> tempStartWordList = new LinkedList<>();
        tempStartWordList.add(startWord);
        queue.add(tempStartWordList);

        do {
            // Get the current word to check from the queue
            List<String> currList = queue.poll();
            String currWord = currList.get(currList.size() - 1);

            // Get all legal words from current word
            List<String> wordList = getAllLegalWords(currWord);

            // Searches the word list for the endWord
            for (String word : wordList) {
                if (word.equals(endWord)) {
                    // We found the end word
                    currList.add(word);
                    return currList;
                } else {
                    // Add the word to the word list and add the word list to the queue
                    List<String> tempList = new LinkedList<>(currList);
                    tempList.add(word);
                    queue.add(tempList);

                    // Remove word from dictionary to prevent infinite loop and excessive word lists
                    // dictionary.setIsUsed(word);
                }
            }
        } while (!queue.isEmpty());

        // Queue is empty. No word ladder found
        return null;
    }

    /**
     * Find all the legal words that can be reached from the given word.
     * 
     * @param currWord the word we use to search for legal words
     * @return a list of legal words
     */
    private List<String> getAllLegalWords(String currWord) {
        List<String> legalWords = new LinkedList<>();

        // Generate all possible words from the current word
        List<String> possibleWords = rule.generateWords(currWord);

        // Check if each word is legal. Add if it is.
        for (String word : possibleWords) {
            if (dictionary.isWord(word)) {
                legalWords.add(word);
            }
        }
        return legalWords;
    }
}