package cesk;

import ast.wrapper.Variable;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

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
            return "function";
//            return vt.name() + ", value: " + this.v + '\n' + anatomy.toString();
        }
    }

    @Override
    public Symbol clone() throws CloneNotSupportedException {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(anatomy, symbol.anatomy) &&
                vt == symbol.vt &&
                Objects.equals(var, symbol.var) &&
                Objects.equals(v, symbol.v);
    }

    @Override
    public int hashCode() {

        return Objects.hash(anatomy, vt, var, v);
    }
}
