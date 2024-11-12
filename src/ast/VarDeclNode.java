package ast;

public class VarDeclNode extends ASTNode {
    private String type;
    private String id;

    public VarDeclNode(String type, String id) {
        super();  // Llamada al constructor de ASTNode, que asigna el id
        this.type = type;
        this.id = id;
    }

    @Override
    public String toDot() {
        return "VarDeclNode [label=\"" + type + " " + id + "\"];\n";
    }

    // Eliminamos el método getId(), ya que lo heredamos de ASTNode
}
