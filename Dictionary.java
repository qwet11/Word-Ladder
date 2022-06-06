import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is used to create a dictionary which stores the words given in the
 * text file.
 * 
 * @author William Moss
 * @version 1.0
 * @see HashTable
 */

public class Dictionary {
    private HashTable dictionary;

    public Dictionary() {
        dictionary = new HashTable();
    }

    /**
     * Read the dictionary file and build the dictionary.
     * 
     * @param fileName the name of the dictionary file
     * @throws FileNotFoundException
     */

    public Dictionary(String filename) {
        dictionary = new HashTable();

        // Read the file line by line. Add each word to the dictionary
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNext()) {
                addWord(in.next());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the dictionary.
     * 
     * @return the dictionary tree
     */
    public HashTable getDictionary() {
        return dictionary;
    }

    /**
     * Add a word to the dictionary.
     * 
     * @param word the word to add
     */
    public void addWord(String word) {
        dictionary.insert(word);
    }

    /**
     * Check if the given word is in the dictionary and is unused
     * 
     * @param word the word to check
     * @return true if the word is in the dictionary and unused, false otherwise
     */
    public boolean isWord(String word) {
        return dictionary.contains(word);
    }
}