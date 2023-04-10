import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        Expression e2 = new Not(new Xor(new And(new Var("x"), new Var("y")), new Val(true)));
        Boolean value = e2.evaluate(assignment);
        List<String> vars = e2.getVariables();
        System.out.println(e2.toString());
        System.out.println(value);
        for (String v : vars) {
            System.out.println(v);
        }
        Expression e3 = e2.assign("y", e2);
        System.out.println(e3);
        e3 = e3.assign("x", new Val(false));
        System.out.println(e3);
        Expression e = new Xor(new And(new Var("x"), new Var("y")), new Val(true));
        System.out.println(e.nandify());

        Expression e4 = new Xor(new And(new Var("x"), new Val(false)), new Or(new Var("y"), new Val(false)));
        System.out.println(e4);
        System.out.println(e4.simplify());

    }
}
