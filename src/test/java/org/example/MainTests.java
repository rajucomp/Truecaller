package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

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
        Trie trie = new Trie();
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
        Trie trie = new Trie();
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
        Trie trie = new Trie();
        trie.BuildTrie(input);


        //Assert
        assertEquals(trie.getLongestPrefix(""), 0); //4
        assertEquals(trie.getLongestPrefix(" "), 0); //4
        assertEquals(trie.getLongestPrefix(null), 0); //4
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
        Trie trie = new Trie();
        trie.BuildTrie(input);
        //Traversals.Display(trie.getRoot());


        //Assert
        assertEquals(0, trie.getLongestPrefix("aaadbhfbhdsaa")); //0
        assertEquals(0, trie.getLongestPrefix("v")); // 0
        assertEquals(0, trie.getLongestPrefix("rerre223")); // 0
        assertEquals(0, trie.getLongestPrefix("aaaaa")); // 0
    }

}
