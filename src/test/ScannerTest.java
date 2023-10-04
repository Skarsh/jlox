package test;

import com.craftinginterpreters.lox.Scanner;
import com.craftinginterpreters.lox.Token;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.craftinginterpreters.lox.TokenType.*;
import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    Scanner scanner;
    @BeforeEach
    public void initialize() {
    }

    @Test
    public void testScanIdentifiers() throws IOException {
        Path fileName = Path.of("./jlox-tests/scanning/identifiers.lox");
        String source = Files.readString(fileName);

        this.scanner = new Scanner(source);
        this.scanner.scanTokens();
        List<Token> actualTokens = this.scanner.getTokens();

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(IDENTIFIER, "andy", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "formless", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "fo", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "_", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "_123", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "_abc", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "ab123", null, 0));
        expectedTokens.add(new Token(IDENTIFIER, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_", null, 1));
        expectedTokens.add(new Token(EOF, "", null, 11));

        for (int i = 0; i < actualTokens.size(); i++) {
            assertTrue(actualTokens.get(i).compare(expectedTokens.get(i)));
        }
    }

    @Test
    public void testScanKeywords() throws IOException {
        Path fileName = Path.of("./jlox-tests/scanning/keywords.lox");
        String source = Files.readString(fileName);

        this.scanner = new Scanner(source);
        this.scanner.scanTokens();
        List<Token> actualTokens = this.scanner.getTokens();

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(AND, "and", null, 0));
        expectedTokens.add(new Token(CLASS, "class", null, 0));
        expectedTokens.add(new Token(ELSE, "else", null, 0));
        expectedTokens.add(new Token(FALSE, "false", null, 0));
        expectedTokens.add(new Token(FOR, "for", null, 0));
        expectedTokens.add(new Token(FUN, "fun", null, 0));
        expectedTokens.add(new Token(IF, "if", null, 0));
        expectedTokens.add(new Token(NIL, "nil", null, 0));
        expectedTokens.add(new Token(OR, "or", null, 0));
        expectedTokens.add(new Token(RETURN, "return", null, 0));
        expectedTokens.add(new Token(SUPER, "super", null, 0));
        expectedTokens.add(new Token(THIS, "this", null, 0));
        expectedTokens.add(new Token(TRUE, "true", null, 0));
        expectedTokens.add(new Token(VAR, "var", null, 0));
        expectedTokens.add(new Token(WHILE, "while", null, 0));
        expectedTokens.add(new Token(EOF, "", null, 17));

        for (int i = 0; i < actualTokens.size(); i++) {
            assertTrue(actualTokens.get(i).compare(expectedTokens.get(i)));
        }
    }

    @Test
    public void testScanNumbers() throws IOException {
        Path fileName = Path.of("./jlox-tests/scanning/numbers.lox");
        String source = Files.readString(fileName);

        this.scanner = new Scanner(source);
        this.scanner.scanTokens();
        List<Token> actualTokens = this.scanner.getTokens();

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(NUMBER, "123", 123.0, 0));
        expectedTokens.add(new Token(NUMBER, "123.456", 123.456, 1));
        expectedTokens.add(new Token(DOT, ".", null, 2));
        expectedTokens.add(new Token(NUMBER, "456", 456.0, 2));
        expectedTokens.add(new Token(NUMBER, "123", 123.0, 3));
        expectedTokens.add(new Token(DOT, ".", null, 3));
        expectedTokens.add(new Token(EOF, "", null, 11));

        for (int i = 0; i < actualTokens.size(); i++) {
            assertTrue(actualTokens.get(i).compare(expectedTokens.get(i)));
        }
    }

    @Test
    public void testScanPunctuators() throws IOException {
        Path fileName = Path.of("./jlox-tests/scanning/punctuators.lox");
        String source = Files.readString(fileName);

        this.scanner = new Scanner(source);
        this.scanner.scanTokens();
        List<Token> actualTokens = this.scanner.getTokens();

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(LEFT_PAREN, "(", null, 0));
        expectedTokens.add(new Token(RIGHT_PAREN, ")", null, 0));
        expectedTokens.add(new Token(LEFT_BRACE, "{", null, 0));
        expectedTokens.add(new Token(RIGHT_BRACE, "}", null, 0));
        expectedTokens.add(new Token(SEMICOLON, ";", null, 0));
        expectedTokens.add(new Token(COMMA, ",", null, 0));
        expectedTokens.add(new Token(PLUS, "+", null, 0));
        expectedTokens.add(new Token(MINUS, "-", null, 0));
        expectedTokens.add(new Token(STAR, "*", null, 0));
        expectedTokens.add(new Token(BANG_EQUAL, "!=", null, 0));
        expectedTokens.add(new Token(EQUAL_EQUAL, "==", null, 0));
        expectedTokens.add(new Token(LESS_EQUAL, "<=", null, 0));
        expectedTokens.add(new Token(GREATER_EQUAL, ">=", null, 0));
        expectedTokens.add(new Token(BANG_EQUAL, "!=", null, 0));
        expectedTokens.add(new Token(LESS, "<", null, 0));
        expectedTokens.add(new Token(GREATER, ">", null, 0));
        expectedTokens.add(new Token(SLASH, "/", null, 0));
        expectedTokens.add(new Token(DOT, ".", null, 0));
        expectedTokens.add(new Token(EQUAL, "=", null, 0));
        expectedTokens.add(new Token(BANG, "!", null, 0));
        expectedTokens.add(new Token(EOF, "", null, 22));

        for (int i = 0; i < actualTokens.size(); i++) {
            assertTrue(actualTokens.get(i).compare(expectedTokens.get(i)));
        }
    }

}