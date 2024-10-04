package scanner;

import parser.sym;
import java.io.Reader;
import java.io.IOException;
import java_cup.runtime.Symbol;

%%
/* Definir las opciones de JFlex */
%public
%class Scanner
%unicode

%column
%line

/* Definir caracteres */
ALPHA=[a-zA-Z]
MAYUSCULA=[A-Z]
DIGIT=[0-9]
ALPHANUM=[a-zA-Z0-9]

%%

/* Palabras reservadas */
"class"        { return new Symbol(sym.CLASS, " linea " + yyline + " columna " + yycolumn); }
"else"         { return new Symbol(sym.ELSE, " linea " + yyline + " columna " + yycolumn); }
"false"        { return new Symbol(sym.FALSE, " linea " + yyline + " columna " + yycolumn); }
"for"          { return new Symbol(sym.FOR, " linea " + yyline + " columna " + yycolumn); }
"if"           { return new Symbol(sym.IF, " linea " + yyline + " columna " + yycolumn); }
"int"          { return new Symbol(sym.INT, " linea " + yyline + " columna " + yycolumn); }
"return"       { return new Symbol(sym.RETURN, " linea " + yyline + " columna " + yycolumn); }
"Program"      { return new Symbol(sym.ID, yytext() + " linea " + yyline + " columna " + yycolumn); }
"true"         { return new Symbol(sym.TRUE, " linea " + yyline + " columna " + yycolumn); }
"void"         { return new Symbol(sym.VOID, " linea " + yyline + " columna " + yycolumn); }
"while"        { return new Symbol(sym.WHILE, " linea " + yyline + " columna " + yycolumn); }
"this"         { return new Symbol(sym.THIS, " linea " + yyline + " columna " + yycolumn); }
"new"          { return new Symbol(sym.NEW, " linea " + yyline + " columna " + yycolumn); }
"null"         { return new Symbol(sym.NULL, " linea " + yyline + " columna " + yycolumn); }
"public"       { return new Symbol(sym.PUBLIC, " linea " + yyline + " columna " + yycolumn); }
"private"      { return new Symbol(sym.PRIVATE, " linea " + yyline + " columna " + yycolumn); }
"static"       { return new Symbol(sym.STATIC, " linea " + yyline + " columna " + yycolumn); }
"break"        { return new Symbol(sym.BREAK, " linea " + yyline + " columna " + yycolumn); }
"continue"     { return new Symbol(sym.CONTINUE, " linea " + yyline + " columna " + yycolumn); }
"float"        { return new Symbol(sym.FLOAT, " linea " + yyline + " columna " + yycolumn); }
"callout"      { return new Symbol(sym.CALLOUT, " linea " + yyline + " columna " + yycolumn); }
"boolean"      { return new Symbol(sym.BOOLEAN, " linea " + yyline + " columna " + yycolumn); }

/* Operadores y símbolos */
"=="           { return new Symbol(sym.EQUALS_EQUALS, " linea " + yyline + " columna " + yycolumn); }
"!="           { return new Symbol(sym.NOT_EQUALS, " linea " + yyline + " columna " + yycolumn); }
"<="           { return new Symbol(sym.LESS_THAN_EQUALS, " linea " + yyline + " columna " + yycolumn); }
">="           { return new Symbol(sym.GREATER_THAN_EQUALS, " linea " + yyline + " columna " + yycolumn); }
"&&"           { return new Symbol(sym.AND, " linea " + yyline + " columna " + yycolumn); }
"||"           { return new Symbol(sym.OR, " linea " + yyline + " columna " + yycolumn); }
"="            { return new Symbol(sym.EQUALS, " linea " + yyline + " columna " + yycolumn); }
"+"            { return new Symbol(sym.PLUS, " linea " + yyline + " columna " + yycolumn); }
"-"            { return new Symbol(sym.MINUS, " linea " + yyline + " columna " + yycolumn); }
"*"            { return new Symbol(sym.MULTIPLY, " linea " + yyline + " columna " + yycolumn); }
"/"            { return new Symbol(sym.DIVIDE, " linea " + yyline + " columna " + yycolumn); }
"<"            { return new Symbol(sym.LESS_THAN, " linea " + yyline + " columna " + yycolumn); }
">"            { return new Symbol(sym.GREATER_THAN, " linea " + yyline + " columna " + yycolumn); }
"!"            { return new Symbol(sym.NOT, " linea " + yyline + " columna " + yycolumn); }
"{"            { return new Symbol(sym.BRACE_A, " linea " + yyline + " columna " + yycolumn); }
"}"            { return new Symbol(sym.BRACE_B, " linea " + yyline + " columna " + yycolumn); }
"("            { return new Symbol(sym.PAREN_A, " linea " + yyline + " columna " + yycolumn); }
")"            { return new Symbol(sym.PAREN_B, " linea " + yyline + " columna " + yycolumn); }
","            { return new Symbol(sym.COMMA, " linea " + yyline + " columna " + yycolumn); }
";"            { return new Symbol(sym.SEMICOLON, " linea " + yyline + " columna " + yycolumn); }

/* Números enteros */
{DIGIT}+       { return new Symbol(sym.INTLIT, Integer.parseInt(yytext()) + " linea " + yyline + " columna " + yycolumn); }

/* Números de punto flotante */
{DIGIT}+("."{DIGIT}+)?  { return new Symbol(sym.FLOATLIT, Float.parseFloat(yytext()) + " linea " + yyline + " columna " + yycolumn); }

/* Identificadores */
{MAYUSCULA}({ALPHANUM})*    { return new Symbol(sym.error, "Error: id no puede iniciar con mayuscula: " + yytext() + " linea " + yyline + " columna " + yycolumn); }
{ALPHA}({ALPHANUM})*        { return new Symbol(sym.ID, yytext() + " linea " + yyline + " columna " + yycolumn); }
{DIGIT}({ALPHANUM})*        { return new Symbol(sym.error, "Error: id no puede iniciar con numero: " + yytext() + " linea " + yyline + " columna " + yycolumn); }


/* Ignorar espacios en blanco */
[ \t\r\n]+    { /* ignorar */ }

/* Comentarios */
// Simple line comment
"//"[^(\r|\n)]* { /* ignorar comentarios de línea */ }

// Block comment
"/*"([^*]|\*+[^*/])*\*+\/ { /* ignorar comentarios de bloque */ }

/* Manejar caracteres desconocidos */
.  { return new Symbol(sym.error, "Carácter desconocido " + yytext() + " linea " + yyline + " columna " + yycolumn);}
