package org.example;

import java.util.List;

public abstract class AbstractTrie {
    protected TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public AbstractTrie(Character val) {
        root = new TrieNode((val));
    }

    abstract void BuildTrie(List<String> prefixes);
    abstract void BuildTrie(String prefix);
    abstract int getLongestPrefix(String word);
    abstract List<Integer> getLongestPrefixes(List<String> words);
    abstract String serialise();
    abstract void clear();
}
