package modelchecking;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class PropertyState {
    public static final AtomicInteger count = new AtomicInteger(0);
    public final int id;
    public final boolean initial;
    public final boolean accept;

    public PropertyState(boolean initial, boolean accept){
        id = count.incrementAndGet();
        this.accept = accept;
        this.initial = initial;
    }

    public PropertyState(boolean initial, boolean accept, int id){
        this.id = id;
        this.accept = accept;
        this.initial = initial;
    }

    public PropertyState snapshot() {
        return new PropertyState(this.initial, this.accept, this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyState)) return false;
        PropertyState that = (PropertyState) o;
        return id == that.id &&
                initial == that.initial &&
                accept == that.accept;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, initial, accept);
    }
}
