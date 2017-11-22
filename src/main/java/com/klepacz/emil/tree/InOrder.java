package com.klepacz.emil.tree;

import java.util.ArrayList;
import java.util.List;


public class InOrder implements TreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(Tree<T> tree) {
        List<T> elementsList = new ArrayList<T>();

        if (tree.getLeftTree().isPresent()) {
            elementsList.addAll(traverse(tree.getLeftTree().get()));

        }
        elementsList.add(tree.getValue());

        if (tree.getRightTree().isPresent()) {
            elementsList.addAll(traverse(tree.getRightTree().get()));
        }

        return elementsList;
    }
}
