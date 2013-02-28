package com.example;

import org.parboiled.trees.ImmutableBinaryTreeNode;

public class UnaryOp extends ImmutableBinaryTreeNode<UnaryOp> implements ValueOp {

    private Integer value;

    public UnaryOp(Integer value) {
        super(null, null);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
