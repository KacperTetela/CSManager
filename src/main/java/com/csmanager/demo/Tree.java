package com.csmanager.demo;

public class Tree {

    private TreeDisplayStrategy treeDisplayStrategy;

    public Tree() {
        treeDisplayStrategy = new AutumnStrategy();
    }

    public void display() {
        treeDisplayStrategy.display();
    }

    public void setTreeDisplayStrategy(TreeDisplayStrategy treeDisplayStrategy) {
        this.treeDisplayStrategy = treeDisplayStrategy;
    }
}

class Main{
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.display();
        tree.setTreeDisplayStrategy(new WinterStrategy());
        tree.display();
    }
}
