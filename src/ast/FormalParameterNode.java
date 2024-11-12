package ast;

/**
 * Representa un nodo en el árbol de sintaxis abstracta para un parámetro formal.
 * Este nodo almacena el tipo y el identificador de un parámetro formal en una declaración de método.
 */
public class FormalParameterNode extends ASTNode {
    private String type;
    private String id;

    /**
     * Constructor para crear un nodo FormalParameterNode.
     * 
     * @param type El tipo del parámetro formal.
     * @param id El identificador del parámetro formal.
     */
    public FormalParameterNode(String type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public String toDot() {
        // Generar el nodo DOT con el tipo y el identificador del parámetro
        return "FormalParameterNode [label=\"" + type + " " + id + "\"];\n";
    }

    // Getters
    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "FormalParameterNode { type=" + type + ", id=" + id + " }";
    }
}
