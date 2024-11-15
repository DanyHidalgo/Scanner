package scanner;

import java.io.Reader;
import java.io.IOException;
import parser.sym;      // Importa la clase sym
import java_cup.runtime.Symbol; //usado por cup
import ast.*;


%%
// Definir las opciones de JFlex

%public
%class Scanner
%unicode
%line
%column
%type Symbol
%function next_token
%cup


/* Definir caracteres */
ALPHA=[a-zA-Z]
MAYUSCULA=[A-Z]
DIGIT=[0-9]
ALPHANUM=[a-zA-Z0-9]
HEX_LITERAL = 0[xX][0-9a-fA-F]+
CHAR_LITERAL = \' ( [^\'\\\n] | \\ [btnfr0\'\"\\] ) \'
STRING_LITERAL = \" ( [^\"\\\n] | \\ [btnfr0\'\"\\] )* \"

%%


/* Palabras reservadas */
"if"        { return new Symbol(sym.IF, yyline+1, yycolumn+1, "if"); }
"else"      { return new Symbol(sym.ELSE, yyline+1, yycolumn+1, "else"); }
"while"     { return new Symbol(sym.WHILE, yyline+1, yycolumn+1, "while"); }
"return"    { return new Symbol(sym.RETURN, yyline+1, yycolumn+1, "return"); }
"int"       { return new Symbol(sym.INT, yyline+1, yycolumn+1, "int"); }
"boolean"   { return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, "boolean"); }
"class"     { return new Symbol(sym.CLASS, yyline+1, yycolumn+1, "class");  }
"true"      { return new Symbol(sym.TRUE, yyline+1, yycolumn+1, "true"); }
"for"       { return new Symbol(sym.FOR, yyline+1, yycolumn+1, "for"); }
"false"     { return new Symbol(sym.FALSE, yyline+1, yycolumn+1, "false"); }
"void"     { return new Symbol(sym.VOID, yyline+1, yycolumn+1, "void"); }
"break"     { return new Symbol(sym.BREAK, yyline+1, yycolumn+1, "break"); }
"continue"     { return new Symbol(sym.CONTINUE, yyline+1, yycolumn+1, "continue"); }
"callout"     { return new Symbol(sym.CALLOUT, yyline+1, yycolumn+1, "callout"); }
"char"        { return new Symbol(sym.CHAR, yyline+1, yycolumn+1, "char"); }
"new"         { return new Symbol(sym.NEW, yyline+1, yycolumn+1, "new"); }

/* Operadores y símbolos */
"=="        { return new Symbol(sym.EQ, yyline+1, yycolumn+1, "=="); }
"+="        { return new Symbol(sym.PLUS_ASSIGN, yyline+1, yycolumn+1, "+="); }
"-="        { return new Symbol(sym.MINUS_ASSIGN, yyline+1, yycolumn+1, "-="); }
"!="        { return new Symbol(sym.NEQ, yyline+1, yycolumn+1, "!="); }
"<="        { return new Symbol(sym.LE, yyline+1, yycolumn+1, "<="); }
">="        { return new Symbol(sym.GE, yyline+1, yycolumn+1, ">="); }
"&&"        { return new Symbol(sym.AND, yyline+1, yycolumn+1, "&&"); }
"||"        { return new Symbol(sym.OR, yyline+1, yycolumn+1, "||"); }
"!"         { return new Symbol(sym.NOT, yyline+1, yycolumn+1, "!"); }
"="         { return new Symbol(sym.ASSIGN, yyline+1, yycolumn+1, "="); }
"+"         { return new Symbol(sym.PLUS, yyline+1, yycolumn+1, "+"); }
"-"         { return new Symbol(sym.MINUS, yyline+1, yycolumn+1, "-"); }
"*"         { return new Symbol(sym.TIMES, yyline+1, yycolumn+1, "*"); }
"/"         { return new Symbol(sym.DIVIDE, yyline+1, yycolumn+1, "/"); }
"<"         { return new Symbol(sym.LT, yyline+1, yycolumn+1, "<"); }
">"         { return new Symbol(sym.GT, yyline+1, yycolumn+1, ">"); }
"!"         { return new Symbol(sym.NOT, yyline+1, yycolumn+1, "!"); }
"{"         { return new Symbol(sym.LBRACE, yyline+1, yycolumn+1, "{"); }
"}"         { return new Symbol(sym.RBRACE, yyline+1, yycolumn+1, "}"); }
"("         { return new Symbol(sym.LPAREN, yyline+1, yycolumn+1, "("); }
")"         { return new Symbol(sym.RPAREN, yyline+1, yycolumn+1, ")"); }
"["         { return new Symbol(sym.LBRACKET, yyline+1, yycolumn+1, "["); }
"]"         { return new Symbol(sym.RBRACKET, yyline+1, yycolumn+1, "]"); }
","         { return new Symbol(sym.COMMA, yyline+1, yycolumn+1, ","); }
";"         { return new Symbol(sym.SEMI, yyline+1, yycolumn+1, ";"); }    
"%"         { return new Symbol(sym.MOD, yyline+1, yycolumn+1, "%"); } 


/* Literales */
{DIGIT}+    { return new Symbol(sym.INT_LITERAL, yyline+1, yycolumn+1, yytext()); }
{HEX_LITERAL}       { return new Symbol(sym.INT_LITERAL, yyline+1, yycolumn+1, yytext()); }

{CHAR_LITERAL}      { return new Symbol(sym.CHAR_LITERAL, yyline+1, yycolumn+1, yytext()); }
{STRING_LITERAL}    { return new Symbol(sym.STRING_LITERAL, yyline+1, yycolumn+1, yytext()); }


{DIGIT}({ALPHANUM})*     { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Error: id no puede iniciar con número: " + yytext()); }

/* Identificadores */
{ALPHA}({ALPHANUM})*  { return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext()); }


/* Ignorar espacios en blanco */
[ \t\r\n]+   { /* ignorar */ }


/* Ignorar espacios y comentarios */
"//".*         { /* ignorar comentarios de una línea */ }
"/*"([^*]|[*][^/])*"*/" { /* ignorar comentarios de bloque */ }

/* Manejar caracteres desconocidos */
.  { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Carácter desconocido: " + yytext()); }

/* Manejo EOF */
<<EOF>> { return null; }
