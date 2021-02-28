package newmath.numbertheory;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author VIcamaraPRG
 * @version 1.0.1
 * @since 1.0
 */
public class Utils {

    /**
     * The class cannot be instantiated.
     */
    private Utils() {
    }

    /**
     * Returns the double factorial of {@code a}.
     * <br>Don't misunderstand the double factorial as {@code (n!)!} Since that
     * means do the factorial twice. Double factorial takes the parity of n as
     * important term (odd or even).
     * <br>For even numbers:
     * {@code 10!! = 10(10-2)(10-4)... = 10*8*6*4*2 = 3840}
     * <br>For odd numbers:
     * {@code 11!! = 11(11-2)(11-4)... = 11*9*7*5*3*1 = 10395}
     * <br><br>If {@code a} is negative, an {@link ArithmeticException} will be
     * thrown, though a negative double factorial is possible, will probably be
     * implemented over time.
     *
     * @param a {@code long} value, must be positive.
     * @return the double factorial of {@code a}
     * @throws ArithmeticException
     * @since 1.0
     */
    public static long doubleFactorial(long a) {
        if (a < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");
        else if (a == 0)
            return 1;

        long total = 1;
        long limit = 1;

        if ((a % 2) == 0)
            limit = 0;

        while (a != limit) {
            total *= a;
            a -= 2;
        }

        return total;
    }

    /**
     * Returns an {@code ArrayList<Long>} with the list of double factorial
     * of {@code a}
     *
     * @param a the number to evaluate the double factorial.
     * @return a list containing the full sequence of double factorial.
     * @since 1.0.1
     */
    public static ArrayList<Long> doubleFactorialList(int a) {
        if (a < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");

        ArrayList<Long> dFactorialList = new ArrayList();
        dFactorialList.add(1L);
        int limit = 1;

        if (a % 2 == 0)
            limit = 0;

        while (a != limit) {
            dFactorialList.add(doubleFactorial(a));
            a -= 2;
        }
        Collections.sort(dFactorialList);

        return dFactorialList;
    }

    /**
     * Returns the positive factorial of {@code a}
     * <br>The method will overFlow {@link Long#MAX_VALUE} if {@code a} is avobe
     * 20.
     * <br><br>If {@code a} is avobe 20, an {@link StackOverflowError} Exception
     * will be thrown.
     * <br> As well as if the limit is negative, an {@link ArithmeticException}
     * will be thrown.
     *
     * @param a the factorial to get, must be positive.
     * @return the positive factorial of {@code a}
     * @throws ArithmeticException, StackOverflowError
     * @since 1.0
     */
    public static long factorial(long a) {
        if (a < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");
        else if (a > 20)
            throw new StackOverflowError("""
                    The input number will overflow
                    """ + Long.MAX_VALUE);
        else if (a == 0)
            return 1;

        long total = 1;
        while (a != 1) {
            total *= a;
            a--;
        }

        return total;
    }

    /**
     * Returns the positive factorial sequence of {@code a}
     * <br>The method will overFlow {@link Long#MAX_VALUE} if {@code a} is avobe
     * 20.
     * <br><br>If {@code a} is above 20, an {@link StackOverflowError} Exception
     * will be thrown.
     * <br> As well as if the limit is negative, an {@link ArithmeticException}
     * will be thrown.
     *
     * @param a the factorial sequence to get, must be positive.
     * @return the positive factorial sequence from 0 to {@code a}
     * @throws ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Long> factorialList(long a) {
        if (a < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");
        else if (a > 20)
            throw new StackOverflowError("""
                    The input number will overflow
                    """ + Long.MAX_VALUE);

        ArrayList<Long> factorialSequence = new ArrayList();

        for (int i = 1; i <= a; i++)
            factorialSequence.add(factorial(i));

        return factorialSequence;
    }

    /**
     * Returns a {@code long} with the greatest common divisor of {@code a} and
     * {@code b}
     *
     * @param a a {@code long} value, positive or negative.
     * @param b a {@code long} value, positive or negative.
     * @return The positive greatest common divisor of {@code a} and {@code b}
     * as {@code long}
     * @since 1.0
     */
    public static long greatestCD(long a, long b) {
        long temp;
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            temp = b;
            b = (a % b);
            a = temp;
        }

        return a;
    }

    /**
     * Returns an {@code int} with the greatest common divisor of {@code a} and
     * {@code b}
     *
     * @param a a {@code int} value, positive or negative.
     * @param b a {@code int} value, positive or negative.
     * @return The positive greatest common divisor of {@code a} and {@code b}
     * as {@code int}
     * @since 1.0
     */
    public static int greatestCD(int a, int b) {
        int temp;
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            temp = b;
            b = (a % b);
            a = temp;
        }

        return a;
    }

    /**
     * Returns the least common multiple of {@code a} and {@code b} by using the
     * greatest common divisor formula:
     * {@code leastCM(a,b) = (|(a*b)| / greatestCD(a,b))}
     * <br>If {@code a} and {@code b} are 0, an {@link ArithmeticException} will
     * be thrown.
     *
     * @param a a {@code long} value, positive or negative.
     * @param b a {@code long} value, positive or negative.
     * @return The positive least common multiple of {@code a} and {@code b} as
     * {@code long}.
     * @throws ArithmeticException
     * @since 1.0
     */
    public static long leastCM(long a, long b) {
        if (a == 0 && b == 0)
            throw new ArithmeticException("Divide by zero exception.");

        return (Math.abs(a * b) / greatestCD(a, b));
    }

    /**
     * Returns the least common multiple of {@code a} and {@code b} by using the
     * greatest common divisor formula:
     * {@code leastCM(a,b) = (|(a*b)| / greatestCD(a,b))}
     * <br>If {@code a} and {@code b} are 0, an {@link ArithmeticException} will
     * be thrown.
     *
     * @param a a {@code int} value, positive or negative.
     * @param b a {@code int} value, positive or negative.
     * @return The positive least common multiple of {@code a} and {@code b} as
     * {@code int}.
     * @throws ArithmeticException
     * @since 1.0
     */
    public static int leastCM(int a, int b) {
        if (a == 0 && b == 0)
            throw new ArithmeticException("Divide by zero exception.");

        return (int) (Math.abs(a * b) / greatestCD(a, b));
    }

}
