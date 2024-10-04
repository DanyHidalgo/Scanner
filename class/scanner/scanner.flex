package scanner;

import java.io.Reader;
import java.io.IOException;

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
"class" |
"else" |
"false" |
"for" |
"if" |
"int" |
"return" |
"Program" |
"true" |
"void" |
"while" |
"this" |
"new" |
"null" |
"public" |
"private" |
"static" |
"break" |
"continue" |
"float" |
"callout" |
"boolean"   { return "Reservada: " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }

/* Operadores y símbolos */
"=="        { return "EQUAL  " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"!="        { return "NOT EQUAL " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"<="        { return "LESS/EQUAL THAN " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
">="        { return "GREATER/EQUAL THAN " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"&&"        { return "AND " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"||"        { return "OR " + yytext() + " linea: " + yyline + " columna: " + yycolumn; } 
"="         { return "ASSIGN " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"+"         { return "ADD " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"-"         { return " SUB " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"*"         { return "MULTIPLY " + yytext() + " linea: " + yyline + " columna: " + yycolumn; } 
"/"         { return "DIVIDE " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"<"         { return "LESS THAN " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
">"         { return "GREATER THAN " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"!"         { return "NOT " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"{"         { return "BRACE_A " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"}"         { return "BRACE_B " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
"("         { return "PAREN_A " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
")"         { return "PAREN_B " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
","         { return "COMMA " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }
";"         { return "SEMICOLON " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }

/* Ignorar espacios en blanco */
[ \t\r\n]+   { /* ignorar */ }

/* Números enteros */
{DIGIT}+  { return "int: " + yytext() + " linea: " + yyline + " columna: " + yycolumn; } 

/* Números de punto flotante */
{DIGIT}+("."{DIGIT}+)?  { return "float: " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }


/* Identificadores */
{MAYUSCULA}({ALPHANUM})*    { return "Error: id no puede iniciar con mayuscula: " + yytext()  + " linea: " + yyline + " columna: " + yycolumn; }
{ALPHA}({ALPHANUM})*  { return "id: " + yytext()  + " linea: " + yyline + " columna " + yycolumn; }
{DIGIT}({ALPHANUM})*    { return "Error: id no puede iniciar con numero: " + yytext() + " linea: " + yyline + " columna: " + yycolumn; }


/* Comentarios */
// Simple line comment
"//"[^(\r|\n)]* { /* ignorar comentarios de línea */ }

// Block comment
"/*"([^*]|\*+[^*/])*\*+\/ { /* ignorar comentarios de bloque */ }


/* Manejar caracteres desconocidos */
.  { return "Carácter desconocido " + yytext() + "linea: " + yyline + "columna: " + yycolumn; }