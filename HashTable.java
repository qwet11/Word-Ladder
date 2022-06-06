import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to create a Hash Table
 * 
 * @author William Moss
 * @version 1.0
 */
public class HashTable {
    private List<String>[] table;
    private final int TABLE_SIZE = 169523; // 63577 or 165799 also works

    /**
     * Constructor for the HashTable class
     * Creates the array of Lists and initializes each element
     */
    public HashTable() {
        table = (List<String>[]) new List[TABLE_SIZE];

        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Generate the hash code for the given word
     * @param key the word to generate the hash code for
     * @return the hash code for the given word. The hash code is modded by the table size to ensure it is within the bounds of the table
     */
    private int hash(String key) {
        int hash = 0;

        for (int i = 0; i < key.length(); i++) {
            hash = (29 * hash  + (key.charAt(i) - 'a' + 1)) % TABLE_SIZE;
        }

        return hash;
    }

    /**
     * Insert the word into the table
     * @param word the word to insert
     */
    public void insert(String word) {
        int index = hash(word);

        table[index].add(word);
    }

    /** 
     * Checks if the word is in the table
     * @param word the word to check
     * @return true if the word is in the table, false otherwise
     */
    public boolean contains(String word) {
        int index = hash(word);

        return table[index].contains(word);
    }

    /**
     * Return the table
     * @return the hash table object
     */
    public List<String>[] getTable() {
        return table;
    }
}