package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static utils.InsertNumber.phoneNumbersWithoutSpaces;
import static utils.InsertNumber.sequenseWithoutSpaces;

public class InsertNumberTest {

    @Test
    public void testInsertNumber(){

        ArrayList<Integer> phoneNumber=new ArrayList<>();
        phoneNumber.add(00);
        phoneNumber.add(2);
        phoneNumber.add(3);
        phoneNumber.add(4);
        Assert.assertEquals(phoneNumber,phoneNumbersWithoutSpaces("00 2 3    4"));

        ArrayList<String> phoneNumber2=new ArrayList<>();
        phoneNumber2.add("0");
        phoneNumber2.add("22");
        phoneNumber2.add("3");
        phoneNumber2.add("544");
        Assert.assertEquals(phoneNumber2,sequenseWithoutSpaces("0 22 3    544"));




    }
}
