package newmath.numbertheory;

import newmath.numbertheory.Prime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.util.ReadFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


class PrimeTest {

    @Test
    void isPrime() {
        ArrayList<Integer> primes;
        primes = ReadFile.readIntegers("./src/test/resources/prime/knownPrimes.txt");

        boolean isPrime;
        int nextPrime;

        for (int j = 0; j < primes.size(); j++) {
            nextPrime = primes.get(j);
            isPrime = false;
            if (Prime.isPrime(nextPrime)) {
                isPrime = true;
                System.out.printf("%d: %b\n", nextPrime, isPrime);
                assertEquals(true, isPrime);
            } else {
                System.out.printf("%d: %b\n", nextPrime, isPrime);
                Assertions.assertFalse(true);
            }
        }
    }

    @Test
    void getNext() {
        ArrayList<Integer> primes;
        primes = ReadFile.readIntegers("./src/test/resources/prime/knownPrimes.txt");

        int nextRealPrime, nextMethodPrime = 0;
        boolean equals = false;

        for (int i = 0; i < primes.size(); i++) {
            nextRealPrime = primes.get(i);
            nextMethodPrime = Prime.getNext(nextRealPrime - 1);

            if (nextRealPrime == nextMethodPrime) {
                equals = true;
                System.out.printf("%d - %d: %b\n", nextRealPrime, nextMethodPrime, equals);
                assertEquals(true, equals);
            } else {
                System.out.printf("%d - %d: %b\n", nextRealPrime, nextMethodPrime, equals);
                Assertions.assertFalse(true);
            }
        }
    }
}