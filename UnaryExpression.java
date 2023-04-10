import java.util.Set;

/**
 * @author David Shnaiderov - 209198308
 * UnaryExpression Class
 * User ID - shnaidd1
 */
abstract class UnaryExpression extends BaseExpression {
    private final Expression exp;

    /**
     * Constructor.
     *
     * @param e1 - Expression
     */
    UnaryExpression(Expression e1) {
        this.exp = e1;
    }


    @Override
    public void getVariablesList(Set<String> list) {
        exp.getVariablesList(list);
    }


    /**
     * Returns String representation.
     * @param symbol - Symbol
     * @return String
     */
    public String toString(String symbol) {
        String string = "";
        string = string + symbol;
        string = string + "(";
        string = string + exp.toString();
        string = string + ")";
        return string;
    }

    /**
     * return Expression.
     * @return Expression
     */
    protected Expression getExp() {
        return exp;
    }


}