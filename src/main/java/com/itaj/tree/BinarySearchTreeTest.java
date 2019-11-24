package com.itaj.tree;

import java.sql.SQLOutput;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(7);

        binarySearchTree.forEach(i -> System.out.print(i + " "));
        System.out.print("\n");

        binarySearchTree.delete(4);

        binarySearchTree.forEach(i -> System.out.print(i + " "));
        System.out.print("\n");

        binarySearchTree.insert(9);
        binarySearchTree.delete(8);

        for (Integer integer : binarySearchTree) {
            System.out.print(integer + " ");
        }
        System.out.print("\n");

        System.out.println("最小值为: " + binarySearchTree.min());

    }
}
