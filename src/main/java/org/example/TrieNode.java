package org.example;

import java.util.*;

public class TrieNode {
    private Character val;
    private StringBuilder maxPrefix;
    private Map<Character, TrieNode> children;

    public TrieNode(Character val) {
        this.val = val;
        this.children = new HashMap<>();
        this.maxPrefix = new StringBuilder();
    }

    public StringBuilder getMaxPrefix() {
        return maxPrefix;
    }

    public void setMaxPrefix(StringBuilder maxPrefix) {
        this.maxPrefix = maxPrefix;
    }

    public int getSize() {
        return children.size();
    }

    public Character getVal() {
        return val;
    }

    public void setVal(Character val) {
        this.val = val;
    }

    public void addChildren(TrieNode childNode){
        children.put(childNode.val, childNode);
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }
}

