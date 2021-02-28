package newmath.numbertheory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.util.ReadFile;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactorizationTest {

    @Test
    void getFactors() {
        ArrayList lines = new ArrayList();
        lines = ReadFile.readStrings("./src/test/resources/factorization/knownFactors.txt");
        String checkFromFile;
        String checkFromMethod;
        boolean areEqual;

        for (int i = 0; i < lines.size(); i++) {
            checkFromFile = "[" + lines.get(i) + "]";
            checkFromMethod = Factorization.getFactors(i)
                    .toString()
                    .replace(" ", "");
            areEqual = false;

            if (checkFromFile.equals(checkFromMethod)) {
                areEqual = true;
                System.out.printf("%s = %s\n", checkFromFile, checkFromMethod);
                assertEquals(true, areEqual);
            } else {
                System.out.printf("%s != %s\n", checkFromFile, checkFromMethod);
                Assertions.assertFalse(true);
            }
        }
    }

    @Test
    void getPrimeFactors() {
        ArrayList lines = new ArrayList();
        lines = ReadFile.readStrings("./src/test/resources/factorization/knownPrimeFactors.txt");
        String checkFromFile;
        String checkFromMethod;
        boolean areEqual;

        for (int i = 0; i < lines.size(); i++) {
            checkFromFile = "[" + lines.get(i) + "]";
            checkFromMethod = Factorization.getPrimeFactors(i)
                    .toString()
                    .replace(" ", "");
            areEqual = false;

            if (checkFromFile.equals(checkFromMethod)) {
                areEqual = true;
                System.out.printf("%s = %s\n", checkFromFile, checkFromMethod);
                assertEquals(true, areEqual);
            } else {
                System.out.printf("%s != %s\n", checkFromFile, checkFromMethod);
                Assertions.assertFalse(true);
            }
        }
    }
}