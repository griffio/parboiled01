package com.example;

import junit.framework.Assert;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParsingResult;
import org.parboiled.test.ParboiledTest;
import org.testng.annotations.Test;

@Test
public class ExpressionEvaluatorTest extends ParboiledTest {

    @Override
    protected void fail(String message) {
        Assert.fail(message);
    }

    @Override
    protected void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(expected, actual);
    }

    public void valueOfTwoMultiplyTwo() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ExpressionOperation> result = new ReportingParseRunner<ExpressionOperation>(parser.Input()).run("2*2");
        ExpressionOperation op = result.parseTreeRoot.getValue();
        ExpressionEvaluator visitor = new ExpressionEvaluator();
        visitor.visit(op);

        assertEquals(visitor.getResult(), 4);
    }

    public void valueOfTwoMultiplyTwoAddFour() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ExpressionOperation> result = new ReportingParseRunner<ExpressionOperation>(parser.Input()).run("2*2+4");
        ExpressionOperation op = result.parseTreeRoot.getValue();
        ExpressionEvaluator visitor = new ExpressionEvaluator();
        visitor.visit(op);

        assertEquals(visitor.getResult(), 8);
    }

    public void valueOfThreePlusTwoMultiplyFiveAddFour() {
        ExpressionParser parser = Parboiled.createParser(ExpressionParser.class);
        ParsingResult<ExpressionOperation> result = new ReportingParseRunner<ExpressionOperation>(parser.Input()).run("3+2*5+4");
        ExpressionOperation op = result.parseTreeRoot.getValue();
        ExpressionEvaluator visitor = new ExpressionEvaluator();
        visitor.visit(op);

        assertEquals(visitor.getResult(), 17);
    }

}
