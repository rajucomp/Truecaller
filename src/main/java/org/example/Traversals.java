package org.example;

import java.util.*;

public class Traversals {

    //Returns a level order traversal of the trie.
    static List<List<TrieNode>>  getLevelOrderTraversal(TrieNode root) {
        List<List<TrieNode>> levelOrderTraversalList = new ArrayList<>();
        Queue<TrieNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TrieNode> currentLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TrieNode currentNode = queue.poll();
                currentLevel.add(currentNode);
                for(Map.Entry<Character, TrieNode> entry : currentNode.getChildren().entrySet()) {
                    queue.offer(entry.getValue());
                }
            }
            levelOrderTraversalList.add(currentLevel);
        }
        return levelOrderTraversalList;
    }

    //Displays the level order traversal of the trie.
    public static void Display(TrieNode root) {
        List<List<TrieNode>> levelOrderTraversalList = getLevelOrderTraversal(root);
        for(List<TrieNode> currentLevel : levelOrderTraversalList) {
            for(TrieNode node : currentLevel) {
                System.out.print(node.getVal() + " ");
            }
            System.out.println();
        }
    }
}
