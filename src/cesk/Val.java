package cesk;


public class Val {
    public ValueType type;
    public int int_v;
    public boolean bool_v;
    public char char_v;
    public String str_v;
    public State stt_v;

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

    public Val(State stt_v) {
        this.type = ValueType.P_STT;
        this.stt_v = stt_v;
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
            case P_STT:
                return stt_v.toString();
            default:
                return "null";
        }
    }
}
