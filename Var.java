import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author David Shnaiderov - 209198308
 * Var Class
 * User ID - shnaidd1
 */
public class Var implements Expression {
    private String value;


    /**
     * Constructor.
     *
     * @param value - Boolean
     */
    public Var(String value) {
        setValue(value);
    }

    /**
     * Set value.
     *
     * @param val value
     */
    public void setValue(String val) {
        this.value = val;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (!assignment.containsKey(this.value)) {
            throw new RuntimeException("Incorrect map");
        }
        return assignment.get(this.value);
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new RuntimeException("Empty map");
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new LinkedList<>();
        list.add(this.toString());
        return list;
    }

    /**
     * Get Value.
     *
     * @return Value
     */
    public String getValue() {
        return value;
    }

    /**
     * To String.
     *
     * @return value Name
     */
    public String toString() {
        return this.getValue();

    }

    @Override
    public void getVariablesList(Set<String> list) {
        list.add(this.toString());

    }

    @Override
    public Expression assign(String var, Expression exp) {
        if (this.value.equals(var)) {
            return exp;
        }
        return new Var(this.value);
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return new Var(value);
    }
}
