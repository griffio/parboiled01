package com.example;

public class AdditionOp extends BinaryOp implements ValueOp {

    public AdditionOp(ValueOp left, ValueOp right) {
        super(new UnaryOp(left.getValue()), new UnaryOp(right.getValue()));
    }

    protected Integer add() {
        return left().getValue() + right().getValue();
    }

    @Override
    public Integer getValue() {
        return add();
    }
}
