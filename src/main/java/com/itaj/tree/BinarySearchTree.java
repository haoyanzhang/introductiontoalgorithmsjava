package com.itaj.tree;

import java.util.Iterator;
import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        treeInsert(new TreeNode<>(value));
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        treeTravel(root, consumer);
    }

    public void delete(T value) {
        treeDelete(treeSearch(root, value));
    }

    public T min() {
        return treeMiniNum(root).getValue();
    }

    public T max() {
        return treeMaxNum(root).getValue();
    }

    private void treeTravel(TreeNode<T> node, Consumer<? super T> consumer) {
        if (node == null) {
            return;
        }
        treeTravel(node.getLeftChild(), consumer);
        consumer.accept(node.getValue());
        treeTravel(node.getRightChild(), consumer);
    }

    private TreeNode<T> treeSearch(TreeNode<T> node, T value) {
        if (node == null || node.getValue().equals(value)) {
            return node;
        }
        if (node.getValue().compareTo(value) > 0) {
            return treeSearch(node.getLeftChild(), value);
        }
        return treeSearch(node.getRightChild(), value);
    }

    private TreeNode<T> treeMiniNum(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    private TreeNode<T> treeMaxNum(TreeNode<T> node) {
        if (node == null) {
            return null;
        }
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    private TreeNode<T> treeSuccessor(TreeNode<T> node) {
        if (node.getRightChild() != null) {
            return treeMiniNum(node.getRightChild());
        }
        TreeNode<T> parent = node.getParent();
        while (parent != null && parent.getRightChild() == node) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    private void treeInsert(TreeNode<T> node) {
        if (root == null) {
            root = node;
            return;
        }
        TreeNode<T> curNode = this.root;
        TreeNode<T> lastNode = null;
        while (curNode != null) {
            lastNode = curNode;
            if (node.getValue().compareTo(curNode.getValue())> 0) {
                curNode = curNode.getRightChild();
            } else {
                curNode = curNode.getLeftChild();
            }
        }
        if (node.getValue().compareTo(lastNode.getValue())> 0) {
            lastNode.setRightChild(node);
        } else {
            lastNode.setLeftChild(node);
        }
        node.parent = lastNode;
    }

    private void transplant(TreeNode<T> delete, TreeNode<T> node) {
        if (delete == root) {
            root = node;
        } else if (delete == delete.getParent().getLeftChild()) {
            delete.getParent().setLeftChild(node);
        } else {
            delete.getParent().setRightChild(node);
        }
        if (node != null) {
            node.setParent(delete.parent);
        }
    }

    private void treeDelete(TreeNode<T> node) {
        if (node.getLeftChild() == null) {
            transplant(node, node.getRightChild());
        } else if (node.getRightChild() == null) {
            transplant(node, node.getLeftChild());
        } else {
            TreeNode<T> successor = treeMiniNum(node.getRightChild());
            if (successor.getParent() != node) {
                transplant(successor, successor.getRightChild());
                successor.setRightChild(node.getRightChild());
                successor.getRightChild().setParent(successor);
            }
            transplant(node, successor);
            successor.setLeftChild(node.getLeftChild());
            successor.getLeftChild().setParent(successor);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator();
    }


    private static class TreeNode<T extends Comparable<T>> {

        private TreeNode(T value) {
            this.value = value;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        private T value;

        private TreeNode<T> parent;

        private TreeNode<T> leftChild;

        private TreeNode<T> rightChild;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
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

    private class TreeIterator implements Iterator<T> {

        private TreeNode<T> curNode = null;

        @Override
        public boolean hasNext() {
            if (curNode == null) {
                return (curNode = BinarySearchTree.this.treeMiniNum(BinarySearchTree.this.root)) != null;
            }
            return (curNode = BinarySearchTree.this.treeSuccessor(curNode)) != null;
        }

        @Override
        public T next() {
            return curNode.value;
        }
    }
}
