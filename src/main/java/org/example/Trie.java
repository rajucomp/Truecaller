package org.example;

import java.util.*;

public class Trie extends AbstractTrie {
    public Trie() {
        super('#');
        root.setHeight(0);
    }

    public void BuildTrie(List<String> prefixes) {
        for(String word : prefixes) {
            //Check if word is null or empty before adding to the trie.
            if(!StringUtilityFunctions.isNullOrEmpty(word)) {
                addNode(word, 0, root);
            }
        }
    }

    public void BuildTrie(String prefix) {
        //Check if word is null or empty before adding to the trie.
        if(!StringUtilityFunctions.isNullOrEmpty(prefix)) {
            addNode(prefix, 0, root);
        }
    }

    public int getLongestPrefix(String word) {
        ////Check if word is null or empty before processing.
        if(StringUtilityFunctions.isNullOrEmpty(word)) {
            return 0;
        }

        int longestPrefix = getLongestPrefix(word, 0, root);
        return longestPrefix >= word.length() ? longestPrefix - 1 : 0;
    }

    public List<Integer> getLongestPrefixes(List<String> words) {
        List<Integer> longestPrefixes = new ArrayList<>();
        for(String word : words) {
            ////Check if word is null or empty before processing.
            if(StringUtilityFunctions.isNullOrEmpty(word)) {
                longestPrefixes.add(0);
                continue;
            }
            int longestPrefix = getLongestPrefix(word, 0, root);
            longestPrefixes.add(longestPrefix >= word.length() ? longestPrefix - 1 : 0);
        }
        return longestPrefixes;
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

    void addNode(String str, int index, TrieNode currentNode){
        //This means that we are at the leaf node and the height of the leaf node is 1.
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

        // There can be multiple words ending from a given node.
        // While traversing, we set the height of the node to the maximum of its children.
        currentNode.setHeight(Math.max(currentNode.getHeight(), 1 + currentNode.getChildren().get(ch).getHeight()));
    }

    public String serialise() {
        return Traversals.serialise(root);
    }

    public void clear() {
        root.setChildren(new HashMap<>());
    }


}