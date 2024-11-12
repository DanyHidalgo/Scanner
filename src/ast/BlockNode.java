package ast;

/**
 * Representa un bloque de código en el árbol de sintaxis abstracta, que incluye
 * las declaraciones de variables y las sentencias.
 */
public class BlockNode extends StatementNode {
    private VarDeclsNode varDecls;
    private StatementsNode statements;

    /**
     * Constructor para crear un nodo BlockNode.
     * Verifica que las declaraciones de variables y las sentencias no sean nulas.
     * 
     * @param varDecls Nodo que representa las declaraciones de variables en el bloque.
     * @param statements Nodo que representa las sentencias en el bloque.
     * @throws IllegalArgumentException Si varDecls o statements son nulos.
     */
    public BlockNode(VarDeclsNode varDecls, StatementsNode statements) {
        if (varDecls == null || statements == null) {
            throw new IllegalArgumentException("Las declaraciones de variables y las sentencias no pueden ser nulas");
        }
        this.varDecls = varDecls;
        this.statements = statements;
    }

    /**
     * Genera la representación en formato DOT de un nodo BlockNode y sus componentes.
     * 
     * @return Representación en formato DOT del nodo BlockNode.
     */
    @Override
    public String toDot() {
        // Representación en formato DOT del nodo BlockNode y sus hijos
        return "BlockNode [label=\"Block\"];\n" +
               varDecls.toDot() + statements.toDot();  // Agregar las representaciones de los nodos hijos
    }

    /**
     * Representación en formato de cadena de un nodo BlockNode.
     * 
     * @return Cadena que describe el nodo BlockNode.
     */
    @Override
    public String toString() {
        return "BlockNode { " + varDecls.toString() + ", " + statements.toString() + " }";
    }

    // Getters
    public VarDeclsNode getVarDecls() {
        return varDecls;
    }

    public StatementsNode getStatements() {
        return statements;
    }
}
