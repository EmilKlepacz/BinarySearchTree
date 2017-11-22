package com.klepacz.emil.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst implements TreeTraversal {
    @Override
    public <T extends Comparable<T>> List<T> traverse(Tree<T> tree) {
        List<T> elementsList = new ArrayList<T>();
        Queue<Tree> queue = new LinkedList<>();

        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree<T> currentTree = queue.remove();
            elementsList.add(currentTree.getValue());

            if (currentTree.getLeftTree().isPresent()) {
                queue.add(currentTree.getLeftTree().get());

            }

            if (currentTree.getRightTree().isPresent()) {
                queue.add(currentTree.getRightTree().get());
            }
        }
        return elementsList;
    }
}
