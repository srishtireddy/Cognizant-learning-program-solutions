// Implementing the Singleton Pattern 
public class Exercise1 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");

        if (logger1 == logger2) {
            System.out.println("Only one instance exists. Singleton works!");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
class Logger {
    private static Logger instance;

    private Logger() { }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

/*
 * Output:
 *  LOG: First log message
 *  LOG: Second log message
 *  Only one instance exists. Singleton works!
 */