package ast.atomic;

import ast.expression.PrintExp;
import cesk.State;
import javafx.geometry.Side;

public class SideEffect implements AtomicExe{
    PrintExp pe;

    public SideEffect(PrintExp pe) {this.pe = pe;}

    @Override
    public void step(State state) {
        pe.eval(state);
    }
}
