package Proxy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Logger implements ILogger {

    private void logMessage(String path, String message) throws Exception {
        // Here's the source for the try with resources block:
        // https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(message);
        }
    }

    @Override
    public void logAdminMessage(String message) throws Exception {
        logMessage(ADMIN_LOG_PATH, message);
    }

    @Override
    public void clearAdminLog() throws Exception {
        File file = new File(ADMIN_LOG_PATH);
        file.delete();
    }

    @Override
    public void logRegularMessage(String message) throws Exception {
        logMessage(REGULAR_LOG_PATH, message);
    }

    @Override
    public void clearRegularLog() throws Exception {
        File file = new File(REGULAR_LOG_PATH);
        file.delete();
    }

    @Override
    public void logGuestMessage(String message) throws Exception {
        logMessage(GUEST_LOG_PATH, message);
    }

    @Override
    public void clearGuestLog() throws Exception {
        File file = new File(GUEST_LOG_PATH);
        file.delete();
    }


    @Override
    public void clearAllLogs() throws Exception {
        clearAdminLog();
        clearGuestLog();
        clearRegularLog();
    }
}
