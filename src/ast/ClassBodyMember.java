package ast;

public interface ClassBodyMember {
    void accept(ASTVisitor visitor);
}
