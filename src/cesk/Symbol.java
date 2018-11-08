package cesk;

import ast.component.Variable;

import java.util.Map;

public class Symbol implements Cloneable{
    public Map<String, Symbol> anatomy = null;
    public ValueType vt;
    public Variable var;
    public Val v;

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
            return vt.name() + ", value: " + this.v;
        }
        else {
            return vt.name() + ", value: " + this.v + '\n' + anatomy.toString();
        }
    }

    public Symbol clone() throws CloneNotSupportedException
    {
        return (Symbol) super.clone();
    }
}
