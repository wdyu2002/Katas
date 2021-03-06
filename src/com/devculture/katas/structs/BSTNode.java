package com.devculture.katas.structs;

import java.util.Stack;

/**
 * Basic BST node. Each node should contain a left & right pointer to another node,
 * respectively representing a value that is less-than or greater-than itself.
 * In this implementation, we've also added a 'visited' property to act as a traversal
 * flag when we implement DFS traversal through the tree.
 */
public class BSTNode {

    /**
     * A traversal flag for when we traverse the tree via DFS algorithm.
     */
    private BSTNode left;
    private BSTNode right;

    /**
     * Each node has an immutable value. This prevents forceful change after a node
     * has been inserted in order.
     */
    private final int value;

    public BSTNode(int value) {
        this.value = value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    /**
     * Recursive insertion of another node into this sub-tree.
     * @param n node to insert.
     */
    public void insert(BSTNode n) {
        if (n.value < value) {
            // insert left
            if (left != null) {
                left.insert(n);
            } else {
                left = n;
            }
        } else if (n.value > value) {
            // insert right
            if (right != null) {
                right.insert(n);
            } else {
                right = n;
            }
        } else {
            // warning. no insertion occurs for dupes.
            System.out.printf("Inserting duplicate node with value: %d\n", value);
        }
    }

    /**
     * @return size of this element and its left+right sub-trees.
     */
    int size() {
        int count = 1;
        Stack<BSTNode> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            BSTNode node = stack.pop();
            BSTNode left = node.getLeft();
            BSTNode right = node.getRight();
            if (left != null) {
                stack.push(left);
                count++;
            }
            if (right != null) {
                stack.push(right);
                count++;
            }
        }
        return count;
    }

    /**
     * @return string of all children, comma delimited & ordered from smallest to greatest.
     */
    @Override
    public String toString() {
        // append to children.toString();
        StringBuilder buf = new StringBuilder();
        if (left != null) {
            buf.append(left.toString());
        }
        buf.append(value).append(',');
        if (right != null) {
            buf.append(right.toString());
        }
        return buf.toString();
    }
}