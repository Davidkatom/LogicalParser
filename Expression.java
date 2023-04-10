import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author David Shnaiderov - 209198308
 * Expression Interface
 * User ID - shnaidd1
 */
public interface Expression {

    /**
     * Evaluate the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception
     * is thrown.
     *
     * @param assignment Map of variables and values
     * @return true or false
     * @throws Exception - in case Map is null or a variable does not exist.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above,
     * but uses an empty assignment.
     *
     * @return - true or false
     * @throws Exception - In case there are variables in the expression.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return list of variables
     */
    List<String> getVariables();

    /**
     * Returns a nice string representation of the expression.
     *
     * @return - string representation
     */
    String toString();

    /**
     * Helper method for getVariables.
     *
     * @param list - list to add variables to
     */
    void getVariablesList(Set<String> list);


    /**
     * Returns a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the
     * current expression).
     *
     * @param var        - variable to change
     * @param expression - Expression to change into
     * @return new Expression
     */
    Expression assign(String var, Expression expression);


    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     *
     * @return Nand Expression
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     *
     * @return Nor Expression
     */
    Expression norify();

    /**
     * Simplifies the expression as much as possible.
     * @return - Simplified Expression.
     */
    Expression simplify();


}
