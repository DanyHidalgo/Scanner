package ast;

import java.util.List;

public class ProgramNode extends ASTNode {
    private String className;
    private List<ASTNode> fieldDecls;
    private List<ASTNode> methodDecls;

    public ProgramNode(String className, List<ASTNode> fieldDecls, List<ASTNode> methodDecls) {
        super();  // Llamada al constructor de ASTNode, que asigna el id
        this.className = className;
        this.fieldDecls = fieldDecls;
        this.methodDecls = methodDecls;
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProgramNode [label=\"" + className + "\"];\n");

        // Genera los toDot de los fieldDecls
        for (ASTNode fd : fieldDecls) {
            sb.append(fd.toDot());
        }

        // Genera los toDot de los methodDecls
        for (ASTNode md : methodDecls) {
            sb.append(md.toDot());
        }

        return sb.toString();
    }

    // Métodos Getter y Setter para las listas de declaraciones
    public List<ASTNode> getFieldDecls() {
        return fieldDecls;
    }

    public void setFieldDecls(List<ASTNode> fieldDecls) {
        this.fieldDecls = fieldDecls;
    }

    public List<ASTNode> getMethodDecls() {
        return methodDecls;
    }

    public void setMethodDecls(List<ASTNode> methodDecls) {
        this.methodDecls = methodDecls;
    }
}
