package ast;

public class IfNode extends StatementNode {
    private ExprNode condition;
    private BlockNode thenBlock;
    private BlockNode elseBlock;

    // Constructor con validación
    public IfNode(ExprNode condition, BlockNode thenBlock, BlockNode elseBlock) {
        if (condition == null) {
            throw new IllegalArgumentException("La condición no puede ser nula.");
        }
        if (thenBlock == null) {
            throw new IllegalArgumentException("El bloque 'then' no puede ser nulo.");
        }
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        String nodeName = "IfNode" + hashCode(); // Aseguramos un nombre único para el nodo

        // Representamos el nodo IfNode
        sb.append(nodeName).append(" [label=\"if\"];\n");

        // Añadir la condición y el bloque 'then'
        sb.append(condition.toDot());
        sb.append(thenBlock.toDot());

        // Generar relaciones
        sb.append(nodeName).append(" -> ").append(condition.hashCode()).append(";\n");
        sb.append(nodeName).append(" -> ").append(thenBlock.hashCode()).append(";\n");

        // Si existe un bloque 'else', agregarlo y generar la relación
        if (elseBlock != null) {
            sb.append(elseBlock.toDot());
            sb.append(nodeName).append(" -> ").append(elseBlock.hashCode()).append(";\n");
        }

        return sb.toString();
    }

    // Métodos getter
    public ExprNode getCondition() {
        return condition;
    }

    public BlockNode getThenBlock() {
        return thenBlock;
    }

    public BlockNode getElseBlock() {
        return elseBlock;
    }

    @Override
    public String toString() {
        return "IfNode { condition=" + condition + ", thenBlock=" + thenBlock + ", elseBlock=" + (elseBlock != null ? elseBlock : "null") + " }";
    }
}
