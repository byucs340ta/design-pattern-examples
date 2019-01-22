package Command;

import java.lang.reflect.Method;

class GenericCommand implements Command {
    private String _className;
    private String _methodName;
    private Class<?>[] _paramTypes;
    private Object[] _paramValues;

    public GenericCommand(String className, String methodName,
                          Class<?>[] paramTypes, Object[] paramValues) {
        _className = className;
        _methodName = methodName;
        _paramTypes = paramTypes;
        _paramValues = paramValues;
    }

    @Override
    public void execute() {
        System.out.println(String.format("Executing a generic command for method %s on class %s", _methodName, _className));
        try {
            // This only works for static methods.
            // How would you modify this to work on instance methods?
            // How would you modify this to work for a singleton's instance methods?
            Class<?> receiver = Class.forName(_className);
            Method method = receiver.getMethod(_methodName, _paramTypes);
            method.invoke(null, _paramValues);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
