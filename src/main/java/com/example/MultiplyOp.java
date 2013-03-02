package com.example;

public class MultiplyOp extends ExpressionOperation {

    public MultiplyOp(ExpressionOperation left, ExpressionOperation right) {
        super(left, right);
    }

    public void accept(ExpressionEvaluator visitor) {
        visitor.visit(this);
    }

}
