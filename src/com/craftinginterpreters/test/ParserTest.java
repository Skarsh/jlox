package com.craftinginterpreters.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import com.craftinginterpreters.lox.*;

class ParserTest {
    Scanner scanner;
    Parser parser;

    @Test
    public void testParse() throws IOException {
        Path fileName = Path.of("./jlox-tests/parsing/parse.lox");
        String source = Files.readString(fileName);

        this.scanner = new Scanner(source);
        this.scanner.scanTokens();
        List<Token> tokens = scanner.getTokens();

        this.parser = new Parser(tokens);
        Expr parsedExpression = parser.parse();

        Expr expressionMinus3 = new Expr.Literal(3.0);
        Expr expressionMinus1 = new Expr.Literal(1.0);
        Token minusOperator = new Token(TokenType.MINUS, "-", null, 0);
        Expr exprMinus = new Expr.Binary(expressionMinus3, minusOperator, expressionMinus1);

        Expr innerGroup = new Expr.Grouping(exprMinus);

        Expr expressionMinus5 = new Expr.Literal(5.0);
        Expr outerExprMinus = new Expr.Binary(expressionMinus5, minusOperator, innerGroup);

        Expr outerGroup = new Expr.Grouping(outerExprMinus);

        Expr solo1 = new Expr.Literal(1.0);
        Expr soloMinus1 = new Expr.Unary(minusOperator, solo1);

        Token plusOperator = new Token(TokenType.PLUS, "+", null, 0);
        Expr expectedExpression = new Expr.Binary(outerGroup, plusOperator, soloMinus1);

        System.out.println(new AstPrinter().print(expectedExpression));
    }
}
