package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static utils.Validations.*;



public class ValidationsTest {

    @Test
    public void testValidations(){

        //test for isCorrectLength method
        Assert.assertEquals(true,isCorrectLength("0125478698"));
        Assert.assertEquals(true,isCorrectLength("01254786988459"));
        Assert.assertEquals(false,isCorrectLength("02542"));
        Assert.assertEquals(false,isCorrectLength(""));
        Assert.assertEquals(false,isCorrectLength("66846684654986168465"));

        Assert.assertEquals(true,isCorrectFirstsDigits("26468461"));
        Assert.assertEquals(true,isCorrectFirstsDigits("6984584"));
        Assert.assertEquals(true,isCorrectFirstsDigits("003026468461"));
        Assert.assertEquals(true,isCorrectFirstsDigits("003069468461"));
        Assert.assertEquals(false,isCorrectFirstsDigits("96468461"));
        Assert.assertEquals(false,isCorrectFirstsDigits("003096468461"));
        Assert.assertEquals(false,isCorrectFirstsDigits("0032468461"));
        Assert.assertEquals(false,isCorrectFirstsDigits("030696468461"));
        Assert.assertEquals(false,isCorrectFirstsDigits("030296468461"));

        ArrayList<String> digits=new ArrayList<>();
        digits.add("45");
        digits.add("215");
        digits.add("15");
        digits.add("65");
        Assert.assertEquals(true,isCorrectNumbersLengthInSequence(digits));
        digits.add("5");
        Assert.assertEquals(true,isCorrectNumbersLengthInSequence(digits));

        digits.clear();
        digits.add("1654 54 654 8");
        Assert.assertEquals(false,isCorrectNumbersLengthInSequence(digits));

        digits.clear();
        digits.add("1654");
        Assert.assertEquals(false,isCorrectNumbersLengthInSequence(digits));

        Assert.assertEquals(true,isOnlyNumbersAndSpaces("021 51 56 558   "));
        Assert.assertEquals(true,isOnlyNumbersAndSpaces("0215156558"));
        Assert.assertEquals(false,isOnlyNumbersAndSpaces("021 51 56 558."));
        Assert.assertEquals(false,isOnlyNumbersAndSpaces("aa021 51 56 558   "));
        Assert.assertEquals(false,isOnlyNumbersAndSpaces("as"));

        digits.clear();
        digits.add("210");
        digits.add("25");
        digits.add("64");
        digits.add("789");
        Assert.assertEquals(true,isAllValidations("6902564789",digits));
////
        digits.clear();
        digits.add("690");
        digits.add("25");
        digits.add("6");
        digits.add("7894");
        Assert.assertEquals(false,isAllValidations("2102567894",digits));
//
        digits.clear();
        digits.add("210");
        digits.add("25");
        digits.add("645");
        digits.add("789");
        Assert.assertEquals(false,isAllValidations("69025645789",digits));


    }
}
