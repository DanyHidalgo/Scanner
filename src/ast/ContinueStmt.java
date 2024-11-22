package ast;

public class ContinueStmt extends Statement {
    public ContinueStmt() {
        // Constructor vacío
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
