package com.craftinginterpreters.test;

import com.craftinginterpreters.lox.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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

        // System.out.println(new AstPrinter().print(expression));
    }
}
