package cesk;


public class Val implements Cloneable{
    public ValueType type;
    public int int_v;
    public boolean bool_v;
    public char char_v;
    public String str_v;

    public Val(Val v){
        type = v.type;
        switch (v.type) {
            case P_INT:
                int_v = Integer.valueOf(v.int_v);
                break;
            case P_BOOL:
                bool_v = Boolean.valueOf(v.bool_v);
                break;
            case P_CHAR:
                char_v = Character.valueOf(v.char_v);
                break;
            case P_STR:
                str_v = new String(v.str_v);
                break;
            default:
                break;
        }
    }

    public Val(int int_v) {
        this.type = ValueType.P_INT;
        this.int_v = int_v;
    }

    public Val(boolean bool_v) {
        this.type = ValueType.P_BOOL;
        this.bool_v = bool_v;
    }

    public Val(char char_v) {
        this.type = ValueType.P_CHAR;
        this.char_v = char_v;
    }

    public Val(String str_v) {
        this.type = ValueType.P_STR;
        this.str_v = str_v;
    }

    @Override
    public String toString() {
        switch (type) {
            case P_INT:
                return Integer.toString(int_v);
            case P_BOOL:
                return Boolean.toString(bool_v);
            case P_CHAR:
                return Character.toString(char_v);
            case P_STR:
                return str_v;
            default:
                return "null";
        }
    }

    public Val clone() throws CloneNotSupportedException{
        Val v = (Val) super.clone();
        v.type = type;
        switch (this.type) {
            case P_INT:
                v.int_v = Integer.valueOf(this.int_v);
                break;
            case P_BOOL:
                v.bool_v = Boolean.valueOf(this.bool_v);
                break;
            case P_CHAR:
                v.char_v = Character.valueOf(this.char_v);
                break;
            case P_STR:
                v.str_v = new String(this.str_v);
                break;
            default:
                break;
        }
        return v;
    }
}
