package Proxy;

// Static imports to simplify setting/using the enum

import static Proxy.LoginStatus.*;

import java.util.Scanner;

public class Main {

    private static LoginStatus loginStatus = LOGGED_OUT;

    public static void main(String args[]) {
        boolean keepLooping = true;

        ILogger logger = new LoggerProxy();
        try {
            Scanner scanner = new Scanner(System.in);
            while (keepLooping) {
                try {
                    // First we prompt the user
                    prompt();
                    // Take in the input
                    String message = scanner.next();
                    // Handle the input
                    keepLooping = handleMessage(message, logger);
                } catch (PermissionException e) {
                    System.out.println("Sorry, you do not have permission for that action");
                }
            }
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void prompt() {
        switch (loginStatus) {
            case LOGGED_OUT:
                System.out.println("Who are you logging in as? (Type --exit to exit)");
                System.out.println("Admin (1)\nRegular User (2)\nGuest (3)");
                break;
            case ADMIN:
                System.out.println("You can clear all logs (--clear-all)");
                System.out.println("You can clear the admin log (--clear-admin)");
            case REGULAR_USER:
                System.out.println("You can clear the regular user logs (--clear-regular)");
                System.out.println("You can clear the guest logs (--clear-guest)");
            case GUEST:
                System.out.println("What do you want to log? (--logout to logout)");
        }
    }

    private static boolean handleMessage(String message, ILogger logger) throws Exception {
        switch (message) {
            case "--exit":
                return false;
            case "--logout":
                loginStatus = LOGGED_OUT;
                break;
            case "--clear-all":
                logger.clearAllLogs();
            case "--clear-admin":
                logger.clearAdminLog();
            case "--clear-regular":
                logger.clearRegularLog();
            case "--clear-guest":
                logger.clearGuestLog();
                break;
            default:
                if (loginStatus == ADMIN) {
                    logger.logAdminMessage(message);
                } else if (loginStatus == REGULAR_USER) {
                    logger.logRegularMessage(message);
                } else if (loginStatus == GUEST) {
                    logger.logGuestMessage(message);
                } else { // If you're not logged in, then use the message to try to login
                    switch (message) {
                        case "1":
                            loginStatus = ADMIN;
                            break;
                        case "2":
                            loginStatus = REGULAR_USER;
                            break;
                        case "3":
                            loginStatus = GUEST;
                            break;
                        default:
                            System.out.println("That's not a valid user, try again.");
                    }
                }
                break;
        }
        return true;
    }

    public static LoginStatus getLoginStatus() {
        return loginStatus;
    }
}
