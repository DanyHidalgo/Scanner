package ast;

import java.util.List;

public class FieldDeclsNode extends ASTNode {
    private List<ASTNode> fieldDecls;

    public FieldDeclsNode(List<ASTNode> fieldDecls) {
        this.fieldDecls = fieldDecls;
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("FieldDeclsNode [label=\"Field Declarations\"];\n");
        for (ASTNode fd : fieldDecls) {
            sb.append(fd.toDot());
        }
        return sb.toString();
    }

    // Getter
    public List<ASTNode> getFieldDecls() {
        return fieldDecls;
    }
}
