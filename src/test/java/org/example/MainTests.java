package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {

    @Test
    public void testForCorrectInputs() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaade");
        input.add("123");
        input.add("12142345");
        input.add("12145");


        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);

        //Assert
        assertEquals(trie.getLongestPrefix("a"), 5); // 5
        assertEquals(trie.getLongestPrefix("aaa"), 5); // 5
        assertEquals(trie.getLongestPrefix("aaaa"), 4); // 4
        assertEquals(trie.getLongestPrefix("aaad"), 5); // 5
        assertEquals(trie.getLongestPrefix("12"), 8); // 8
        assertEquals(trie.getLongestPrefix("1"), 8); // 8
        assertEquals(trie.getLongestPrefix("121"), 8); // 8
        assertEquals(trie.getLongestPrefix("1214"), 8); // 8
        assertEquals(trie.getLongestPrefix("12142"), 8); // 8
        assertEquals(trie.getLongestPrefix("12145"), 5); // 5
    }

    @Test
    public void testForRepeatedInputs() {

        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaade");
        input.add("abcdefghi");
        input.add("21");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        //Traversals.Display(trie.getRoot());


        //Assert
        assertEquals(trie.getLongestPrefix("aaaa"), 4); //4
        assertEquals(trie.getLongestPrefix("aaa"), 5); // 5
        assertEquals(trie.getLongestPrefix("a"), 9); // 9
    }

    @Test
    public void testForNullAndEmptyInputs(){
        //Arrange
        List<String> input = new ArrayList<>();
        input.add(null);
        input.add("");
        input.add(" ");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);


        //Assert
        assertEquals(trie.getLongestPrefix(""), 0); //0
        assertEquals(trie.getLongestPrefix(" "), 0); //0
        assertEquals(trie.getLongestPrefix(null), 0); //0
    }

    @Test
    public void testForInvalidInputs() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaade");
        input.add("abcdefghi");
        input.add("21");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        //Traversals.Display(trie.getRoot());


        //Assert
        assertEquals(0, trie.getLongestPrefix("aaadbhfbhdsaa")); //0
        assertEquals(0, trie.getLongestPrefix("v")); // 0
        assertEquals(0, trie.getLongestPrefix("rerre223")); // 0
        assertEquals(0, trie.getLongestPrefix("aaaaa")); // 0
    }

    @Test
    public void testForUpperCaseAndLowerCaseInputs() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaaAd");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        //Traversals.Display(trie.getRoot());


        //Assert
        assertEquals(5, trie.getLongestPrefix("aaa")); //5
        assertEquals(0, trie.getLongestPrefix("Aaa")); //0
        assertEquals(5, trie.getLongestPrefix("aaaA")); //5
    }

    @Test
    public void testForMultipleInputs() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaaAd");

        List<String> testCases = new ArrayList<>();
        testCases.add("a"); // 5
        testCases.add("aaa"); // 5
        testCases.add("Aaa"); // 0
        testCases.add("aaaA"); // 5
        testCases.add("ab"); // 3
        testCases.add(null); // 0
        testCases.add(" "); // 0
        testCases.add(""); // 0

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        trie.BuildTrie("abd");
        trie.BuildTrie("");
        trie.BuildTrie(" ");

        //Assert
        List<Integer> testCasesResult = new ArrayList<>();
        testCasesResult.add(5);
        testCasesResult.add(5);
        testCasesResult.add(0);
        testCasesResult.add(5);
        testCasesResult.add(3);
        testCasesResult.add(0);
        testCasesResult.add(0);
        testCasesResult.add(0);
        assertArrayEquals(new List[]{testCasesResult}, new List[]{trie.getLongestPrefixes(testCases)});
    }

}
