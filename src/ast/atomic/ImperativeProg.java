package ast.atomic;

import java.util.ArrayList;
import java.util.List;

public class ImperativeProg {
    private List<AtomicExe> ip = new ArrayList<>();
    public static ImperativeProg singleton = null;

    public static ImperativeProg get_singleton() {
        if(singleton == null) {
            singleton = new ImperativeProg();
        }
        return singleton;
    }

    public AtomicExe get(int pos) {
        return ip.get(pos);
    }

    public void add(AtomicExe ae) {
        ip.add(ae);
    }

    public int indexOf(AtomicExe ae) {
        return ip.indexOf(ae);
    }

    public int size() {
        return ip.size();
    }

    public int indexOf(String func_name) {
        for (AtomicExe ae : ip) {
            if (ae instanceof FuncDef) {
                FuncDef fd = (FuncDef) ae;
                if (fd.name.equals(func_name)) {
                    return ip.indexOf(fd);
                }
            }
        }
        return -1;
    }
}
