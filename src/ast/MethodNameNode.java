package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para el nombre de un método.
 * Este nodo almacena el nombre de un método como una cadena de texto.
 */
public class MethodNameNode extends ASTNode {
    private String methodName;

    /**
     * Constructor para crear un nodo MethodNameNode.
     * 
     * @param methodName El nombre del método que representa este nodo.
     * @throws IllegalArgumentException Si el nombre del método es nulo o vacío.
     */
    public MethodNameNode(String methodName) {
        if (methodName == null || methodName.isEmpty()) {
            throw new IllegalArgumentException("El nombre del método no puede ser nulo o vacío");
        }
        this.methodName = methodName;
    }

    /**
     * Genera la representación en formato DOT de un nodo MethodNameNode.
     * 
     * @return Representación en formato DOT del nodo MethodNameNode.
     */
    @Override
    public String toDot() {
        // Generar el nodo DOT con el nombre del método
        return "MethodNameNode [label=\"" + methodName + "\", shape=box, style=dashed];\n";
    }

    // Getter
    public String getMethodName() {
        return methodName;
    }

    /**
     * Representación en formato de cadena de un nodo MethodNameNode.
     * 
     * @return Cadena representando el nodo.
     */
    @Override
    public String toString() {
        return "MethodNameNode { methodName=\"" + methodName + "\" }";
    }
}
