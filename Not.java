import java.util.Map;

/**
 * @author David Shnaiderov - 209198308
 * Not Expression Class
 * User ID - shnaidd1
 */
public class Not extends UnaryExpression {
    private static final String SYMBOL = "~";

    /**
     * Constructor.
     * @param e1 - Expression
     */
    public Not(Expression e1) {
        super(e1);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !super.getExp().evaluate(assignment);

    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.evaluate(null);
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(super.getExp().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(getExp().nandify(), getExp().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(getExp().norify(), getExp().norify());
    }

    @Override
    public Expression simplify() {
        Expression ex = super.getExp().simplify();
        if (ex.toString().equals("F")) {
            return new Val(true);
        }
        if (ex.toString().equals("T")) {
            return new Val(false);
        }
        return new Not(ex);
    }

    /**
     * String representation.
     * @return String
     */
    public String toString() {
        return super.toString(SYMBOL);
    }

}
