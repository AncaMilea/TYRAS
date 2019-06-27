import java.util.List;

public class FunctionParamMap {

    private ENUMS.Functions function;
    private List<String> parameters;

    public FunctionParamMap(ENUMS.Functions function, List<String> parameters) {
        this.function = function;
        this.parameters = parameters;
    }

    public ENUMS.Functions getFunction() {
        return function;
    }

    public void setFunction(ENUMS.Functions function) {
        this.function = function;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

}
