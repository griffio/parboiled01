package com.example;

import org.parboiled.trees.ImmutableBinaryTreeNode;

public abstract class BinaryOp extends ImmutableBinaryTreeNode<UnaryOp> implements ValueOp {

    public BinaryOp(UnaryOp left, UnaryOp right) {
        super(left, right);
    }

    @Override
    public abstract Integer getValue();

}
