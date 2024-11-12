package ast;

import java.util.List;

public class MethodDeclsNode extends ASTNode {
    private List<ASTNode> methodDecls;

    // Constructor para inicializar la lista de declaraciones de métodos
    public MethodDeclsNode(List<ASTNode> methodDecls) {
        this.methodDecls = methodDecls;
    }

    @Override
    public String toDot() {
        // Representación en formato DOT de las declaraciones de métodos
        StringBuilder sb = new StringBuilder();
        for (ASTNode method : methodDecls) {
            sb.append(method.toDot());
        }
        return sb.toString();
    }

    // Getter para la lista de declaraciones de métodos
    public List<ASTNode> getMethodDecls() {
        return methodDecls;
    }

    @Override
    public String toString() {
        // Representación en cadena de las declaraciones de métodos
        StringBuilder sb = new StringBuilder("MethodDeclsNode { ");
        for (ASTNode method : methodDecls) {
            sb.append(method.toString()).append(", ");
        }
        // Eliminar la última coma
        if (methodDecls.size() > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" }");
        return sb.toString();
    }
}
