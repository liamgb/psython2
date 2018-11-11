package cesk;

import ast.component.Variable;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    @Override
    public Symbol clone() throws CloneNotSupportedException
    {
        Symbol sym = (Symbol) super.clone();

        if (this.anatomy != null) {
            sym.anatomy = new TreeMap<>();
            for (Map.Entry<String, Symbol> entry: this.anatomy.entrySet()) {
                sym.anatomy.put(entry.getKey(), entry.getValue().clone());
            }
        }
        if (this.v != null) {
            sym.v = v.clone();
        }

        return sym;
    }
}
