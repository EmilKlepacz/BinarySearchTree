package com.klepacz.emil.tree.test;


import com.klepacz.emil.tree.PreOrder;
import com.klepacz.emil.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PreOrderTest {
    private static final Tree<Integer> oneElementTreeWithFiveAsAValue = new Tree<>(5);

    @Test
    public void shouldReturnListWithOneElementForTreeWithOnlyRoot() {
        PreOrder preOrder = new PreOrder();
        List<Integer> elements = preOrder.traverse(oneElementTreeWithFiveAsAValue);
        assertThat(elements).isEqualTo(Arrays.asList(5));
    }

    @Test
    public void shouldReturnListWithElementsFromTreeInPreOrder() {
        Tree<Integer> tree = new Tree<>(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(2);
        tree.insert(3);

        PreOrder preOrder = new PreOrder();
        List<Integer> elements = preOrder.traverse(tree);

        assertThat(elements).isEqualTo(Arrays.asList(5, 4, 2, 3, 6, 7));
    }

}