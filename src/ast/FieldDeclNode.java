package ast;

public class FieldDeclNode extends ASTNode {
    private String type;
    private String id;
    private LiteralNode size;  // Tercer parámetro opcional

    public FieldDeclNode(String type, String id) {
        super();  // Llamada al constructor de ASTNode
        this.type = type;
        this.id = id;
        this.size = null;  // Sin tamaño por defecto
    }

    public FieldDeclNode(String type, String id, LiteralNode size) {
        super();  // Llamada al constructor de ASTNode
        this.type = type;
        this.id = id;
        this.size = size;  // Asignación del tamaño o valor literal
    }

    @Override
    public String toDot() {
        // Ahora incluye el tamaño o literal en la representación DOT
        StringBuilder sb = new StringBuilder();
        sb.append("FieldDeclNode [label=\"" + type + " " + id);
        if (size != null) {
            sb.append(" [" + size.toDot() + "]");
        }
        sb.append("\"];\n");
        return sb.toString();
    }

    // Métodos Getter y Setter para type, id y size
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LiteralNode getSize() {
        return size;
    }

    public void setSize(LiteralNode size) {
        this.size = size;
    }
}
