package com.example;

public final class UnaryOp extends ExpressionOperation {

    private final Integer value;

    public UnaryOp(Integer value) {
        super(null, null);
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    @Override
    public void accept(ExpressionEvaluator visitor) {
        visitor.visit(this);
    }

}
