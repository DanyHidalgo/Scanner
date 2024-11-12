package ast;

import java.util.ArrayList;
import java.util.List;

public class MethodCallNode extends ASTNode {
    private String methodName;
    private List<CalloutArgNode> args;

    // Constructor que inicializa el nombre del método y los argumentos
    public MethodCallNode(String methodName, List<CalloutArgNode> args) {
        super();  // Llamada al constructor de ASTNode, que asigna el id
        this.methodName = methodName;
        this.args = args != null ? args : new ArrayList<>();  // Si args es nulo, inicializamos como lista vacía
    }

    @Override
    public String toDot() {
        StringBuilder dotRepresentation = new StringBuilder();
        String nodeName = "MethodCallNode" + hashCode(); // Aseguramos un nombre único para el nodo

        // Representamos el nodo MethodCallNode
        dotRepresentation.append(nodeName).append(" [label=\"").append(methodName).append("\"];\n");

        // Generamos los nodos hijos si existen los argumentos
        if (args != null && !args.isEmpty()) {
            for (CalloutArgNode arg : args) {
                dotRepresentation.append(arg.toDot());
                dotRepresentation.append(nodeName).append(" -> ").append(arg.hashCode()).append(";\n");
            }
        }

        return dotRepresentation.toString();
    }

    // Getters
    public String getMethodName() {
        return methodName;
    }

    public List<CalloutArgNode> getArgs() {
        return args;
    }
    
    // Setter para los argumentos, en caso de que desees modificar los argumentos después
    public void setArgs(List<CalloutArgNode> args) {
        this.args = args != null ? args : new ArrayList<>();
    }
}
