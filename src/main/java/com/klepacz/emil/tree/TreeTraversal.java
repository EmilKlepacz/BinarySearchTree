package com.klepacz.emil.tree;


import java.util.List;

public interface TreeTraversal {
    public <T extends Comparable<T>> List<T> traverse(Tree<T> tree);
}
