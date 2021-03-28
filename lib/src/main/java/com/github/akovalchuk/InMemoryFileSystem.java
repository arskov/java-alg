package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 588. Design In-Memory File System
 */
public class InMemoryFileSystem {

    static class Node {
        String name;
        boolean isDir;
        Map<String, Node> children;
        String content = "";
        Node(String name, boolean isDir) {
            this.name = name;
            this.isDir = isDir;
            this.children = new HashMap<>();
        }
    }
    
    private Node root = new Node("", true);
    private Map<String, Node> files = new HashMap<>();

    public InMemoryFileSystem() {}
    
    public List<String> ls(String path) {
        if (path == null) return Collections.emptyList();
        String[] pathParts = path.split("/");
        Node node = this.root;
        for (String part : pathParts) {
            if (part.isEmpty()) continue;
            if (node.children.containsKey(part)) {
                var tmp = node.children.get(part);
                if (tmp.isDir) {
                    node = tmp;
                } else {
                    return List.of(tmp.name);
                }
            } else {
                return Collections.emptyList();
            }
        }
        var result = new ArrayList<String>();
        if (node != null) {
            result.addAll(node.children.keySet());
        }
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        if (path == null || path.isEmpty()) return;
        String[] pathParts = path.split("/");
        Node node = this.root;
        for(var part : pathParts) {
            if (part.isEmpty()) continue;
            if (node.children.containsKey(part) && node.children.get(part).isDir) {
                node = node.children.get(part);
            } else {
                var newNode = new Node(part, true);
                node.children.put(part, newNode);
                node = newNode;
            }
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        if (filePath == null || content == null) return;
        var fileNode = files.get(filePath);
        if (fileNode == null) {
            Node node = this.root;
            String[] pathParts = filePath.split("/");
            int i = 0;
            if (pathParts[0].isEmpty()) i = 1;
            for (; i < pathParts.length - 1; i++) {
                var part = pathParts[i];
                if (part.isEmpty()) continue;
                if (node.children.containsKey(part)) {
                    node = node.children.get(part);
                } else {
                    var newNode = new Node(part, true);
                    node.children.put(part, newNode);
                    node = newNode;
                }
            }
            var filePartPath = pathParts[pathParts.length - 1];
            fileNode = new Node(filePartPath, false);
            node.children.put(filePartPath, fileNode);
            this.files.put(filePath, fileNode);
        }
        fileNode.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        if (filePath == null) return null;
        var fileNode = files.get(filePath);
        if (fileNode != null) return fileNode.content;
        return null;
    }
}
