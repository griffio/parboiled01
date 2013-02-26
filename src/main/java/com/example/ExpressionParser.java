package com.example;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
public class ExpressionParser extends BaseParser<AstNode> {

    Rule Input() {
       return Sequence(Expression(), EOI);
    }

    Rule Expression() {
       return Sequence(Multiplication(), ZeroOrMore("+", Multiplication()));
    }

    Rule Multiplication() {
      return Sequence(Number(), ZeroOrMore("*", Number()));
    }

    Rule Number() {
        return OneOrMore(CharRange('0', '9'));
    }

}
