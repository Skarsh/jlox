package com.craftinginterpreters.lox;

import java.util.Objects;

public class Token {
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    public Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexeme + " " + literal;
    }

    public boolean compare(Token other) {
        return  this.type == other.type
                && Objects.equals(this.lexeme, other.lexeme)
                && Objects.equals(this.literal, other.literal)
                && this.line == other.line;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public Object getLiteral() {
        return literal;
    }

    public int getLine() {
        return line;
    }
}
