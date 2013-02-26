package com.example;

import junit.framework.Assert;
import org.parboiled.Parboiled;
import org.parboiled.test.ParboiledTest;
import org.testng.annotations.Test;

@Test
public class ExpressionParserTest extends ParboiledTest {

    @Override
    protected void fail(String message) {
        Assert.fail(message);
    }

    @Override
    protected void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    public void twoAddTwo() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "2+2").hasNoErrors();
    }

    public void twoMultiplyTwo() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "2*2").hasNoErrors();
    }

    public void oneAddTwoMultiplyThree() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "1+2*3").hasNoErrors();
    }

    public void addTwo() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "+2").hasErrors("Invalid input '+', expected Input (line 1, pos 1):\n+2\n^\n");
    }

    public void twoAddTwoAdd() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "2+2+").hasErrors("Invalid input 'EOI', expected Multiplication (line 1, pos 5):\n2+2+\n    ^\n");
    }

    public void twoMultiplyTwoMultiply() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        test(parser.Input(), "2*2*").hasErrors("Invalid input 'EOI', expected Number (line 1, pos 5):\n2*2*\n    ^\n");
    }

}
