package Singleton;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        boolean keepLooping = true;

        // Here is where we get the instance of Printer
        Printer printer = Printer.getInstance();
        // The following line will fail to compile if you uncomment it:
        // Printer printer = new Printer();
        // This is because there is no public constructor.
        try {
            Scanner scanner = new Scanner(System.in);
            while (keepLooping) {
                System.out.print("What message would you like me to print? (Type --exit to exit) ");
                String message = scanner.next();
                if (message.equals("--exit")) {
                    keepLooping = false;
                } else {
                    printer.printMessage(message);
                }
            }
        } catch (Exception e) {
            // Ignoring the exception and letting the program die.
            // Generally you should handle the exception, but we don't care here.
        }
        printer.printMessage("Exiting, good-bye...");
    }
}
