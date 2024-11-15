package ast;

public interface AST {
    void accept(ASTVisitor v);
}