package newmath.numbertheory;

import java.util.ArrayList;

/**
 * @author VIcamaraPRG
 * @version 1.0.3
 * @since 1.0
 */
public class Prime {

    /**
     * The class cannot be instantiated.
     */
    private Prime() {
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
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isPrime(int n) {
        if (n < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");

        if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        int max = (int) Math.sqrt(n);
        for (int i = 3; i <= max; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Returns the next closest prime number given a number {@code n}.
     *
     * @param n {@code int} value to evaluate.
     * @return The closest upper prime.
     * @since 1.0.2
     */
    public static int getNext(int n) {
        int next = n;
        if (n <= 1)
            return 2;
        else if (n == 2)
            return 3;
        else if (isPrime(next))
            next += 2;
        else if (n % 2 == 0)
            next++;

        while (!isPrime(next))
            next += 2;

        return next;
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
     * @throws ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Integer> nPrimes(int limit) {
        if (limit < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");

        ArrayList<Integer> primes = new ArrayList();

        for (int i = 0; i <= limit; i++) {
            if (isPrime(i))
                primes.add(i);
        }
        return primes;
    }

}