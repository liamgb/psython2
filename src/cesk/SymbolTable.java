package cesk;

import ast.component.Variable;
import ast.leaf.IdentifierNode;

import java.util.Map;
import java.util.TreeMap;

public class SymbolTable {
    Map<String, Symbol> tree = new TreeMap<>();

    public SymbolTable(){}

    public void insert(String scope, String name, Symbol attr){
        if (scope == null){
            if (this.lookup(scope, name) == null || this.lookup(scope, name).vt == ValueType.P_UNKNOWN) {
                this.tree.put(name, attr);
            }
            else {
                if (this.lookup(scope, name).vt != attr.vt) {
                    System.out.println("Variable " + name + " inconsistent Type!");
                    assert false;
                }
            }
        }
        else {
            Symbol sc = this.lookup(null, scope);
            if (sc != null) {
                if (sc.anatomy.get(name) == null || this.lookup(scope, name).vt == ValueType.P_UNKNOWN) {
                    sc.anatomy.put(name, attr);
                } else {
                    if (this.lookup(scope, name).vt != attr.vt) {
                        System.out.println("Variable " + name + " inconsistent Type!");
                        assert false;
                    }
                }
            } else {
                System.out.println("Scope does not exist!");
                assert false;
            }
        }
    }

    public Symbol lookup(String scope, String name){
        if (scope == null) {
            return this.tree.get(name);
        }
        else {
            return this.tree.get(scope).anatomy.get(name);
        }
//        Symbol sym = this.tree.get(name);
//        if (sym == null) {
//            for (Symbol tree_sym: this.tree.values()) {
//                if (tree_sym.anatomy != null) {
//                    sym = tree_sym.anatomy.get(name);
//                }
//                if (sym != null) {
//                    break;
//                }
//            }
//        }
//        return sym;
    }

    @Override
    public String toString(){
        return tree.toString();
    }
}
