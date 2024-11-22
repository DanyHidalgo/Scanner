package irt;

import java.util.ArrayList;
import java.util.List;

public class BasicBlock {
    public String label;
    public List<IRStmt> instructiones;
    public List<BasicBlock> predecesores;
    public List<BasicBlock> sucesores;   
    public List<String> successorLabels;  

    public BasicBlock() {
        this.instructiones = new ArrayList<>();
        this.predecesores = new ArrayList<>();  
        this.sucesores = new ArrayList<>();    
        this.successorLabels = new ArrayList<>();
    }

    public void addInstruction(IRStmt stmt) {
        this.instructiones.add(stmt);
    }
}
