package modelchecking;


import ast.leaf.IdentifierNode;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


public class PropertyAutomaton {
    public static PropertyAutomaton singleton = null;

    public PropertyState p0 = new PropertyState(true, false);
    public Multimap<PropertyState, Transition> graph = ArrayListMultimap.create();

    public static PropertyAutomaton get_singleton() {
        if (PropertyAutomaton.singleton == null) {
            PropertyAutomaton.singleton = new PropertyAutomaton();
        }
        return singleton;
    }

//    public PropertyAutomaton() {
//        PropertyState p1 = new PropertyState(false, true);
//
//        BoolNode cond0 = new BoolNode("True");
//        RelationalExp cond1 = new RelationalExp(
//                new IdentifierNode("i"), new IntNode("2"), ">");
//
//        graph.put(p0, new Transition(cond0, p0));
//        graph.put(p0, new Transition(cond1, p1));
//        graph.put(p1, new Transition(cond0, p1));
//    }

    public PropertyAutomaton() {
        PropertyState p1 = new PropertyState(false, true);

        IdentifierNode cond0 = new IdentifierNode("is_survive");
        IdentifierNode cond1 = new IdentifierNode("is_win");

        graph.put(p0, new Transition(cond0, p0));
        graph.put(p0, new Transition(cond1, p1));
        graph.put(p1, new Transition(cond0, p1));
    }
}
