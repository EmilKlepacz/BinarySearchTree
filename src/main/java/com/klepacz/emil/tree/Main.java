package com.klepacz.emil.tree;


public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>(10);
        tree.insert(11);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        for (int element: tree) {
            System.out.println(element);
        }
    }

}
