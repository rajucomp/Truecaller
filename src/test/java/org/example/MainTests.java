package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests {

    @Test
    public void testForInputFromTextFile() {

    }
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

        System.out.println();

        //Assert
        assertEquals("aaade", trie.getLongestPrefix("a"));
        assertEquals("aaade", trie.getLongestPrefix("aaa"));
        assertEquals("aaaa", trie.getLongestPrefix("aaaa"));
        assertEquals("aaade", trie.getLongestPrefix("aaad"));
        assertEquals("12142345", trie.getLongestPrefix("12"));
        assertEquals("12142345", trie.getLongestPrefix("1"));
        assertEquals("12142345", trie.getLongestPrefix("121"));
        assertEquals("12142345", trie.getLongestPrefix("1214"));
        assertEquals("12142345", trie.getLongestPrefix("12142"));
        assertEquals("12145", trie.getLongestPrefix("12145"));
        assertEquals("123", trie.getLongestPrefix("123"));
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

        //Assert
        assertEquals("aaaa", trie.getLongestPrefix("aaaa"));
        assertEquals("aaade", trie.getLongestPrefix("aaa"));
        assertEquals("abcdefghi", trie.getLongestPrefix("a"));
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
        assertEquals(trie.getLongestPrefix(""), "");
        assertEquals(trie.getLongestPrefix(" "), "");
        assertEquals(trie.getLongestPrefix(null), "");
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

        //Assert
        assertEquals("aaad", trie.getLongestPrefix("aaadbhfbhdsaa"));
        assertEquals("", trie.getLongestPrefix("v"));
        assertEquals("", trie.getLongestPrefix("rerre223"));
        assertEquals("aaaa", trie.getLongestPrefix("aaaaa"));
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

        //Assert
        assertEquals("aaaAd", trie.getLongestPrefix("aaa"));
        assertEquals("", trie.getLongestPrefix("Aaa"));
        assertEquals("aaaAd", trie.getLongestPrefix("aaaA"));
    }

    @Test
    public void testForMultipleInputs() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaaAd");

        List<String> testCases = new ArrayList<>();
        testCases.add("a");
        testCases.add("aaa");
        testCases.add("Aaa");
        testCases.add("aaaA");
        testCases.add("ab");
        testCases.add(null);
        testCases.add(" ");
        testCases.add("");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        trie.BuildTrie("abd");
        trie.BuildTrie("");
        trie.BuildTrie(" ");

        //Assert
        List<String> testCasesResult = new ArrayList<>();
        testCasesResult.add("aaaAd");
        testCasesResult.add("aaaAd");
        testCasesResult.add("");
        testCasesResult.add("aaaAd");
        testCasesResult.add("abd");
        testCasesResult.add("");
        testCasesResult.add("");
        testCasesResult.add("");
        assertArrayEquals(new List[]{testCasesResult}, new List[]{trie.getLongestPrefixes(testCases)});
    }

    @Test
    public void testClearMethod() {
        //Arrange
        List<String> input = new ArrayList<>();
        input.add("aaaa");
        input.add("aaaAd");

        //Act
        AbstractTrie trie = new Trie();
        trie.BuildTrie(input);
        trie.clear();

        //Assert
        assertEquals(0, trie.getRoot().getSize());
    }
}
