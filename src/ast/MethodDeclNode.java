package ast;

public class MethodDeclNode extends ASTNode {
    private String type;
    private String id;
    private FormalParametersNode formalParameters;
    private BlockNode block;

    // Constructor para inicializar los campos de la declaración del método
    public MethodDeclNode(String type, String id, FormalParametersNode formalParameters, BlockNode block) {
        super();  // Llamada al constructor de ASTNode
        this.type = type;
        this.id = id;
        this.formalParameters = formalParameters;
        this.block = block;
    }

    @Override
    public String toDot() {
        // Representación DOT de la declaración del método, incluyendo parámetros y bloque
        return "MethodDeclNode [label=\"" + type + " " + id + "()\"];\n" +
               formalParameters.toDot() + 
               block.toDot();
    }

    // Getter y Setter (si es necesario)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FormalParametersNode getFormalParameters() {
        return formalParameters;
    }

    public void setFormalParameters(FormalParametersNode formalParameters) {
        this.formalParameters = formalParameters;
    }

    public BlockNode getBlock() {
        return block;
    }

    public void setBlock(BlockNode block) {
        this.block = block;
    }
}
