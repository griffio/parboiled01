package com.example;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
public class ExpressionParser extends BaseParser<ValueOp> {

    Rule Input() {
       return Sequence(Expression(),EOI);
    }

    Rule Expression() {
       return Sequence(Multiplication(), ZeroOrMore("+", Multiplication(), additionOp()));
    }

    Rule Multiplication() {
      return Sequence(Number(), ZeroOrMore("*", Number(), multiplicationOp()));
    }

    Rule Number() {
        return OneOrMore(CharRange('0', '9'), unaryOp());
    }

    public boolean unaryOp() {
        return push(new UnaryOp(Integer.parseInt(match())));
    }

    public boolean multiplicationOp() {
        ValueOp left = pop();
        ValueOp right = pop();
        return push(new MultiplyOp(left, right));
    }

    public boolean additionOp() {
        ValueOp left = pop();
        ValueOp right = pop();
        return push(new AdditionOp(left, right));
    }

}
