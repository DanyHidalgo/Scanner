package scanner;

import java.io.Reader;
import java.io.IOException;
import parser.sym;      // Importa la clase sym
import java_cup.runtime.Symbol; //usado por cup


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
"false"     { return new Symbol(sym.FALSE, yyline+1, yycolumn+1, "false"); }

/* Operadores y símbolos */
"=="        { return new Symbol(sym.EQUALS_EQUALS, yyline+1, yycolumn+1, "=="); }
"!="        { return new Symbol(sym.NOT_EQUALS, yyline+1, yycolumn+1, "!="); }
"<="        { return new Symbol(sym.LESS_THAN_EQUALS, yyline+1, yycolumn+1, "<="); }
">="        { return new Symbol(sym.GREATER_THAN_EQUALS, yyline+1, yycolumn+1, ">="); }
"&&"        { return new Symbol(sym.AND, yyline+1, yycolumn+1, "&&"); }
"||"        { return new Symbol(sym.OR, yyline+1, yycolumn+1, "||"); }
"="         { return new Symbol(sym.ASSIGN, yyline+1, yycolumn+1, "="); }
"+"         { return new Symbol(sym.PLUS, yyline+1, yycolumn+1, "+"); }
"-"         { return new Symbol(sym.MINUS, yyline+1, yycolumn+1, "-"); }
"*"         { return new Symbol(sym.TIMES, yyline+1, yycolumn+1, "*"); }
"/"         { return new Symbol(sym.DIVIDE, yyline+1, yycolumn+1, "/"); }
"<"         { return new Symbol(sym.LESS_THAN, yyline+1, yycolumn+1, "<"); }
">"         { return new Symbol(sym.GREATER_THAN, yyline+1, yycolumn+1, ">"); }
"!"         { return new Symbol(sym.NOT, yyline+1, yycolumn+1, "!"); }
"{"         { return new Symbol(sym.LBRACE, yyline+1, yycolumn+1, "{"); }
"}"         { return new Symbol(sym.RBRACE, yyline+1, yycolumn+1, "}"); }
"("         { return new Symbol(sym.LPAREN, yyline+1, yycolumn+1, "("); }
")"         { return new Symbol(sym.RPAREN, yyline+1, yycolumn+1, ")"); }
","         { return new Symbol(sym.COMMA, yyline+1, yycolumn+1, ","); }
";"         { return new Symbol(sym.SEMICOLON, yyline+1, yycolumn+1, ";"); }    


/* Literales */
{DIGIT}+    { return new Symbol(sym.NUMBER, yyline+1, yycolumn+1, yytext()); }


{DIGIT}({ALPHANUM})*     { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Error: id no puede iniciar con número: " + yytext()); }

/* Identificadores */
{ALPHA}({ALPHANUM})*  { return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext()); }


/* Ignorar espacios en blanco */
[ \t\r\n]+   { /* ignorar */ }


/* Ignorar espacios y comentarios */
"//".*         { /* ignorar comentarios de una línea */ }
"/*"([^*]|[*][^/])*"*/" { /* ignorar comentarios de bloque */ }

/* Literales de cadena */
\"([^\\\"]|\\.)*\" { return new Symbol(sym.STRINGLIT, yyline+1, yycolumn+1, yytext()); }

/* Manejar caracteres desconocidos */
.  { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Carácter desconocido: " + yytext()); }

/* Manejo EOF */
<<EOF>> { return null; }
