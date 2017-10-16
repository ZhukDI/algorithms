package com.zhukdi.algorithms.task_2.binaryTree;

public class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
