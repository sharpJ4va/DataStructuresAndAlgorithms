package com.sharp.tree;

import java.util.List;

public class Node {
    int val;
    List<Node> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
