package com.github.akovalchuk;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    
    /** Initialize your data structure here. */
    static class Node {
        char letter;
        Map<Character, Node> children = new HashMap<>();
        boolean isLeaf = false;
        Node(Character letter) {
            this.letter = letter;
        }
        Node() {}
    }
    
    private Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node(c));
            }
            node = node.children.get(c);
        }
        node.isLeaf = true;
    }
    
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return search(root, word, 0);
    }

    private boolean search(Node root, String word, int idx) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!root.children.containsKey(c)) {
                if (c == '.') {
                    for (var child : root.children.entrySet()) {
                        if (search(child.getValue(), word, i + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                root = root.children.get(c);
            }
        }
        return root.isLeaf;
    }
    
    public static void main(String[] args) {
        var dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("word");
        dic.addWord("fuck");
        System.out.println(dic.search("dad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("duck"));
        System.out.println(dic.search("f.ck"));
    }
}
