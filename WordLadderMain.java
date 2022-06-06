import java.util.List;

/**
 * This class is the main class for the word ladder program.
 * 
 * @author William Moss
 * @version 1.0
 * @see WordLadder
 */
public class WordLadderMain {
    public static void main(String[] args) {
        String dictionaryFile = args[0];
        String startWord = args[1];
        String endWord = args[2];

        // Create a dictionary
        Dictionary dictionary = new Dictionary(dictionaryFile);

        // Create a word ladder
        WordLadder wordLadder = new WordLadder(dictionary);

        // Get start time
        long startTime = System.nanoTime();

        // Find the shortest word ladder
        List<String> wordLadderList = wordLadder.findShortestLadder(startWord, endWord);

        // Get end time
        long endTime = System.nanoTime();

        System.out.println("Seconds past: " + (endTime - startTime) / 1000000000.0);

        // Print the word ladder
        if (wordLadderList == null) {
            // No word ladder found
            System.out.println("No word ladder found");
        } else {
            // Print the word ladder
            System.out.println("Shortest Word Ladder:");
            for (String word : wordLadderList) {
                System.out.print(word + " ");
            }
        }
    }
}
