package ast;

public class BreakStmt extends Statement {
    public BreakStmt() {
        // Constructor vacío
    }

@Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
    
}
