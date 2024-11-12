package ast;

public class CalloutArgNode extends ASTNode {
    private ExprNode expr;

    // Constructor que inicializa la expresión
    public CalloutArgNode(ExprNode expr) {
        // Asegúrate de que expr no sea nulo, ya que se espera que sea obligatorio
        if (expr == null) {
            throw new IllegalArgumentException("ExprNode no puede ser nulo.");
        }
        this.expr = expr;
    }

    @Override
    public String toDot() {
        // Si expr es null (aunque no debería), se previene el NPE
        return "CalloutArgNode [label=\"" + (expr != null ? expr.toDot() : "null") + "\"];\n";
    }

    @Override
    public String toString() {
        // Previene que expr sea null al llamar a toString
        return "CalloutArgNode { expr=" + (expr != null ? expr.toString() : "null") + " }";
    }

    // Getter para expr
    public ExprNode getExpr() {
        return expr;
    }
}
