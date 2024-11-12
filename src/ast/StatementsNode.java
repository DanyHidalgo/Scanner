package ast;

import java.util.List;

/**
 * Representa una lista de sentencias dentro de un bloque de código.
 */
public class StatementsNode extends ASTNode {
    private List<StatementNode> statements;  // Lista de StatementNode

    /**
     * Constructor para inicializar la lista de statements.
     * 
     * @param statements Lista de sentencias.
     */
    public StatementsNode(List<StatementNode> statements) {
        super();  // Llamada al constructor de ASTNode
        this.statements = statements;
    }

    /**
     * Genera la representación en formato DOT de todas las sentencias.
     * 
     * @return Representación en formato DOT de todas las sentencias.
     */
    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        // Verifica que la lista de statements no sea nula y luego agrega su representación DOT
        if (statements != null && !statements.isEmpty()) {
            for (StatementNode statement : statements) {
                sb.append(statement.toDot());
            }
        } else {
            sb.append("StatementsNode [label=\"Empty\"];\n");  // Representación para lista vacía
        }
        return sb.toString();
    }

    /**
     * Getter para obtener la lista de statements.
     * 
     * @return Lista de StatementNode.
     */
    public List<StatementNode> getStatements() {
        return statements;
    }

    /**
     * Setter para actualizar la lista de statements.
     * 
     * @param statements Lista de sentencias.
     */
    public void setStatements(List<StatementNode> statements) {
        this.statements = statements;
    }

    /**
     * Método para agregar un statement a la lista.
     * 
     * @param statement Sentencia a agregar.
     */
    public void addStatement(StatementNode statement) {
        if (this.statements != null) {
            this.statements.add(statement);
        }
    }
}
