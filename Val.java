import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author David Shnaiderov - 209198308
 * Val Class
 * User ID - shnaidd1
 */
public class Val implements Expression {
    private Boolean value;

    /**
     * Constructor.
     *
     * @param value - Boolean
     */
    public Val(Boolean value) {
        setValue(value);
    }

    /**
     * Set Value.
     *
     * @param val string Value
     */
    public void setValue(Boolean val) {
        this.value = val;
    }

    /**
     * Get Value.
     *
     * @return Value
     */
    public Boolean getValue() {
        return value;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return value;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return value;
    }

    @Override
    public List<String> getVariables() {
        return new LinkedList<>();
    }

    /**
     * To String.
     *
     * @return returns T or F
     */
    public String toString() {
        if (this.getValue()) {
            return "T";
        } else {
            return "F";
        }

    }

    @Override
    public void getVariablesList(Set<String> list) {
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
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
        return new Val(this.value);
    }
}
