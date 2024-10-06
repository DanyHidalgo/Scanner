// Paquete
package parser;

// Importaciones necesarias
import java_cup.runtime.*;

// Declaraciones de símbolos (terminales)
terminal INT, ID, IF, RETURN, NUM, PLUS, LESS_THAN_EQUALS, EQUALS_EQUALS, NOT_EQUALS, GREATER_THAN;
terminal GREATER_THAN_EQUALS, LPAREN, RPAREN, LBRACKET, RBRACKET, LBRACE, RBRACE, COMMA, MINUS, MULTIPLY;
terminal DIVIDE, MOD, INTLIT, STRINGLIT, FLOATLIT, ELSE, TRUE, FALSE, FLOAT, WHILE, PUBLIC, BOOLEAN;
terminal PRIVATE, PROTECTED, VOID, FOR, LESS_THAN, EQUALS, IDENTIFIER, SEMICOLON;
terminal NOT, PAREN_A, PAREN_B, BRACE_A, BRACE_B, AND, OR, NEW, NULL, THIS, BREAK, CLASS, STATIC, CALLOUT, CONTINUE;
terminal DOT;

// Declaraciones de no terminales
non terminal Program, Statement, Expression, Term, Factor, Identifier, Type, FieldDecl, FieldDecls, MethodDecls, MethodDecl, ParamList, Param, Block, VarDecl, VarDecls, Statements;

// Precedencia
precedence right ELSE;
precedence left PLUS, MINUS;
precedence left MULTIPLY, DIVIDE;

// Regla inicial
start with Program;

// Reglas de producción
Program ::=
    CLASS ID LBRACE FieldDecls MethodDecls RBRACE;

FieldDecls ::=
    FieldDecl
    | FieldDecl FieldDecls;

MethodDecls ::=
    MethodDecl
    | MethodDecl MethodDecls;

MethodDecl ::=
    Type ID LPAREN ParamList RPAREN Block
    | VOID ID LPAREN ParamList RPAREN Block;

ParamList ::=
    Param
    | Param COMMA ParamList
    | /* producción vacía */;

Param ::=
    Type ID;

Statement ::=
    IF LPAREN Expression RPAREN Block ELSE Block
  | IF LPAREN Expression RPAREN Block
  | FOR ID EQUALS Expression COMMA Expression Block
  | RETURN Expression SEMICOLON
  | RETURN SEMICOLON
  | Block;

Block ::=
    LBRACE VarDecls Statements RBRACE;

VarDecls ::=
    VarDecl
    | VarDecl VarDecls
    | /* producción vacía */;

Statements ::=
    Statement
    | Statement Statements
    | /* producción vacía */;

Expression ::=
    Expression PLUS Term
    | Expression MINUS Term
    | Term;

Term ::=
    Term MULTIPLY Factor
    | Term DIVIDE Factor
    | Term MOD Factor
    | Factor;

Factor ::=
    LPAREN Expression RPAREN
    | INTLIT
    | FLOATLIT
    | STRINGLIT
    | ID
    | ID LBRACKET Expression RBRACKET;

Identifier ::=
    ID;

Type ::=
    INT 
    | BOOLEAN
    | FLOAT;
