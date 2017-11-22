package com.klepacz.emil.tree.test;

import com.klepacz.emil.tree.BreadthFirst;
import com.klepacz.emil.tree.PreOrder;
import com.klepacz.emil.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BreadthFirstTest {
    @Test
    public void shouldReturnListWithElementsFromTreeInBreathFirst() {
        Tree<Integer> tree = new Tree<>(5);
        tree.insert(6);
        tree.insert(4);

        BreadthFirst  breadthFirst = new BreadthFirst();
        List<Integer> elements = breadthFirst.traverse(tree);

        assertThat(elements).isEqualTo(Arrays.asList(5, 4, 6));
    }
}
