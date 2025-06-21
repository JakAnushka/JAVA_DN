
class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger initialized");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        // Getting the singleton instance of Logger
        Logger logger1 = Logger.getInstance();
        logger1.log("First message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second message");

        // Verifying both references point to the same object
        if (logger1 == logger2) {
            System.out.println("logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances! Singleton pattern failed.");
        }
    }
}
