package org.example;

import java.util.*;

public class TrieNode {
    private Character val;

    public Character getVal() {
        return val;
    }

    private int height;
    private Map<Character, TrieNode> children;

    public TrieNode(Character val) {
        this.val = val;
        this.children = new HashMap<>();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addChildren(TrieNode childNode){
        children.put(childNode.val, childNode);
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }
}

