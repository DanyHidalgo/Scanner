package scanner;

import java.io.Reader;
import java.io.IOException;

%%
/* Definir las opciones de JFlex */
%public
%class Scanner
%unicode

/* Definir caracteres */
ALPHA=[a-zA-Z]
DIGIT=[0-9]
ALPHANUM=[a-zA-Z0-9]

%%

/* Palabras reservadas */
"if"        { return "Keyword: if"; }
"else"      { return "Keyword: else"; }
"while"     { return "Keyword: while"; }
"return"    { return "Keyword: return"; }
"int"       { return "Keyword: int"; }
"boolean"   { return "Keyword: boolean"; }
"true"      { return "Keyword: true"; }
"false"     { return "Keyword: false"; }

/* Operadores y símbolos */
"=="        { return "Operator: =="; }
"!="        { return "Operator: !="; }
"<="        { return "Operator: <="; }
">="        { return "Operator: >="; }
"&&"        { return "Operator: &&"; }
"||"        { return "Operator: ||"; }
"="         { return "Operator: ="; }
"+"         { return "Operator: +"; }
"-"         { return "Operator: -"; }
"*"         { return "Operator: *"; }
"/"         { return "Operator: /"; }
"<"         { return "Operator: <"; }
">"         { return "Operator: >"; }
"!"         { return "Operator: !"; }
"{"         { return "Symbol: {"; }
"}"         { return "Symbol: }"; }
"("         { return "Symbol: ("; }
")"         { return "Symbol: )"; }
";"         { return "Symbol: ;"; }
","         { return "Symbol: ,"; }

/* Identificadores */
{ALPHA}({ALPHANUM})*  { return "Identifier: " + yytext(); }

/* Números enteros */
{DIGIT}+  { return "Number: " + yytext(); }

/* Ignorar espacios en blanco */
[ \t\r\n]+   { /* ignorar */ }

/* Comentarios */
// Simple line comment
"//"[^(\r|\n)]* { /* ignorar comentarios de línea */ }

// Block comment
"/"([^]|\+[^/])\+"/" { /* ignorar comentarios de bloque */ }

/* Manejar caracteres desconocidos */
.  { return "Carácter desconocido: " + yytext(); }