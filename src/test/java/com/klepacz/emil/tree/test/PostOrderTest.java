package com.klepacz.emil.tree.test;

import com.klepacz.emil.tree.PostOrder;
import com.klepacz.emil.tree.PreOrder;
import com.klepacz.emil.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by emil_k on 2017-11-22.
 */
public class PostOrderTest {
    @Test
    public void shouldReturnListWithElementsFromTreeWithElementsInPostOrder() {
        Tree<Integer> tree = new Tree<>(5);
        tree.insert(10);
        tree.insert(4);
        tree.insert(6);
        tree.insert(11);

        PostOrder postOrder = new PostOrder();
        List<Integer> elements = postOrder.traverse(tree);

        assertThat(elements).isEqualTo(Arrays.asList(4, 6, 11,10,5));
    }
}
