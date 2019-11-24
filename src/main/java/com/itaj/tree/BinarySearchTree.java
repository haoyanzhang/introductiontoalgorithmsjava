package com.itaj.tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    private TreeNode find(T value) {
        return find(root, value);
    }

    private TreeNode find(TreeNode<T> node, T value) {
        if (node == null || node.getValue().equals(value)) {
            return node;
        }
        if (node.getValue().compareTo(value) > 0) {
            return find(node.getLeftChild(), value);
        }
        return find(node.getRightChild(), value);
    }


    private static class TreeNode<T extends Comparable<T>> {

        private T value;

        public TreeNode(T value, TreeNode<T> leftChild, TreeNode<T> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public TreeNode(T value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        private TreeNode<T> leftChild;

        private TreeNode<T> rightChild;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
