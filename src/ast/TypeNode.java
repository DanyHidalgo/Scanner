package ast;

public class TypeNode extends ASTNode {
    private String type;

    public TypeNode(String type) {
        this.type = type;
    }

    @Override
    public String toDot() {
        return "TypeNode [label=\"" + type + "\"];\n";
    }
}
