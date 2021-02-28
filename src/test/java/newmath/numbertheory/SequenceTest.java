package newmath.numbertheory;

import newmath.numbertheory.Sequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import test.util.ReadFile;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    @Test
    void fibonacci() {
        ArrayList<String> read;
        ArrayList<Long> numbersMethod;
        read = ReadFile.readStrings("./src/test/resources/sequence/knownFibonacci.txt");

        numbersMethod = Sequence.fibonacci(read.size());

        boolean correct;
        String next;

        for (int i = 0; i < read.size(); i++) {
            next = read.get(i);
            correct = false;
            if (next.equals(numbersMethod.get(i).toString())) {
                correct = true;
                System.out.printf("%s: %b\n", next, correct);
                assertEquals(true, correct);
            } else {
                System.out.printf("%s: %b\n", next, correct);
                Assertions.assertFalse(true);
            }
        }
    }
}