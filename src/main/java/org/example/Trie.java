package org.example;

import java.util.*;

public class Trie extends AbstractTrie {
    public Trie() {
        super('#');
    }

    public void BuildTrie(List<String> prefixes) {
        for(String word : prefixes) {
            if(!StringUtilityFunctions.isNullOrEmpty(word)) {
                addNode(word, 0, root);
            }
        }
    }

    public void BuildTrie(String prefix) {
        if(!StringUtilityFunctions.isNullOrEmpty(prefix)) {
            addNode(prefix, 0, root);
        }
    }

    public String getLongestPrefix(String word) {
        if(StringUtilityFunctions.isNullOrEmpty(word)) {
            return "";
        }

        return getLongestPrefix(word, 0, root).toString();
    }

    public List<String> getLongestPrefixes(List<String> words) {
        List<String> longestPrefixes = new ArrayList<>();
        for(String word : words) {
            if(StringUtilityFunctions.isNullOrEmpty(word)) {
                longestPrefixes.add("");
                continue;
            }
            longestPrefixes.add(getLongestPrefix(word, 0, root).toString());
        }
        return longestPrefixes;
    }

    StringBuilder getLongestPrefix(String word, int index, TrieNode currentNode) {
        if(index == word.length()) {
            return currentNode.getMaxPrefix();
        }

        Character ch = word.charAt(index);

        if(currentNode.getChildren().containsKey(ch)) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            sb.append(getLongestPrefix(word, index + 1, currentNode.getChildren().get(ch)));
            return sb;
        }
        return new StringBuilder();
    }

    void addNode(String str, int index, TrieNode currentNode){
        //This means that we are at the leaf node and the height of the leaf node is 1.
        if(index == str.length()) {
            currentNode.setMaxPrefix(new StringBuilder(str.charAt(index - 1)));
            return;
        }
        Character ch = str.charAt(index);

        if(!currentNode.getChildren().containsKey(ch)) {
            TrieNode childNode = new TrieNode((ch));
            currentNode.addChildren(childNode);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        addNode(str, index + 1, currentNode.getChildren().get(ch));
        sb.append(currentNode.getChildren().get(ch).getMaxPrefix());

        // There can be multiple words ending from a given node.
        // While traversing, we set the max prefix of the node to the maximum of its children.
        if(sb.length() > currentNode.getMaxPrefix().length()) {
            currentNode.setMaxPrefix(sb);
        }
    }

    public void clear() {
        root.setChildren(new HashMap<>());
    }
}