package scanner;

import parser.sym;
import java.io.Reader;
import java.io.IOException;
import java_cup.runtime.Symbol;

%%
// Definir las opciones de JFlex
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
"class"        { return new Symbol(sym.CLASS, yytext() + " linea " + yyline + " columna " + yycolumn); }
"def"        { return new Symbol(sym.DEF, yytext() + " linea " + yyline + " columna " + yycolumn); }
"else"         { return new Symbol(sym.ELSE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"false"        { return new Symbol(sym.FALSE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"Program"      { return new Symbol(sym.ID, yytext() + " linea " + yyline + " columna " + yycolumn); }
"for"          { return new Symbol(sym.FOR, yytext() + " linea " + yyline + " columna " + yycolumn); }
"if"           { return new Symbol(sym.IF, yytext() + " linea " + yyline + " columna " + yycolumn); }
"int"          { return new Symbol(sym.INT, yytext() + " linea " + yyline + " columna " + yycolumn); }
"return"       { return new Symbol(sym.RETURN, yytext() + " linea " + yyline + " columna " + yycolumn); }
"true"         { return new Symbol(sym.TRUE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"void"         { return new Symbol(sym.VOID, yytext() + " linea " + yyline + " columna " + yycolumn); }
"while"        { return new Symbol(sym.WHILE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"this"         { return new Symbol(sym.THIS, " linea " + yyline + " columna " + yycolumn); }
"public"       { return new Symbol(sym.PUBLIC, " linea " + yyline + " columna " + yycolumn); }
"private"      { return new Symbol(sym.PRIVATE, " linea " + yyline + " columna " + yycolumn); }
"null"         { return new Symbol(sym.NULL, " linea " + yyline + " columna " + yycolumn); }
"new"          { return new Symbol(sym.NEW, yytext() + " linea " + yyline + " columna " + yycolumn); }
"break"        { return new Symbol(sym.BREAK, yytext() + " linea " + yyline + " columna " + yycolumn); }
"continue"     { return new Symbol(sym.CONTINUE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"callout"      { return new Symbol(sym.CALLOUT, yytext() + " linea " + yyline + " columna " + yycolumn); }
"boolean"      { return new Symbol(sym.BOOLEAN, yytext() + " linea " + yyline + " columna " + yycolumn); }

/* Operadores y símbolos */
"=="           { return new Symbol(sym.EQ, yytext() + " linea " + yyline + " columna " + yycolumn); }
"!="           { return new Symbol(sym.NEQ, yytext() + " linea " + yyline + " columna " + yycolumn); }
"<="           { return new Symbol(sym.LE, yytext() + " linea " + yyline + " columna " + yycolumn); }
">="           { return new Symbol(sym.GE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"&&"           { return new Symbol(sym.AND, yytext() + " linea " + yyline + " columna " + yycolumn); }
"||"           { return new Symbol(sym.OR, yytext() + " linea " + yyline + " columna " + yycolumn); }
"="            { return new Symbol(sym.ASSIGN, yytext() + " linea " + yyline + " columna " + yycolumn); }
"+"            { return new Symbol(sym.PLUS, yytext() + " linea " + yyline + " columna " + yycolumn); }
"-"            { return new Symbol(sym.MINUS, yytext() + " linea " + yyline + " columna " + yycolumn); }
"*"            { return new Symbol(sym.TIMES, yytext() + " linea " + yyline + " columna " + yycolumn); }
"/"            { return new Symbol(sym.DIVIDE, yytext() + " linea " + yyline + " columna " + yycolumn); }
"<"            { return new Symbol(sym.LT, yytext() + " linea " + yyline + " columna " + yycolumn); }
">"            { return new Symbol(sym.GT, yytext() + " linea " + yyline + " columna " + yycolumn); }
"!"            { return new Symbol(sym.NOT, yytext() + " linea " + yyline + " columna " + yycolumn); }
"{"            { return new Symbol(sym.LBRACKET, yytext() + " linea " + yyline + " columna " + yycolumn); }
"}"            { return new Symbol(sym.RBRACKET, yytext() + " linea " + yyline + " columna " + yycolumn); }
"("            { return new Symbol(sym.LPAREN, yytext() + " linea " + yyline + " columna " + yycolumn); }
")"            { return new Symbol(sym.RPAREN, yytext() + " linea " + yyline + " columna " + yycolumn); }
","            { return new Symbol(sym.COMMA, yytext() + " linea " + yyline + " columna " + yycolumn); }
";"            { return new Symbol(sym.SEMI, yytext() + " linea " + yyline + " columna " + yycolumn); }



/* Literales */
{DIGIT}+       { return new Symbol(sym.INT_LITERAL, yytext() + " linea " + yyline + " columna " + yycolumn); }
\'{ALPHA}\'    { return new Symbol(sym.CHAR_LITERAL, yytext() + " linea " + yyline + " columna " + yycolumn); }

/* Identificadores */
{ALPHA}({ALPHANUM})*  { return new Symbol(sym.ID, yytext() + " linea " + yyline + " columna " + yycolumn); }

/* Ignorar espacios y comentarios */
[ \t\r\n]+     { /* ignorar espacios */ }
"//".*         { /* ignorar comentarios de una línea */ }
"/*"([^*]|[*][^/])*"*/" { /* ignorar comentarios de bloque */ }

/* Literales de cadena */
\"([^\\\"]|\\.)*\" { return new Symbol(sym.STRING_LITERAL, yytext() + " linea " + yyline + " columna " + yycolumn); }


/* Manejo de errores */
.              { System.err.println("Error léxico en linea " + yyline + " columna " + yycolumn + ": " + yytext()); }
