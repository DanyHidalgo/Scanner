package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para una instrucción `while`.
 */
public class WhileNode extends StatementNode {
    private ExprNode condition;  // Expresión que representa la condición del while
    private BlockNode block;     // Bloque de instrucciones que se ejecuta mientras la condición sea verdadera

    /**
     * Constructor para crear un nodo WhileNode.
     * Verifica que la condición y el bloque no sean nulos.
     * 
     * @param condition Expresión que representa la condición del while.
     * @param block Bloque de instrucciones asociadas al while.
     * @throws IllegalArgumentException Si la condición o el bloque son nulos.
     */
    public WhileNode(ExprNode condition, BlockNode block) {
        validateNotNull(condition, "La condición no puede ser nula");
        validateNotNull(block, "El bloque no puede ser nulo");
        this.condition = condition;
        this.block = block;
    }

    /**
     * Valida que el objeto no sea nulo. Lanza una excepción si lo es.
     * 
     * @param obj El objeto a validar.
     * @param message El mensaje de error en caso de que el objeto sea nulo.
     * @throws IllegalArgumentException Si el objeto es nulo.
     */
    private void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Genera la representación en formato DOT de un nodo `while` y sus componentes.
     * 
     * @return Representación en formato DOT del nodo `while`.
     */
    @Override
    public String toDot() {
    // Representación básica del nodo while
    StringBuilder sb = new StringBuilder();
    String nodeName = "WhileNode" + hashCode(); // Generamos un nombre único para el nodo

    // Representación del nodo WhileNode
    sb.append(nodeName).append(" [label=\"while\"];\n");

    // Generar el DOT para la condición y el bloque
    sb.append(condition.toDot());
    sb.append(block.toDot());

    // Relaciones entre el nodo WhileNode y sus hijos
    sb.append(nodeName).append(" -> ").append(condition.hashCode()).append(" [label=\"condition\"];\n");
    sb.append(nodeName).append(" -> ").append(block.hashCode()).append(" [label=\"block\"];\n");

    return sb.toString();
}


    // Getter
    public ExprNode getCondition() {
        return condition;
    }

    public BlockNode getBlock() {
        return block;
    }

    // Setter
    public void setCondition(ExprNode condition) {
        validateNotNull(condition, "La condición no puede ser nula");
        this.condition = condition;
    }

    public void setBlock(BlockNode block) {
        validateNotNull(block, "El bloque no puede ser nulo");
        this.block = block;
    }

    @Override
    public String toString() {
        return "WhileNode { condition=" + condition + ", block=" + block + " }";
    }
}
