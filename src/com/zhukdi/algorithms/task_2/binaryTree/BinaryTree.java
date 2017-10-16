package com.zhukdi.algorithms.task_2.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(int data) {
        if (root == null) {
            root =  new Node(data);
        } else {
            addNodeTo(root, data);
        }
    }

    private void addNodeTo(Node node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                addNodeTo(node.left, data);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                addNodeTo(node.right, data);
            }
        }
    }


    public void printTree(Node tmpRoot) {

        Queue<Node> currentLevel = new LinkedList<>();
        Queue<Node> nextLevel = new LinkedList<>();

        currentLevel.add(tmpRoot);

        while (!currentLevel.isEmpty()) {
            for (Node currentNode : currentLevel) {
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }

                System.out.print(currentNode.data + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
        }
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while(!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++) {
                System.out.print(' ');
            }
            while(!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null || temp.right != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while(!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("......................................................");
    }
    public Node find(int key) { // Поиск узла с заданным ключом
     // (предполагается, что дерево не пустое)
        Node current = root; // Начать с корневого узла
        while(current.data != key) { // Пока не найдено совпадение
            if (key < current.data) { // Двигаться налево?
                current = current.left;
            } else {
                current = current.right; // Или направо?
            }
            if (current == null) { // Если потомка нет,
                return null; // поиск завершился неудачей
            }
        }
        return current; // Элемент найден
    }

    public void rotateLeft() {
        Node r = root.right;
        root.right = r.left;
        r.left = root;
        root = r;
    }

    public void rotateRight() {
        Node r = root.left;
        root.left = r.right;
        r.right = root;
        root = r;
    }
}
