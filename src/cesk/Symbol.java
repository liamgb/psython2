package cesk;

import ast.component.Variable;

import java.util.Map;

public class Symbol {
    public Map<String, Symbol> anatomy = null;
    public ValueType vt;
    public Variable var;

    public Symbol(ValueType vt, Variable var) {
        this.vt = vt;
        this.var = var;
    }

    public Symbol(Map<String, Symbol> anatomy, ValueType vt, Variable var) {
        this.anatomy = anatomy;
        this.vt = vt;
        this.var = var;
    }

    @Override
    public String toString(){
        if (anatomy == null) {
            return vt.name();
        }
        else {
            return vt.name() + '\n' + anatomy.toString();
        }
    }
}
