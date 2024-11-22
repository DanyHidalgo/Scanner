package irt;

public enum BinOp {
    PLUS, 
    MINUS,
    MUL,  
    DIV, 
    AND, 
    OR,    
    EQ,   
    NE,   
    LT,   
    LE,  
    GT,     
    GE,    
    XOR;     

    @Override
    public String toString() {
        return this.name();
    }
}
