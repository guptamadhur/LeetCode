package web.app.madhurgupta.challenge.May.Week2;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 15-05-2020 01:33
*/

import java.util.HashMap;
import java.util.Map;

public class Implement_Trie {
    private final TrieNode root;

    /** Initialize your data structure here. */
    public Implement_Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Implement_Trie trie = new Implement_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); //True
        System.out.println(trie.search("app")); //False
        System.out.println(trie.startsWith("app")); //True
        trie.insert("app");
        System.out.println(trie.search("app")); //True
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        if (current.endOfWord == true) {
            return true;
        }
        return current.endOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
}
