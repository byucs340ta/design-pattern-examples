package Singleton;

// What would you have to do to this class to guarantee there cannot be more than one instance
// of the class? (Hint: What could you do with a subclass to make something of type Printer not
// a singleton?)
public class Printer {
    // This class variable holds the only instance of a Printer.
    // If you wanted or needed an eager initialization of the singleton you could
    // just set this variable to a new instance.
    private static Printer SINGLETON;

    // We make the constructor private to guarantee that we control how many
    // instances can be made. In the case of a singleton we make sure there
    // is only ever one instance.
    private Printer() {

    }

    // This method allows other classes to get the sole instance of the Printer
    // class.
    public static Printer getInstance() {
        // This is how you lazily initialize the singleton.
        if (SINGLETON == null) {
            SINGLETON = new Printer();
        }
        return SINGLETON;
    }

    // Everything else in the class is the functionality the class is supposed
    // to have based on your design. This class only has one method and no member
    // variables, but in general a singleton can have as many methods and/or member
    // variables as it needs to fulfill it's purpose.
    public void printMessage(String message) {
        System.out.println("I'm printing the following line from a singleton");
        System.out.println(message);
    }
}
