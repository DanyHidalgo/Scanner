package semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantic {
    private Stack<Map<String, SymbolInfo>> scopeStack = new Stack<>();

    public Semantic() {
        this.scopeStack.push(new HashMap<>());  // Iniciar con un scope global
    }

    // Entrar a un nuevo scope (por ejemplo, al entrar a un bloque o función)
    public void enterScope() {
        scopeStack.push(new HashMap<>());
    }

    // Salir de un scope
    public void exitScope() {
        scopeStack.pop();
    }

    // Declarar una variable
    public void declareVariable(String type, String id) throws Exception {
        Map<String, SymbolInfo> currentScope = scopeStack.peek();
        if (currentScope.containsKey(id)) {
            throw new Exception("Semantic Error: Variable '" + id + "' already declared in this scope.");
        }
        currentScope.put(id, new SymbolInfo(type, false));
    }

    // Usar una variable
    public void useVariable(String id) throws Exception {
        if (!isDeclared(id)) {
            throw new Exception("Semantic Error: Variable '" + id + "' not declared.");
        }
    }

    // Chequear si una variable está declarada en algún scope
    private boolean isDeclared(String id) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i).containsKey(id)) {
                return true;
            }
        }
        return false;
    }

    // Declarar una función
    public void declareFunction(String returnType, String id, String[] paramTypes) throws Exception {
        if (scopeStack.size() != 1) {
            throw new Exception("Semantic Error: Functions must be declared in the global scope.");
        }
        Map<String, SymbolInfo> globalScope = scopeStack.peek();
        if (globalScope.containsKey(id)) {
            throw new Exception("Semantic Error: Function '" + id + "' already declared.");
        }
        globalScope.put(id, new SymbolInfo(returnType, true, paramTypes));
    }

    // Usar una función
    public void useFunction(String id, String[] argTypes) throws Exception {
        SymbolInfo functionInfo = findFunction(id);
        if (functionInfo == null) {
            throw new Exception("Semantic Error: Function '" + id + "' not declared.");
        }
        if (!functionInfo.isFunction || !areTypesCompatible(functionInfo.paramTypes, argTypes)) {
            throw new Exception("Semantic Error: Function '" + id + "' arguments type mismatch.");
        }
    }

    // Encontrar información de una función
    private SymbolInfo findFunction(String id) {
        return scopeStack.get(0).get(id);  // Solo buscar en el scope global
    }

    // Chequear compatibilidad de tipos
    private boolean areTypesCompatible(String[] declaredTypes, String[] usedTypes) {
        if (declaredTypes.length != usedTypes.length) return false;
        for (int i = 0; i < declaredTypes.length; i++) {
            if (!declaredTypes[i].equals(usedTypes[i])) return false;
        }
        return true;
    }

    static class SymbolInfo {
        public String type;
        public boolean isFunction;
        public String[] paramTypes;

        public SymbolInfo(String type, boolean isFunction) {
            this.type = type;
            this.isFunction = isFunction;
        }

        public SymbolInfo(String type, boolean isFunction, String[] paramTypes) {
            this.type = type;
            this.isFunction = isFunction;
            this.paramTypes = paramTypes;
        }
    }
}
