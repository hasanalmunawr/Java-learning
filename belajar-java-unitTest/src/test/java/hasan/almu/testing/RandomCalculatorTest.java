package hasan.almu.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.Extensions;

import java.util.Random;
import java.util.Scanner;


public class RandomCalculatorTest extends ParentCalculatorTest{

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.Add(a,b);
        Assertions.assertEquals(a + b, result);
        System.out.println(a + b);
        System.out.println(a + b);

    }


    @DisplayName("Calculator Random")
    @RepeatedTest(value = 4)
    public void testRandom1(Random random, TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + "ke " + repetitionInfo.getCurrentRepetition() + " total "+ repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.Add(a,b);
        Assertions.assertEquals(a + b, result);
        System.out.println(a + b);
        System.out.println(a + b);
    }


}
