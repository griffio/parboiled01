package com.example;

public class AdditionOp extends ExpressionOperation {

    public AdditionOp(ExpressionOperation left, ExpressionOperation right) {
        super(left, right);
    }

    @Override
    public void accept(ExpressionEvaluator visitor) {
        visitor.visit(this);
    }

}
