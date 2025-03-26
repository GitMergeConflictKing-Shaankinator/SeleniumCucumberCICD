package utils;

public class Log {

    // ANSI escape codes for colors
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String YELLOW = "\033[0;33m";
    private static final String BLUE = "\033[0;34m";
    private static final String CYAN = "\033[0;36m";
    private static final String PURPLE = "\033[0;35m";
    private static final String WHITE = "\033[0;37m";

    // resources.Log levels
    public enum LogLevel {
        INFO, DEBUG, ERROR, WARN
    }

    // Method to print log messages with a specific color and format
    public static void log(LogLevel level, String message) {
        String logMessage = formatMessage(level, message);
        String color = getColorForLevel(level);

        // Print the log message in the specified color
        System.out.println(color + logMessage + RESET);
    }

    // Method to format log message with level and timestamp
    private static String formatMessage(LogLevel level, String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        return String.format("[%s] [%s] %s", timestamp, level, message);
    }

    // Method to get the color for a specific log level
    private static String getColorForLevel(LogLevel level) {
        switch (level) {
            case INFO:
                return GREEN;
            case DEBUG:
                return CYAN;
            case ERROR:
                return RED;
            case WARN:
                return YELLOW;
            default:
                return WHITE;
        }
    }

    // Shortcut methods for specific log levels
    public static void info(String message) {
        log(LogLevel.INFO, message);
    }

    public static void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public static void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public static void warn(String message) {
        log(LogLevel.WARN, message);
    }
}
