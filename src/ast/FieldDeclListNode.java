package ast;

import java.util.List;

public class FieldDeclListNode extends ASTNode {
    private List<FieldDeclNode> fieldDecls;  // Especifica que la lista contiene FieldDeclNode

    // Constructor para inicializar la lista de FieldDeclNode
    public FieldDeclListNode(List<FieldDeclNode> fieldDecls) {
        super();  // Llamada al constructor de ASTNode
        this.fieldDecls = fieldDecls;
    }

    @Override
    public String toDot() {
        // Representación DOT para todos los FieldDeclNode en la lista
        StringBuilder sb = new StringBuilder();
        for (FieldDeclNode fd : fieldDecls) {
            sb.append(fd.toDot());
        }
        return sb.toString();
    }

    // Getter para obtener la lista de FieldDeclNode
    public List<FieldDeclNode> getFieldDecls() {
        return fieldDecls;
    }

    // Setter para actualizar la lista de FieldDeclNode
    public void setFieldDecls(List<FieldDeclNode> fieldDecls) {
        this.fieldDecls = fieldDecls;
    }

    // Método para agregar un FieldDeclNode a la lista
    public void addFieldDecl(FieldDeclNode fd) {
        this.fieldDecls.add(fd);
    }
}
