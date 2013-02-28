package com.example;

import junit.framework.Assert;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParsingResult;
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

    public void valueOfTwoMultiplyTwo() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ValueOp> result = new ReportingParseRunner<ValueOp>(parser.Input()).run("2*2");
        ValueOp op = result.parseTreeRoot.getValue();
        assertEquals(op.getValue(), 4);
    }

    public void valueOfTwoMultiplyTwoAddFour() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ValueOp> result = new ReportingParseRunner<ValueOp>(parser.Input()).run("2*2+4");
        ValueOp op = result.parseTreeRoot.getValue();
        assertEquals(op.getValue(), 8);
    }

    public void valueOfThreePlusTwoMultiplyFiveAddFour() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ValueOp> result = new ReportingParseRunner<ValueOp>(parser.Input()).run("3+2*5+4");
        ValueOp op = result.parseTreeRoot.getValue();
        assertEquals(op.getValue(), 17);
    }

}
