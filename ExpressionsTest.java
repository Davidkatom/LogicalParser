/**
 * @author David Shnaiderov - 209198308
 * Expression Test Class
 * User ID - shnaidd1
 */
public class ExpressionsTest {


    /**
     * Test function.
     *
     * @param args - run args
     */
    public static void main(String[] args) {

        Expression e = new Xor(new And(new Var("x"), new Var("y")), new Var("z"));
        System.out.println(e.toString());

        Expression e1 = new And(new Var("x"), new Var("x"));
        Expression e2 = new Or(new Var("x"), new Val(true));
        Expression e3 = new Xor(new Val(true), new Val(false));
        Expression eAss = e.assign("x", e1);
        eAss = eAss.assign("y", e2);
        eAss = eAss.assign("z", e3);
        System.out.println(eAss.toString());

        System.out.println(e.nandify().toString());
        System.out.println(e.norify().toString());
        System.out.println(e.simplify().toString());

    }
}
