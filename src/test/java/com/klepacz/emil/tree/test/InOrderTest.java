package com.klepacz.emil.tree.test;


import com.klepacz.emil.tree.InOrder;
import com.klepacz.emil.tree.PostOrder;
import com.klepacz.emil.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InOrderTest {
    @Test
    public void shouldReturnListWithElementsFromTreeWithElementsInPostOrder() {
        Tree<Integer> tree = new Tree<>(5);
        tree.insert(10);
        tree.insert(4);
        tree.insert(3);
        tree.insert(6);
        tree.insert(11);

        InOrder inOrder = new InOrder();
        List<Integer> elements = inOrder.traverse(tree);

        assertThat(elements).isEqualTo(Arrays.asList(3,4,5,6,10,11));
    }
}
