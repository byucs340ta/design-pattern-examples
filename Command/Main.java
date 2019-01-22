package Command;

import java.util.Scanner;

// How would you change the overall program to keep track of what commands
// were executed and with what parameters (if any)?
public class Main {
    public static void main(String args[]) {
        boolean keepLooping = true;
        try {
            Scanner scanner = new Scanner(System.in);
            while (keepLooping) {
                    // First we prompt the user
                    prompt();
                    // Take in the input
                    String message = scanner.next();
                    // Handle the input
                    keepLooping = handleMessage(message, scanner);
            }
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void prompt() {
        System.out.println("What command do you want to execute? (--exit to quit)");

        System.out.println("Specific Commands:");
        System.out.println("0 - Swing Sword");
        System.out.println("1 - Raise Shield");
        System.out.println("2 - Jump");
        System.out.println("3 - Move");

        System.out.println("Generic Commands:");
        System.out.println("4 - Swing Sword");
        System.out.println("5 - Raise Shield");
        System.out.println("6 - Jump");
        System.out.println("7 - Move");
    }

    // Here we look at the user's input and decide what command (if any) to create and execute
    private static boolean handleMessage(String message, Scanner scanner) {
        Command command = null;
        switch (message) {
            case "--exit":
                return false;
            case "0":
                Swing swing = promptSwingSword(scanner);
                command = createSpecificSSCommand(swing);
                break;
            case "1":
                command = createSpecificRSCommand();
                break;
            case "2":
                command = createSpecificJumpCommand();
                break;
            case "3":
                Location location = promptMove(scanner);
                command = createSpecificMoveCommand(location);
                break;
            case "4":
                swing = promptSwingSword(scanner);
                command = createGenericSSCommand(swing);
                break;
            case "5":
                command = createGenericRSCommand();
                break;
            case "6":
                command = createGenericJumpCommand();
                break;
            case "7":
                location = promptMove(scanner);
                command = createGenericMoveCommand(location);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
        if (command != null) {
            command.execute();
        }
        return true;

    }

    // These next two functions will break if you give them something that isn't an int.
    // How would you fix them so that you can't break them?
    private static Swing promptSwingSword(Scanner scanner) {
        System.out.println("What angle do you want to swing at?");
        int angle = scanner.nextInt();
        System.out.println("What speed do you want to swing with?");
        int speed = scanner.nextInt();
        return new Swing(angle, speed);
    }

    private static Location promptMove(Scanner scanner) {
        System.out.println("What x position do you want to move to?");
        int x = scanner.nextInt();
        System.out.println("What y position do you want to move to?");
        int y = scanner.nextInt();
        return new Location(x, y);
    }

    // What pattern could you use to replace all of these createCommand functions?
    private static Command createSpecificSSCommand(Swing swing) {
        return new SwingSwordCommand(swing);
    }

    private static Command createSpecificRSCommand() {
        return new RaiseShieldCommand();
    }

    private static Command createSpecificMoveCommand(Location location) {
        return new MoveCommand(location);
    }

    private static Command createSpecificJumpCommand() {
        return new JumpCommand();
    }


    private static Command createGenericSSCommand(Swing swing) {
        return new GenericCommand("Command.VideoGame", "swingSword",
                new Class<?>[]{ Swing.class},
                new Object[] { swing });
    }

    private static Command createGenericRSCommand() {
        return new GenericCommand("Command.VideoGame", "raiseShield",
                new Class<?>[]{  },
                new Object[] { });
    }

    private static Command createGenericMoveCommand(Location location) {
        return new GenericCommand("Command.VideoGame", "move",
                new Class<?>[]{ Location.class },
                new Object[] { location });
    }

    private static Command createGenericJumpCommand() {
        return new GenericCommand("Command.VideoGame", "jump",
                new Class<?>[] { },
                new Object[] { });
    }
}