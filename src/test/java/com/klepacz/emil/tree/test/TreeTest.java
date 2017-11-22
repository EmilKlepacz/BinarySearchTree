package com.klepacz.emil.tree.test;

import com.klepacz.emil.tree.Tree;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class TreeTest {

    private static final Tree<Integer> oneElementTreeWithFiveAsAValue = new Tree<>(5);

    @Test
    public void shouldTrowsExceptionForNullConstructorParameter() {
        assertThatThrownBy(() -> new Tree<>(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldNotThrowsExceptionForNotNullConstructorParameter() {
        assertThat(oneElementTreeWithFiveAsAValue.getValue()).isEqualTo(5);
    }

    @Test
    public void shouldThrowsExceptionForNullArgumentInInsert() {
        assertThatThrownBy(() -> oneElementTreeWithFiveAsAValue.insert(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Insert value can not be null");
    }

    @Test
    public void shouldThrowsExceptionForAlreadyExistingValueForInsert() {
        assertThatThrownBy(() -> oneElementTreeWithFiveAsAValue.insert(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value to insert already exist in tree");
    }

    @Test
    public void shouldInsertValueAsLeftTreeWithNullLeftTree() {
        oneElementTreeWithFiveAsAValue.insert(4);
        assertThat(oneElementTreeWithFiveAsAValue.getLeftTree().get().getValue()).isEqualTo(4);
    }

    @Test
    public void shouldInsertValueAsRightTreeWithNullLeftTree() {
        oneElementTreeWithFiveAsAValue.insert(6);
        assertThat(oneElementTreeWithFiveAsAValue.getRightTree().get().getValue()).isEqualTo(6);
    }

    @Test
    public void shouldReturnEmptyOptionalForValueDoesNotExistInTreeWithOnlyRoot(){
        assertThat(oneElementTreeWithFiveAsAValue.find(10)).isEqualTo(Optional.empty());
    }

    @Test
    public void shouldReturnNonEmptyOptionaWithExistingValueForValueDoesExistInTreeWithOnlyRoot(){
        assertThat(oneElementTreeWithFiveAsAValue.find(5)).isEqualTo(Optional.of(5));
    }

    @Test
    public void shouldReturnEmptyOptionalForValueDoesNotExistInTreeWithLeftExisting(){
        Tree<Integer> tree = new Tree<>(10);
        tree.insert(9);
        tree.insert(8);
        assertThat(tree.find(1)).isEqualTo(Optional.empty());
    }

    @Test
    public void shouldReturnNonEmptyOptionaWithExistingValueForValueDoesExistInTreeWithRightExisting(){
        Tree<Integer> tree = new Tree<>(10);
        tree.insert(11);
        tree.insert(12);
        assertThat(tree.find(5)).isEqualTo(Optional.empty());
    }



}