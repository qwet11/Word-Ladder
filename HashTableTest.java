import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class HashTableTest {
    @Test
    public void testContains() {
        HashTable hashMap = new HashTable();
        hashMap.insert("hot");
        hashMap.insert("dot");
        hashMap.insert("dog");
        hashMap.insert("lot");
        hashMap.insert("log");
        hashMap.insert("cog");
        assertEquals(true, hashMap.contains("hot"));
        assertEquals(true, hashMap.contains("dot"));
        assertEquals(true, hashMap.contains("dog"));
        assertEquals(true, hashMap.contains("lot"));
        assertEquals(true, hashMap.contains("log"));
        assertEquals(true, hashMap.contains("cog"));
        assertEquals(false, hashMap.contains("abc"));
    }

    @Test
    public void testInsert() {
        HashTable hashMap = new HashTable();
        hashMap.insert("hot");
        hashMap.insert("dot");
        hashMap.insert("dog");
        hashMap.insert("lot");
        hashMap.insert("log");
        hashMap.insert("cog");
        assertNotEquals(null, hashMap.getTable());
    }

    /*
    @Test
    public void testHash() {
        HashTable hashMap = new HashTable();
        assertEquals(0, hashMap.hash(""));
        assertEquals(1, hashMap.hash("a"));
        assertEquals(2554, hashMap.hash("cab"));
        assertEquals(156265, hashMap.hash("aardvark"));
        assertEquals(124106, hashMap.hash("aardvarks"));
        
    } */
}
