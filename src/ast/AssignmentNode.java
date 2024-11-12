package ast;

public class AssignmentNode extends StatementNode {
    private LocationNode location;
    private AssignOpNode assignOp;
    private ExprNode expr;

    public AssignmentNode(LocationNode location, AssignOpNode assignOp, ExprNode expr) {
        this.location = location;
        this.assignOp = assignOp;
        this.expr = expr;
    }

    @Override
    public String toDot() {
        // El nodo AssignmentNode en DOT
        StringBuilder dotRepresentation = new StringBuilder();
        String nodeName = "AssignmentNode" + hashCode(); // Aseguramos un nombre único para el nodo

        // Representamos el nodo AssignmentNode
        dotRepresentation.append(nodeName).append(" [label=\"Assignment\"];\n");

        // Generamos los nodos hijos
        dotRepresentation.append(location.toDot());
        dotRepresentation.append(assignOp.toDot());
        dotRepresentation.append(expr.toDot());

        // Establecemos las relaciones entre AssignmentNode y sus hijos
        dotRepresentation.append(nodeName).append(" -> ").append(location.hashCode()).append(";\n");
        dotRepresentation.append(nodeName).append(" -> ").append(assignOp.hashCode()).append(";\n");
        dotRepresentation.append(nodeName).append(" -> ").append(expr.hashCode()).append(";\n");

        return dotRepresentation.toString();
    }
}
