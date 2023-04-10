import java.util.Set;

/**
 * @author David Shnaiderov - 209198308
 * And Expression Class
 * User ID - shnaidd1
 */

abstract class BinaryExpression extends BaseExpression {
    private final Expression exp1;
    private final Expression exp2;

    /**
     * Constructor.
     *
     * @param e1 - Expression 1
     * @param e2 - Expression 2
     */
    BinaryExpression(Expression e1, Expression e2) {
        this.exp1 = e1;
        this.exp2 = e2;
    }


    @Override
    public void getVariablesList(Set<String> list) {
        exp1.getVariablesList(list);
        exp2.getVariablesList(list);
    }

    /**
     * Returns a string representation.
     * @param symbol - Default symbol
     * @return - String
     */
    public String toString(String symbol) {
        String string = "(";
        string = string + exp1.toString();
        string = string + symbol;
        string = string + exp2.toString();
        string = string + ")";
        return string;
    }

    /**
     * Returns first expression.
     * @return - Expression
     */
    protected Expression getExp1() {
        return exp1;
    }

    /**
     * Returns second expression.
     * @return - Expression
     */
    protected Expression getExp2() {
        return exp2;
    }

}
