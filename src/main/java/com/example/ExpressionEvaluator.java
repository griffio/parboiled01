package com.example;

import java.util.ArrayDeque;

public class ExpressionEvaluator implements ExpressionVisitor {

    private final ArrayDeque<Integer> deque;

    public ExpressionEvaluator() {
        this.deque = new ArrayDeque<Integer>();
    }

    void binary(ExpressionOperation operation) {
        operation.left().accept(this);
        operation.right().accept(this);
    }

    @Override
    public void visit(ExpressionOperation operation) {
        operation.accept(this);
    }

    @Override
    public void visit(UnaryOp unaryOp) {
        deque.add(unaryOp.value());
    }

    @Override
    public void visit(MultiplyOp operation) {
        binary(operation);
        deque.push(deque.removeLast() * deque.removeLast());
    }

    @Override
    public void visit(AdditionOp operation) {
        binary(operation);
        deque.push(deque.removeLast() + deque.removeLast());
    }

    public Integer getResult() {
        return deque.getFirst();
    }

}
