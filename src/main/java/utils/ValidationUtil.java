package utils;

public class ValidationUtil {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 10;
    public static boolean checkNumber(int number) {
        return number > MIN_NUMBER && number < MAX_NUMBER;
    }
}
