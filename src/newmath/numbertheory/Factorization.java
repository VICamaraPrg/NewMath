package newmath.numbertheory;

import java.util.ArrayList;
import java.util.Collections;
import newmath.numbertheory.Prime.*;

/**
 * @author VICamaraPRG
 * @version 1.0.1
 * @since 1.0
 */
public class Factorization {

    /**
     * The class cannot be instantiated.
     */
    private Factorization() {
    }

    /**
     * Returns an {@link ArrayList} with all factors/divisors of {@code a} from
     * 1 to {@code a} inclusive. Negative numbers are allowed.
     *
     * @param a the number to get its factors.
     * @return an {@link ArrayList} with all divisors of {@code a}
     * @since 1.0
     */
    public static ArrayList<Integer> getFactors(int a) {
        a = Math.abs(a);
        ArrayList<Integer> factors = new ArrayList();
        int b = a;

        if (a == 0 || a == 1) {
            factors.add(0);
            return factors;
        } else if (Prime.isPrimeNumber(a)) {
            factors.add(1);
            return factors;
        } else {
            for (int i = 1; i <= Math.sqrt(b); i++) {
                if (b % i == 0) {
                    factors.add(i);
                    if (i != b / i)
                        factors.add(b / i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    /**
     * Returns an {@link ArrayList} with all factors/divisors
     * of {@code a} from1 to {@code a} inclusive.
     * Negative numbers are allowed.
     *
     * @param a the number to get its prime factors.
     * @return
     * @since 1.0.1
     */
    public static ArrayList<Integer> primeFactors(int a) {
        if (a < 0)
            throw new ArithmeticException("Negative numbers are not allowed.");

        ArrayList<Integer> primes = new ArrayList();

        int divisor, power;

        while (a % 2 == 0) {
            primes.add(2);
            a /= 2;
        }

        divisor = 3;
        power = (int) Math.pow(divisor, 2);

        while (power <= a) {
            if (a % divisor == 0) {
                primes.add(divisor);
                a /= divisor;
            } else
                divisor = Prime.getNextPrime(divisor + 1);
        }
        if (a != 1)
            primes.add(a);

        return primes;
    }
}
