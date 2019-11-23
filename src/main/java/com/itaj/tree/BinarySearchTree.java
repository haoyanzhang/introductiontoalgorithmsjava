package com.itaj.tree;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }


    private static class TreeNode {

        public TreeNode(TreeNode leftChild, TreeNode rightChild) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public TreeNode() {
            leftChild = null;
            rightChild = null;
        }

        private TreeNode leftChild;

        private TreeNode rightChild;

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
}
