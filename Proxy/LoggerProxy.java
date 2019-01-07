package Proxy;

import static Proxy.LoginStatus.*;

// This class could also be a singleton
public class LoggerProxy implements ILogger {
    // This could also reference the logger singleton if it was written as a singleton
    private ILogger logger = new Logger();

    @Override
    public void logAdminMessage(String message) throws Exception {
        // Check if the action is allowed, if it is then do it, otherwise throw an exception.
        // All of the overridden methods are like this in this class.
        if (allowedAction(Main.getLoginStatus(), ADMIN_LOG_PATH)) {
            logger.logAdminMessage(message);
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void clearAdminLog() throws Exception {
        if (allowedAction(Main.getLoginStatus(), ADMIN_LOG_PATH)) {
            logger.clearAdminLog();
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void logRegularMessage(String message) throws Exception {
        if (allowedAction(Main.getLoginStatus(), REGULAR_LOG_PATH)) {
            logger.logRegularMessage(message);
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void clearRegularLog() throws Exception {
        if (allowedAction(Main.getLoginStatus(), REGULAR_LOG_PATH)) {
            logger.clearRegularLog();
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void logGuestMessage(String message) throws Exception {
        if (allowedAction(Main.getLoginStatus(), GUEST_LOG_PATH)) {
            logger.logGuestMessage(message);
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void clearGuestLog() throws Exception {
        if (allowedAction(Main.getLoginStatus(), GUEST_LOG_PATH)) {
            logger.clearGuestLog();
        } else {
            throw new PermissionException();
        }
    }

    @Override
    public void clearAllLogs() throws Exception {
        LoginStatus loginStatus = Main.getLoginStatus();
        if (allowedAction(loginStatus, ADMIN_LOG_PATH)
                && allowedAction(loginStatus, REGULAR_LOG_PATH)
                && allowedAction(loginStatus, GUEST_LOG_PATH)) {
            logger.clearAllLogs();
        } else  {
            throw new PermissionException();
        }
    }

    private boolean allowedAction(LoginStatus loginStatus, String path) {
        // Admins can do anything
       return loginStatus == ADMIN
               // Regular users can do anything that doesn't involve the admin log
               || (loginStatus == REGULAR_USER && !path.equals(ADMIN_LOG_PATH))
               // Guests can only interact with the guest log
               || (loginStatus == GUEST && path.equals(GUEST_LOG_PATH));
    }
}
