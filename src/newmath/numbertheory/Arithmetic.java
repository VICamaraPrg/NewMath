package newmath.numbertheory;

import java.util.ArrayList;

public class Arithmetic {

    private Arithmetic() {
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
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isAbundant(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = Factorization.getFactors(n);
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
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isDeficient(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = Factorization.getFactors(n);
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
     * @throws ArithmeticException
     * @since 1.0
     */
    public static boolean isPerfect(int n) {
        if (n < 0) {
            throw new ArithmeticException("Negative numbers are not allowed.");
        }

        ArrayList<Integer> vector = new ArrayList();
        vector = Factorization.getFactors(n);
        vector.remove(vector.size() - 1);
        int total = 0;

        for (int i = 0; i < vector.size(); i++) {
            total += vector.get(i);
        }

        return (total == n);
    }
}
