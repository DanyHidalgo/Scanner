package ast;

import java.util.ArrayList;
import java.util.List;

public class CalloutArgsNode extends ASTNode {
    private List<CalloutArgNode> args;

    // Constructor que inicializa la lista de argumentos
    public CalloutArgsNode(List<CalloutArgNode> args) {
        this.args = args != null ? args : new ArrayList<>();  // Si args es nulo, inicializa como lista vacía
    }

    @Override
    public String toDot() {
        StringBuilder dot = new StringBuilder("CalloutArgsNode [label=\"CalloutArgs\"];\n");
        
        // Verifica si hay argumentos y los agrega al DOT
        if (args != null && !args.isEmpty()) {
            for (CalloutArgNode arg : args) {
                dot.append(arg.toDot());
            }
        }
        
        return dot.toString();
    }

    // Getter para los argumentos
    public List<CalloutArgNode> getArgs() {
        return args;
    }
    
    // Setter para los argumentos, en caso de que desees modificarlos después
    public void setArgs(List<CalloutArgNode> args) {
        this.args = args != null ? args : new ArrayList<>();
    }
}
