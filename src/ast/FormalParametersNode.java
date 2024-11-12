package ast;

import java.util.List;

public class FormalParametersNode extends ASTNode {
    private List<ASTNode> formalParameters;

    // Constructor que valida que la lista de parámetros no sea nula
    public FormalParametersNode(List<ASTNode> formalParameters) {
        if (formalParameters == null) {
            throw new IllegalArgumentException("La lista de parámetros formales no puede ser nula.");
        }
        this.formalParameters = formalParameters;
    }

    @Override
    public String toDot() {
        // Representación en formato DOT de los parámetros formales
        StringBuilder sb = new StringBuilder();
        for (ASTNode param : formalParameters) {
            sb.append(param.toDot());
        }
        return sb.toString();
    }

    // Getter para la lista de parámetros formales
    public List<ASTNode> getFormalParameters() {
        return formalParameters;
    }

    @Override
    public String toString() {
        // Representación en cadena de los parámetros formales
        return "FormalParametersNode { formalParameters=" + formalParameters + " }";
    }
}
