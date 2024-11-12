package ast;

public class LiteralNode extends ExprNode {
    private String value;  // El valor del literal (puede ser un número, booleano o cadena)

    // Constructor que valida que el valor no sea nulo
    public LiteralNode(String value) {
        if (value == null) {
            throw new IllegalArgumentException("El valor del literal no puede ser nulo.");
        }
        this.value = value;
    }

    @Override
    public String toDot() {
        // Retorna la representación en formato DOT del literal
        return "LiteralNode [label=\"" + value + "\"];\n";
    }

    // Getter del valor
    public String getValue() {
        return value;
    }

    // Setter del valor
    public void setValue(String value) {
        // Se puede permitir cambiar el valor, pero también podrías agregar validación si es necesario
        this.value = value;
    }

    @Override
    public String toString() {
        // Retorna una representación en cadena del nodo Literal
        return "LiteralNode { value=" + value + " }";
    }
}
