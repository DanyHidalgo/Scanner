package ast;

public class ParenExprNode extends ExprNode {
    private ExprNode expr;

    public ParenExprNode(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public String toDot() {
        return "ParenExprNode [label=\"(\"];\n" +
               expr.toDot() +
               "ParenExprNode [label=\")\"];\n";  // Cerramos el paréntesis
    }

    // Getter
    public ExprNode getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return "ParenExprNode { expr=" + expr.toString() + " }";
    }
}
