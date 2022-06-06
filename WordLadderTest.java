import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordLadderTest {
    @Test
    public void testFindShortestLadderUseAddedWords() {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("hot");
        dictionary.addWord("dot");
        dictionary.addWord("dog");
        dictionary.addWord("lot");
        dictionary.addWord("log");
        dictionary.addWord("cog");

        WordLadder wordLadder = new WordLadder(dictionary);
        List<String> wordLadderList = wordLadder.findShortestLadder("hit", "cog");
        assertEquals(Arrays.asList("hit", "hot", "dot", "dog", "cog"), wordLadderList);
    }

    @Test
    public void testFindShortestLadderReturnsNull() {
        WordLadder wordLadder = new WordLadder("C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt");
        List<String> wordLadderList = wordLadder.findShortestLadder("abc", "xyz");
        assertEquals(null, wordLadderList);
    }

    @Test
    public void testFindShortestLadderUseImportedDictionary() {
        WordLadder wordLadder1 = new WordLadder("C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt");
        List<String> wordLadderList1 = wordLadder1.findShortestLadder("sick", "well");

        WordLadder wordLadder2 = new WordLadder("C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt");
        List<String> wordLadderList2 = wordLadder2.findShortestLadder("life", "death");

        WordLadder wordLadder3 = new WordLadder("C:\\Users\\wckmo\\OneDrive - kettering.edu\\Classes\\Spring 2022\\CS 203\\Assignment 3\\cs203_a3_william_moss\\dictionary.txt");
        List<String> wordLadderList3 = wordLadder3.findShortestLadder("fedor", "dora");
        assertNotEquals(null, wordLadderList1);
        assertNotEquals(null, wordLadderList2);
        assertNotEquals(null, wordLadderList3);
    }
}
