package ast;

public abstract class ASTNode {
    private static int counter = 0;  // Contador estático para IDs únicos de nodos
    private final int id;  // ID único para cada nodo

    public ASTNode() {
        this.id = counter++;  // Asignar un ID único al nodo
    }

    // Método abstracto que debe ser implementado por cada clase hija para generar el formato DOT
    public abstract String toDot();

    // Método toString que retorna el ID del nodo, útil para generar relaciones en DOT
    @Override
    public String toString() {
        return "Node" + id;  // El ID único del nodo
    }

    // Getter para obtener el ID
    public int getId() {
        return id;
    }
}
