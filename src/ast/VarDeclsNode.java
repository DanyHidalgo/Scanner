package ast;

import java.util.List;

/**
 * Representa un nodo en el árbol de sintaxis abstracta que contiene una lista de declaraciones de variables.
 */
public class VarDeclsNode extends ASTNode {
    private List<VarDeclNode> varDecls;

    /**
     * Constructor de la clase VarDeclsNode.
     * Asegura que la lista de declaraciones de variables no sea nula.
     * 
     * @param varDecls Lista de nodos de declaraciones de variables.
     * @throws IllegalArgumentException Si varDecls es nulo.
     */
    public VarDeclsNode(List<VarDeclNode> varDecls) {
        if (varDecls == null) {
            throw new IllegalArgumentException("La lista de declaraciones de variables no puede ser nula");
        }
        this.varDecls = varDecls;
    }

    /**
     * Genera la representación en formato DOT del nodo y sus nodos hijos.
     * 
     * @return Representación en formato DOT del nodo.
     */
    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        for (VarDeclNode varDecl : varDecls) {
            sb.append(varDecl.toDot());
        }
        return sb.toString();
    }

    /**
     * Obtiene la lista de declaraciones de variables.
     * 
     * @return La lista de declaraciones de variables.
     */
    public List<VarDeclNode> getVarDecls() {
        return varDecls;
    }

    /**
     * Establece la lista de declaraciones de variables.
     * 
     * @param varDecls Nueva lista de declaraciones de variables.
     */
    public void setVarDecls(List<VarDeclNode> varDecls) {
        if (varDecls == null) {
            throw new IllegalArgumentException("La lista de declaraciones de variables no puede ser nula");
        }
        this.varDecls = varDecls;
    }
}
