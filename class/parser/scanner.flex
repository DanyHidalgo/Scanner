
/*scanner.flex*/
/* definir que jale todos aqui. osea que aqui lo integra para poder hacer el parser*/
/* hay que pasar todo aca para que use el scanner.flex y pareser.cup en un mismo dir.*/

package parser;

%{
   import java_cup.runtime.Symbol;
%}
%cup // Indica que se está utilizando con JavaCUP

import java.io.Reader;
import java.io.IOException;

%%
/* Definir las opciones de JFlex */
%public
%class Scanner
%unicode

%cup // Indica que se está utilizando con JavaCUP
%line
%column

/* Definir caracteres */
ALPHA=[a-zA-Z]
MAYUSCULA=[A-Z]
DIGIT=[0-9]
ALPHANUM=[a-zA-Z0-9]

%%

/* Palabras reservadas */
"class"        { return new Symbol(sym.CLASS); }
"else"         { return new Symbol(sym.ELSE); }
"false"        { return new Symbol(sym.FALSE); }
"for"          { return new Symbol(sym.FOR); }
"if"           { return new Symbol(sym.IF); }
"int"          { return new Symbol(sym.INT); }
"return"       { return new Symbol(sym.RETURN); }
"true"         { return new Symbol(sym.TRUE); }
"void"         { return new Symbol(sym.VOID); }
"while"        { return new Symbol(sym.WHILE); }
"this"         { return new Symbol(sym.THIS); }
"new"          { return new Symbol(sym.NEW); }
"null"         { return new Symbol(sym.NULL); }
"public"       { return new Symbol(sym.PUBLIC); }
"private"      { return new Symbol(sym.PRIVATE); }
"static"       { return new Symbol(sym.STATIC); }
"break"        { return new Symbol(sym.BREAK); }
"continue"     { return new Symbol(sym.CONTINUE); }
"float"        { return new Symbol(sym.FLOAT); }
"callout"      { return new Symbol(sym.CALLOUT); }
"boolean"      { return new Symbol(sym.BOOLEAN); }

/* Operadores y símbolos */
"=="           { return new Symbol(sym.EQUALS_EQUALS); }
"!="           { return new Symbol(sym.NOT_EQUALS); }
"<="           { return new Symbol(sym.LESS_THAN_EQUALS); }
">="           { return new Symbol(sym.GREATER_THAN_EQUALS); }
"&&"           { return new Symbol(sym.AND); }
"||"           { return new Symbol(sym.OR); }
"="            { return new Symbol(sym.EQUALS); }
"+"            { return new Symbol(sym.PLUS); }
"-"            { return new Symbol(sym.MINUS); }
"*"            { return new Symbol(sym.MULTIPLY); }
"/"            { return new Symbol(sym.DIVIDE); }
"<"            { return new Symbol(sym.LESS_THAN); }
">"            { return new Symbol(sym.GREATER_THAN); }
"!"            { return new Symbol(sym.NOT); }
"{"            { return new Symbol(sym.BRACE_A); }
"}"            { return new Symbol(sym.BRACE_B); }
"("            { return new Symbol(sym.PAREN_A); }
")"            { return new Symbol(sym.PAREN_B); }
","            { return new Symbol(sym.COMMA); }
";"            { return new Symbol(sym.SEMICOLON); }

/* Ignorar espacios en blanco */
[ \t\r\n]+     { /* ignorar */ }

/* Números enteros */
{DIGIT}+       { return new Symbol(sym.INTLIT, Integer.parseInt(yytext())); }

/* Números de punto flotante */
{DIGIT}+("."{DIGIT}+)?  { return new Symbol(sym.FLOATLIT, Float.parseFloat(yytext())); }

/* Identificadores */
{MAYUSCULA}({ALPHANUM})*    { return new Symbol(sym.error, "Error: id no puede iniciar con mayúscula: " + yytext()); }
{ALPHA}({ALPHANUM})*        { return new Symbol(sym.ID, yytext()); }
{DIGIT}({ALPHANUM})*        { return new Symbol(sym.error, "Error: id no puede iniciar con número: " + yytext()); }

/* Comentarios */
// Simple line comment
"//"[^(\r|\n)]* { /* ignorar comentarios de línea */ }

// Block comment
"/"([^]|\+[^/])\+"/" { /* ignorar comentarios de bloque */ }

/* Manejar caracteres desconocidos */
.  { return new Symbol(sym.error, "Carácter desconocido " + yytext() + " linea: " + yyline + " columna: " + yycolumn); }
