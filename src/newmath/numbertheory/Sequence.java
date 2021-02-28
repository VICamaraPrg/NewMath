package newmath.numbertheory;

import java.util.ArrayList;

/**
 * @author VIcamaraPRG
 * @version 1.0.1
 * @since 1.0
 */
public class Sequence {

    /**
     * The class cannot be instantiated.
     */
    private Sequence() {
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
     *              <br> A {@code limit} of 10, will show the first 10 Fibonacci numbers.
     * @return an {@link ArrayList} with Fibonacci sequence from 1 to specified
     * {@code limit}
     * @throws StackOverflowError ArithmeticException
     * @since 1.0
     */
    public static ArrayList<Long> fibonacci(long limit) {
        if (limit > 91)
            throw new StackOverflowError("""
                    The Fibonacci number
                    will overflow
                    """ + Long.MAX_VALUE);

        if (limit < 0)
            throw new ArithmeticException("Current limit: " + limit + "\n"
                    + "The limit must be a positive number.");


        ArrayList<Long> sequence = new ArrayList();
        long fibonacciNumber = 1;
        long previousNumber = 0;
        long sum;

        for (int i = 0; i < limit; i++) {
            sum = (previousNumber + fibonacciNumber);
            previousNumber = fibonacciNumber;
            fibonacciNumber = sum;
            if (fibonacciNumber < 0)
                return sequence;
            else
                sequence.add(fibonacciNumber);
        }

        return sequence;
    }
}
