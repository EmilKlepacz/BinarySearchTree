package com.klepacz.emil.tree;

import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Binary Tree
 */
public class Tree<T extends Comparable<T>> implements Iterable<T> {
    private Tree<T> leftTree;
    private Tree<T> rightTree;
    private T value;

    public Tree(T value) throws IllegalArgumentException {
        if (value == null) throw new IllegalArgumentException("Value passed as argument can not be null");
        this.value = value;

    }

    public Optional<Tree<T>> getLeftTree() {
        return Optional.ofNullable(leftTree);
    }

    public void setLeftTree(Tree<T> leftTree) {
        this.leftTree = leftTree;
    }

    public Optional<Tree<T>> getRightTree() {
        return Optional.ofNullable(rightTree);
    }

    public void setRightTree(Tree<T> rightTree) {
        this.rightTree = rightTree;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void insert(T value) {
        if (value == null) throw new IllegalArgumentException("Insert value can not be null");

        if (value.equals(this.value)) throw new IllegalArgumentException("Value to insert already exist in tree");

        if (value.compareTo(this.value) < 0) {
            if (this.leftTree == null) setLeftTree(new Tree<T>(value));
            else leftTree.insert(value);
        } else if (value.compareTo(this.value) > 0) {
            if (this.rightTree == null) setRightTree(new Tree<T>(value));
            else rightTree.insert(value);
        }
    }


    // if value exist in tree [empty Optional if does not exist or Optional with this value]
    public Optional<T> find(T value) {

        if (value.equals(this.value)) {
            return Optional.of(value);
        } else if (value.compareTo(this.value) < 0) {
            if (leftTree != null) return leftTree.find(value);
        } else if (value.compareTo(this.value) > 0) {
            if (rightTree != null) return rightTree.find(value);
        }
        return Optional.empty();
    }

    @Override
    public Iterator<T> iterator() {

        InOrder inOrder = new InOrder();
        List<T> inOrderElements = inOrder.traverse(this);
        return inOrderElements.iterator();

    }
}
