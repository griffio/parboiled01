package com.example;

public interface ExpressionVisitor {

    void visit(ExpressionOperation operation);

    void visit(UnaryOp unaryOp);

    void visit(MultiplyOp operation);

    void visit(AdditionOp operation);
}
