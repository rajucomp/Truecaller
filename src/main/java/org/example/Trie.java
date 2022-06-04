package org.example;

import java.util.*;

public class Trie {
    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }

    public Trie() {
        root = new TrieNode('#');
        root.setHeight(0);
    }

    public void BuildTrie(List<String> prefixes) {
        for(String word : prefixes) {
            if(word != null && !word.trim().isEmpty()) {
                addNode(word, 0, root);
            }
        }
    }

    public int getLongestPrefix(String word) {
        if(word == null || word.trim().isEmpty()) {
            return 0;
        }

        int longestPrefix = getLongestPrefix(word, 0, root);
        return longestPrefix >= word.length() ? longestPrefix - 1 : 0;
    }

    int getLongestPrefix(String word, int index, TrieNode currentNode) {
        if(index == word.length()) {
            //System.out.println(currentNode.getVal() + " " + currentNode.getHeight());
            return currentNode.getHeight();
        }
        Character ch = word.charAt(index);
        if(currentNode.getChildren().containsKey(ch)) {
            return 1 + getLongestPrefix(word, index + 1, currentNode.getChildren().get(ch));
        }
        return 0;
    }

    public void addNode(String str, int index, TrieNode currentNode){
        if(index == str.length()) {
            currentNode.setHeight(1);
            return;
        }
        Character ch = str.charAt(index);
        if(!currentNode.getChildren().containsKey(ch)) {
            TrieNode childNode = new TrieNode((ch));
            currentNode.addChildren(childNode);
        }

        addNode(str, index + 1, currentNode.getChildren().get(ch));
        currentNode.setHeight(Math.max(currentNode.getHeight(), 1 + currentNode.getChildren().get(ch).getHeight()));
    }
}