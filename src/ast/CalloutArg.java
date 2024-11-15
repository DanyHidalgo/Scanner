package ast;

public abstract class CalloutArg extends Expression {
    public abstract void accept(ASTVisitor visitor);
}