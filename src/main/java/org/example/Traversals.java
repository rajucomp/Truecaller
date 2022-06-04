package org.example;

import java.util.*;

public class Traversals {

    public static String serialise(TrieNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.getVal());
        sb.append('[');
        for(TrieNode childNode : root.getChildren().values()) {
            sb.append(serialise(childNode));
        }
        sb.append(']');
        return sb.toString();
    }

    public static AbstractTrie deserialise(String serlialisedTree) {
        AbstractTrie trie = new Trie();
        trie.getRoot().setVal(serlialisedTree.charAt(0));
        return null;
    }
}
