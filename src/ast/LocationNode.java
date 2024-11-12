package ast;

public class LocationNode extends ASTNode {
    private String id;  // Identificador de la ubicación
    private ExprNode expr;  // Expresión asociada (puede ser nula)

    public LocationNode(String id, ExprNode expr) {
        super();  // Llamada al constructor de ASTNode, que asigna el id
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationNode [label=\"").append(id);
        
        // Añadir la expresión si existe
        if (expr != null) {
            sb.append(" ").append(expr.toDot());
        }
        
        sb.append("\"];\n");
        return sb.toString();
    }

    public ExprNode getExpr() {
        return expr;
    }

    public void setExpr(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "LocationNode { id=" + id + ", expr=" + (expr != null ? expr : "null") + " }";
    }
}
