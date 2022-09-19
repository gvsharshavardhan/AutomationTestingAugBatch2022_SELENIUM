package sleepHelperMethods;

public class SleepHelper {
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }
}