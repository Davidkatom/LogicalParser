import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * BaseExpression Abstract class
 * User ID - shnaidd1
 */

abstract class BaseExpression implements Expression {

    @Override
    public List<String> getVariables() {
        Set<String> vars = new HashSet<>();
        this.getVariablesList(vars);
        return new ArrayList<>(vars);
    }
}
