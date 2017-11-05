package com.zhukdi.algorithms.task_2.binaryTree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        BinaryTree tree = new BinaryTree();
//        tree.addNode(1);
//        tree.addNode(2);
//        tree.addNode(3);
        tree.addNode(5);
        tree.addNode(4);
        tree.addNode(9);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(15);
        tree.addNode(1);

//        tree.print(tree.getRoot());
//        tree.byLevel(tree.getRoot());
//        tree.printTree(tree.getRoot());
        tree.displayTree();
        tree.rotateLeft();
        tree.displayTree();
        System.out.println(tree.find(0));


    }
}
