import java.util.Map;

/**
 * @author David Shnaiderov - 209198308
 * Nor Expression Class
 * User ID - shnaidd1
 */
public class Nor extends BinaryExpression {
    private static final String SYMBOL = " V ";

    /**
     * Constructor.
     *
     * @param e1 - Expression 1
     * @param e2 - Expression 2
     */
    public Nor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(super.getExp1().evaluate(assignment) || super.getExp2().evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return evaluate(null);
    }

    /**
     * String Representation.
     * @return String
     */
    public String toString() {
        return super.toString(SYMBOL);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nor(super.getExp1().assign(var, expression), super.getExp2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(new Nand(getExp1().nandify(), getExp1().nandify()),
                new Nand(getExp2().nandify(), getExp2().nandify())),
                new Nand(new Nand(getExp1().nandify(), getExp1().nandify()),
                        new Nand(getExp2().nandify(), getExp2().nandify())));
    }

    @Override
    public Expression norify() {
        return new Nor(getExp1().norify(), getExp2().norify());
    }

    @Override
    public Expression simplify() {
        Expression ex1 = super.getExp1().simplify();
        Expression ex2 = super.getExp2().simplify();

        if (ex1.toString().equals(ex2.toString())) {
            return new Not(ex1).simplify();
        } else if (ex1.toString().equals("T") || ex2.toString().equals("T")) {
            return new Val(false);
        } else if (ex1.toString().equals("F")) {
            return new Not(ex2).simplify();
        } else if (ex2.toString().equals("F")) {
            return new Not(ex1).simplify();
        } else {
            return new Nor(ex1, ex2);
        }
    }

}
