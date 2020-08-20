package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static utils.Validations.*;



public class ValidationsTest {

        private ArrayList<String> digits = new ArrayList<>();

        @Test
        public void testIsCorrectLength() {
            Assert.assertEquals(true, hasCorrectLength("0125478698"));
            Assert.assertEquals(true, hasCorrectLength("01254786988459"));
            Assert.assertEquals(false, hasCorrectLength("02542"));
            Assert.assertEquals(false, hasCorrectLength(""));
            Assert.assertEquals(false, hasCorrectLength("66846684654986168465"));
        }

        @Test
        public void testIsCorrectFirstsDigits() {
            Assert.assertEquals(true, hasCorrectFirstsDigits("26468461"));
            Assert.assertEquals(true, hasCorrectFirstsDigits("6984584"));
            Assert.assertEquals(true, hasCorrectFirstsDigits("003026468461"));
            Assert.assertEquals(true, hasCorrectFirstsDigits("003069468461"));
            Assert.assertEquals(false, hasCorrectFirstsDigits("96468461"));
            Assert.assertEquals(false, hasCorrectFirstsDigits("003096468461"));
            Assert.assertEquals(false, hasCorrectFirstsDigits("0032468461"));
            Assert.assertEquals(false, hasCorrectFirstsDigits("030696468461"));
            Assert.assertEquals(false, hasCorrectFirstsDigits("030296468461"));
        }

        @Test
        public void testIsCorrectNumbersLengthInSequence() {
            digits.add("45");
            digits.add("215");
            digits.add("15");
            digits.add("65");
            Assert.assertEquals(true, hasCorrectNumbersLengthInSequence(digits));
            digits.add("5");
            Assert.assertEquals(true, hasCorrectNumbersLengthInSequence(digits));

            digits.clear();
            digits.add("1654 54 654 8");
            Assert.assertEquals(false, hasCorrectNumbersLengthInSequence(digits));

            digits.clear();
            digits.add("1654");
            Assert.assertEquals(false, hasCorrectNumbersLengthInSequence(digits));
        }

        @Test
        public void testIsOnlyNumbersAndSpaces() {
            Assert.assertEquals(true, hasOnlyNumbersAndSpaces("021 51 56 558   "));
            Assert.assertEquals(true, hasOnlyNumbersAndSpaces("0215156558"));
            Assert.assertEquals(false, hasOnlyNumbersAndSpaces("021 51 56 558."));
            Assert.assertEquals(false, hasOnlyNumbersAndSpaces("aa021 51 56 558   "));
            Assert.assertEquals(false, hasOnlyNumbersAndSpaces("as"));
        }

        @Test
        public void TestIsAllValidations() {
            digits.clear();
            digits.add("210");
            digits.add("25");
            digits.add("64");
            digits.add("789");
            Assert.assertEquals(true, isValid("6902564789", digits));

            digits.clear();
            digits.add("690");
            digits.add("25");
            digits.add("6");
            digits.add("7894");
            Assert.assertEquals(false, isValid("2102567894", digits));

            digits.clear();
            digits.add("210");
            digits.add("25");
            digits.add("645");
            digits.add("789");
            Assert.assertEquals(false, isValid("69025645789", digits));
        }
    }

