package Proxy;

public interface ILogger {
    String ADMIN_LOG_PATH = "./admin.log";
    String REGULAR_LOG_PATH = "./regular.log";
    String GUEST_LOG_PATH = "./guest.log";

    void logAdminMessage(String message) throws Exception;
    void clearAdminLog() throws Exception;
    void logRegularMessage(String message) throws Exception;
    void clearRegularLog() throws Exception;
    void logGuestMessage(String message) throws Exception;
    void clearGuestLog() throws Exception;
    void clearAllLogs() throws Exception;
}
