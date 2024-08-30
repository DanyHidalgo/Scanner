package scanner;

import java.io.IOException;
import java.io.Reader;
import java_cup.runtime.Symbol;
import parser.sym;
import opt.Algebraic;
import opt.ConstantF;

%%

%public
%class Scanner
%unicode
%cup
%line
%column

%{
    // Variables para rastrear la línea y la columna actuales
    private int currentLine = 1;

    private int currentColumn = 1;

    // Método para ajustar la posición actual
    private void adjustPosition(String text) {
        for (char character : text.toCharArray()) {
            if (character == '\n') {
                currentLine++;
                currentColumn = 1;
            } else {
                currentColumn++;
            }
        }
    }

    // Métodos para obtener la línea y columna actuales
    public int getLine() {
        return currentLine;
    }

    public int getColumn() {
        return currentColumn;
    }

    // Método para generar un símbolo con su valor
    private Symbol generateSymbol(int type, String value) {
        return new Symbol(type, getLine(), getColumn(), value);
    }

    // Clase para manejar mensajes de error
    public static class ErrorHandler {
        public static void reportError(String message, int line, int column) {
            System.err.println("Error en la línea " + line + ", columna " + column + ": " + message);
        }
    }
%}

%%

// Ignorar espacios en blanco
\s+ {
    adjustPosition(yytext()); 
    /* Ignorar espacios */
}

// Palabras reservadas
"if" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.IF, "if"); 
}

"else" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.ELSE, "else"); 
}

"while" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.WHILE, "while"); 
}

"for" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.FOR, "for"); 
}

"int" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.INT, "int"); 
}

"float" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.FLOAT, "float"); 
}

"boolean" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.BOOLEAN, "boolean"); 
}

"true" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.TRUE, "true"); 
}

"false" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.FALSE, "false"); 
}

"public" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.PUBLIC, "public"); 
}

"private" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.PRIVATE, "private"); 
}

"protected" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.PROTECTED, "protected"); 
}

"void" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.VOID, "void"); 
}

"return" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.RETURN, "return"); 
}

// Operadores y delimitadores
"=" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.EQUALS, "="); 
}

"==" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.EQUALS_EQUALS, "=="); 
}

"!=" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.NOT_EQUALS, "!="); 
}

"<" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.LESS_THAN, "<"); 
}

"<=" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.LESS_THAN_EQUALS, "<="); 
}

">" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.GREATER_THAN, ">"); 
}

">=" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.GREATER_THAN_EQUALS, ">="); 
}

"(" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.LPAREN, "("); 
}

")" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.RPAREN, ")"); 
}

"{" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.LBRACE, "{"); 
}

"}" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.RBRACE, "}"); 
}

";" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.SEMICOLON, ";"); 
}

"," {
    adjustPosition(yytext()); 
    return generateSymbol(sym.COMMA, ","); 
}

"[" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.LBRACKET, "["); 
}

"]" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.RBRACKET, "]"); 
}

"+" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.PLUS, "+"); 
}

"-" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.MINUS, "-"); 
}

"*" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.MULTIPLY, "*"); 
}

"/" {
    adjustPosition(yytext()); 
    return generateSymbol(sym.DIVIDE, "/"); 
}

// Literales
[0-9]+ { 
    adjustPosition(yytext()); 
    String processedValue = Algebraic.processInteger(yytext());
    return generateSymbol(sym.INTLIT, processedValue); 
}

[0-9]*"."[0-9]+ { 
    adjustPosition(yytext()); 
    String processedValue = ConstantF.processFloat(yytext());
    return generateSymbol(sym.FLOATLIT, processedValue); 
}

// Manejo de literales de punto flotante mal formateados
[0-9]+\.[0-9]* { 
    adjustPosition(yytext());
    ErrorHandler.reportError("Literal de punto flotante mal formateado: " + yytext(), getLine(), getColumn()); 
}

// Identificadores
[a-zA-Z_][a-zA-Z0-9_]* { 
    adjustPosition(yytext()); 
    return generateSymbol(sym.IDENTIFIER, yytext()); 
}

// Literales de cadena
\"([^\"]|\\.)*\" { 
    adjustPosition(yytext()); 
    return generateSymbol(sym.STRINGLIT, yytext()); 
}

// Manejo de caracteres ilegales
. { 
    adjustPosition(yytext());
    ErrorHandler.reportError("Carácter ilegal: " + yytext(), getLine(), getColumn()); 
}
