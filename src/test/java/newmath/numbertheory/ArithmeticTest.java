package newmath.numbertheory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.util.ReadFile;

import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest {

    @Test
    void isAbundant() {
        ArrayList<Integer> abundants;
        abundants = ReadFile.readIntegers("./src/test/resources/arithmetic/knownAbundants.txt");
        //System.out.println(Paths.get("./src/test/resources/").toAbsolutePath().normalize().toString());
        boolean isAbundant;
        int nextAbundant;

        for (int i = 0; i < abundants.size(); i++) {
            nextAbundant = abundants.get(i);
            isAbundant = false;
            if (Arithmetic.isAbundant(nextAbundant)) {
                isAbundant = true;
                System.out.printf("%d: %b\n", nextAbundant, isAbundant);
                assertEquals(true, isAbundant);
            } else {
                System.out.printf("%d: %b\n", nextAbundant, isAbundant);
                Assertions.assertFalse(true);
            }
        }
    }

    @Test
    void isDeficient() {
        ArrayList<Integer> deficients;
        deficients = ReadFile.readIntegers("./src/test/resources/arithmetic/knownDeficients.txt");
        boolean isDeficient;
        int nextDeficient;

        for (int i = 0; i < deficients.size(); i++) {
            nextDeficient = deficients.get(i);
            isDeficient = false;
            if (Arithmetic.isDeficient(nextDeficient)) {
                isDeficient = true;
                System.out.printf("%d: %b\n", nextDeficient, isDeficient);
                assertEquals(true, isDeficient);
            } else {
                System.out.printf("%d: %b\n", nextDeficient, isDeficient);
                Assertions.assertFalse(true);
            }
        }
    }

    @Test
    void isPerfect() {
        ArrayList<Integer> perfects;
        perfects = ReadFile.readIntegers("./src/test/resources/arithmetic/knownPerfects.txt");
        boolean isPerfect;
        int nextPerfect;

        for (int i = 0; i < perfects.size(); i++) {
            nextPerfect = perfects.get(i);
            isPerfect = false;
            if (Arithmetic.isPerfect(nextPerfect)) {
                isPerfect = true;
                System.out.printf("%d: %b\n", nextPerfect, isPerfect);
                assertEquals(true, isPerfect);
            } else {
                System.out.printf("%d: %b\n", nextPerfect, isPerfect);
                Assertions.assertFalse(true);
            }
        }
    }
}