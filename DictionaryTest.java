import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

/**
 * This class is used as a test class for Dictionary.java
 * @author William
 * @version 1.0
 */
public class DictionaryTest {
    @Test
    public void testImportDictionary() {
        Dictionary dictionary = new Dictionary("C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt");
        assertNotEquals(null, dictionary.getDictionary());
        assertEquals(true, dictionary.isWord("silk"));
        assertEquals(true, dictionary.isWord("silky"));
        assertEquals(true, dictionary.isWord("death"));
        assertEquals(true, dictionary.isWord("hello"));

    }

    @Test
    public void testAddWord() {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("hot");
        dictionary.addWord("dot");
        dictionary.addWord("dog");
        dictionary.addWord("lot");
        dictionary.addWord("log");
        dictionary.addWord("cog");
        assertNotEquals(null, dictionary.getDictionary());
    }

    @Test
    public void testIsWord() {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("hot");
        dictionary.addWord("dot");
        dictionary.addWord("dog");
        dictionary.addWord("lot");
        dictionary.addWord("log");
        dictionary.addWord("cog");
        dictionary.addWord("sick");
        dictionary.addWord("silly");
        dictionary.addWord("death");
        dictionary.addWord("hello");
        assertEquals(true, dictionary.isWord("hot"));
        assertEquals(true, dictionary.isWord("dot"));
        assertEquals(true, dictionary.isWord("dog"));
        assertEquals(true, dictionary.isWord("lot"));
        assertEquals(true, dictionary.isWord("log"));
        assertEquals(true, dictionary.isWord("cog"));
        assertEquals(false, dictionary.isWord("abc"));
    }

    @Test
    public void fullTestIsWord() {
        String filename = "C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt";
        Dictionary dictionary = new Dictionary(filename);

        try {
            Scanner in = new Scanner(new File(filename));
            while(in.hasNext()) {
                String word = in.next();
                assertEquals(true, dictionary.isWord(word));
            }
        } catch(FileNotFoundException e) {
            System.err.println("File not found");
            throw new RuntimeException(e);
        }   
    }
}
