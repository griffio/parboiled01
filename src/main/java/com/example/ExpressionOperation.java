package com.example;

import org.parboiled.trees.ImmutableBinaryTreeNode;

abstract class ExpressionOperation extends ImmutableBinaryTreeNode<ExpressionOperation> {

    ExpressionOperation(ExpressionOperation left, ExpressionOperation right) {
        super(left, right);
    }

    public abstract void accept(ExpressionEvaluator visitor);

}
