package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static utils.Validations.*;
import static utils.Validations.rightNumbersLengthInSequense;


public class ValidationsTest {

    @Test
    public void testValidations(){

        //test for rightLength method
        Assert.assertEquals(true,rightLength("0125478698"));
        Assert.assertEquals(true,rightLength("01254786988459"));
        Assert.assertEquals(false,rightLength("02542"));
        Assert.assertEquals(false,rightLength(""));
        Assert.assertEquals(false,rightLength("66846684654986168465"));

        Assert.assertEquals(true,rightFirstsDigits("26468461"));
        Assert.assertEquals(true,rightFirstsDigits("6984584"));
        Assert.assertEquals(true,rightFirstsDigits("003026468461"));
        Assert.assertEquals(true,rightFirstsDigits("003069468461"));
        Assert.assertEquals(false,rightFirstsDigits("96468461"));
        Assert.assertEquals(false,rightFirstsDigits("003096468461"));
        Assert.assertEquals(false,rightFirstsDigits("0032468461"));
        Assert.assertEquals(false,rightFirstsDigits("030696468461"));
        Assert.assertEquals(false,rightFirstsDigits("030296468461"));

        ArrayList<String> digits=new ArrayList<>();
        digits.add("45");
        digits.add("215");
        digits.add("15");
        digits.add("65");
        Assert.assertEquals(true,rightNumbersLengthInSequense(digits));
        digits.add("5");
        Assert.assertEquals(true,rightNumbersLengthInSequense(digits));

        digits.clear();
        digits.add("1654 54 654 8");
        Assert.assertEquals(false,rightNumbersLengthInSequense(digits));

        digits.clear();
        digits.add("1654");
        Assert.assertEquals(false,rightNumbersLengthInSequense(digits));

        Assert.assertEquals(true,onlyNumbersAndSpaces("021 51 56 558   "));
        Assert.assertEquals(true,onlyNumbersAndSpaces("0215156558"));
        Assert.assertEquals(false,onlyNumbersAndSpaces("021 51 56 558."));
        Assert.assertEquals(false,onlyNumbersAndSpaces("aa021 51 56 558   "));
        Assert.assertEquals(false,onlyNumbersAndSpaces("as"));

        digits.clear();
        digits.add("210");
        digits.add("25");
        digits.add("64");
        digits.add("789");
        Assert.assertEquals(true,allValidations("6902564789",digits));
////
        digits.clear();
        digits.add("690");
        digits.add("25");
        digits.add("6");
        digits.add("7894");
        Assert.assertEquals(false,allValidations("2102567894",digits));
//
        digits.clear();
        digits.add("210");
        digits.add("25");
        digits.add("645");
        digits.add("789");
        Assert.assertEquals(false,allValidations("69025645789",digits));


    }
}
