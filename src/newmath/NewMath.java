package newmath;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author VIcamaraPRG
 * @version 1.0.4
 * @since 1.0
 */
public class NewMath {

    /**
     * The class cannot be instantiated.
     */
    private NewMath() {
    }

    /**
     * Returns the Fibonacci sequence from 1 to {@code limit}.
     * <br>The method will overFlow {@link Long#MAX_VALUE} if {@code limit} is
     * avobe 91.
     * <br><br>If {@code limit} is avobe 91, an {@link StackOverflowError}
     * Exception will be thrown.
     * <br> As well as if the limit is negative, an {@link ArithmeticException}
     * will be thrown.
     *
     * @param limit sets the limit of numbers shown in Fibonacci sequence.
     * <br> A {@code limit} of 10, will show the first 10 Fibonacci numbers.
     * @return an {@link ArrayList} with Fibonacci sequence from 1 to specified
     * {@code limit}
     *
     * @throws StackOverflowError ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Long> fibonacciSequence(long limit) {
        if (limit > 91) {
            throw new StackOverflowError("""
                                         The Fibonacci number
                                         will overflow
                                         """ + Long.MAX_VALUE);
        }
        if (limit < 0) {
            throw new ArithmeticException("Current limit: " + limit + "\n"
                    + "The limit must be a positive number.");
        }

        ArrayList<Long> fibonacciSequence = new ArrayList();
        long fibonacciNumber = 1;
        long previousNumber = 0;
        long sum;
        for (int i = 0; i < limit; i++) {
            sum = (previousNumber + fibonacciNumber);
            previousNumber = fibonacciNumber;
            fibonacciNumber = sum;
            if (fibonacciNumber < 0) {
                return fibonacciSequence;
            } else {
                fibonacciSequence.add(fibonacciNumber);
            }
        }
        return fibonacciSequence;
    }

    /**
     * Returns a boolean based on the argument. Evaluates if it is a prime
     * number.
     * <br>If {@code n} is negative, an {@link ArithmeticException} will be
     * thrown.
     *
     * @param n {@code int} value, must be positive.
     * @return {@code true} if {@code n} is a prime number, otherwise
     * {@code false}.
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isPrimeNumber(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an {@link ArrayList} with all prime numbers from 0 to
     * {@code limit}
     * <br>If {@code n} is negative, an {@link ArithmeticException} will be
     * thrown.
     *
     * @param limit sets the limit of numbers to evaluate.
     * @return An {@code ArrayList} with all ordered prime numbers, from 0 to
     * specified {@code limit}
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Integer> nPrimeNumbers(int limit) {
        if (limit < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        for (int i = 0; i < limit; i++) {
            if (isPrimeNumber(i)) {
                vector.add(i);
            }
        }
        return vector;
    }

    /**
     * Returns a {@code long} with the greatest common divisor of {@code a} and
     * {@code b}
     *
     * @param a a {@code long} value, positive or negative.
     * @param b a {@code long} value, positive or negative.
     * @return The positive greatest common divisor of {@code a} and {@code b}
     * as {@code long}
     *
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
     *
     *
     * @since 1.0
     * @throws ArithmeticException
     */
    public static long leastCM(long a, long b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("Divide by zero exception.");
        }
        return (Math.abs(a * b) / greatestCD(a, b));
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
     *
     * @throws ArithmeticException, StackOverflowError
     * @since 1.0
     */
    public static long factorial(long a) {
        if (a < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        } else if (a > 20) {
            throw new StackOverflowError("""
                                         The input number will overflow
                                         """ + Long.MAX_VALUE);
        } else if (a == 0) {
            return 1;
        }

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
     * <br><br>If {@code a} is avobe 20, an {@link StackOverflowError} Exception
     * will be thrown.
     * <br> As well as if the limit is negative, an {@link ArithmeticException}
     * will be thrown.
     *
     * @param a the factorial sequence to get, must be positive.
     * @return the positive factorial sequence from 0 to {@code a}
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Long> factorialSequence(long a) {
        if (a < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        } else if (a > 20) {
            throw new StackOverflowError("""
                                         The input number will overflow
                                         """ + Long.MAX_VALUE);
        }
        ArrayList<Long> factorialSequence = new ArrayList();

        for (int i = 1; i <= a; i++) {
            factorialSequence.add(factorial(i));
        }
        return factorialSequence;
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
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static long doubleFactorial(long a) {
        if (a < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        } else if (a == 0) {
            return 1;
        }

        long total = 1;
        long limit = 1;

        if ((a % 2) == 0) {
            limit = 0;
        }

        while (a != limit) {
            total *= a;
            a -= 2;
        }
        return total;
    }

    /**
     * Returns an {@link ArrayList} with all factors/divisors of {@code a} from
     * 1 to {@code a} inclusive. Negative numbers are allowed.
     *
     * @param a the number to get its factors.
     * @return an {@link ArrayList} with all divisors of {@code a}
     *
     * @since 1.0
     */
    public static ArrayList<Integer> getFactors(int a) {
        a = Math.abs(a);
        ArrayList<Integer> factors = new ArrayList();
        int b = a;

        if (a == 0 || a == 1) {
            factors.add(0);
            return factors;
        } else if (isPrimeNumber(a)) {
            factors.add(1);
            return factors;
        } else {
            for (int i = 1; i <= Math.sqrt(b); i++) {
                if (b % i == 0) {
                    factors.add(i);
                    if (i != b / i) {
                        factors.add(b / i);
                    }
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    /**
     * Returns a {@code boolean} based if {@code n} is an abundant number.
     * <br>In order to be abundant, the sum of divisors (excluding {@code n}) of
     * {@code n} must be higher than {@code n} itself.
     * <br>If {@code n} is negative, an {@link ArithmeticException} will be
     * thrown.
     *
     * @param n the number to evaluate, must be positive.
     * @return {@code true} if {@code n} is abundant number, otherwise
     * {@code false}
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isAbundantNumber(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = NewMath.getFactors(n);
        vector.remove(vector.size() - 1);
        
        int total = 0;

        for (int i = 0; i < vector.size(); i++) {
            total += vector.get(i);
        }

        return (total > n);
    }

    /**
     * Returns a {@code boolean} based if {@code n} is a deficient number.
     * <br>In order to be deficient, the sum of divisors (excluding {@code n})
     * of {@code n} must be lower than {@code n} itself.
     * <br>If {@code n} is negative, an {@link ArithmeticException} will be
     * thrown.
     *
     * @param n the number to evaluate, must be positive.
     * @return {@code true} if {@code n} is deficient number, otherwise
     * {@code false}
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isDeficientNumber(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = NewMath.getFactors(n);
        vector.remove(vector.size() - 1);
        int total = 0;

        for (int i = 0; i < vector.size(); i++) {
            total += vector.get(i);
        }

        return (total < n);
    }

    /**
     * Returns a {@code boolean} based if {@code n} is a perfect number.
     * <br>In order to be perfect, the sum of divisors (excluding {@code n}) of
     * {@code n} must be equal to {@code n} itself.
     * <br>If {@code n} is negative, an {@link ArithmeticException} will be
     * thrown.
     *
     * @param n the number to evaluate, must be positive.
     * @return {@code true} if {@code n} is a perfect number, otherwise
     * {@code false}
     *
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isPerfectNumber(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = NewMath.getFactors(n);
        vector.remove(vector.size() - 1);
        int total = 0;

        for (int i = 0; i < vector.size(); i++) {
            total += vector.get(i);
        }

        return (total == n);
    }
}
