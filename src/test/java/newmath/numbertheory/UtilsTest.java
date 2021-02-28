package newmath.numbertheory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.util.ReadFile;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    /*
    TESTS WILL BE DONE IN RELEASE 1.1

    @Test
    void doubleFactorial() {
    }


    @Test
    void doubleFactorialList() {
    }
    */

    @Test
    void factorial() {
        ArrayList<Long> factorials;
        factorials = ReadFile.readLongs("./src/test/resources/utils/knownFactorial.txt");
        boolean areEqual;
        long checkFromFile, checkFromMethod;

        for (int i = 1; i < factorials.size(); i++) {
            checkFromFile = factorials.get(i - 1);
            checkFromMethod = Utils.factorial(i);
            areEqual = false;
            if (checkFromFile == checkFromMethod) {
                areEqual = true;
                System.out.printf("%d = %d\n", checkFromFile, checkFromMethod);
                assertEquals(true, areEqual);
            } else {
                System.out.printf("%d != %d\n", checkFromFile, checkFromMethod);
                Assertions.assertFalse(true);
            }
        }
    }

    @Test
    void factorialList() {
        ArrayList lines = new ArrayList();
        lines = ReadFile.readStrings("./src/test/resources/utils/knownFactorialList.txt");
        String checkFromFile;
        String checkFromMethod;
        boolean areEqual;

        for (int i = 1; i < lines.size(); i++) {
            checkFromFile = "[" + lines.get(i - 1) + "]";
            checkFromMethod = Utils.factorialList(i)
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

    /*
    TESTS WILL BE DONE IN MINOR RELEASE

    @Test
    void greatestCD() {
    }

    @Test
    void testGreatestCD() {
    }

    @Test
    void leastCM() {
    }

    @Test
    void testLeastCM() {
    }
    */
}