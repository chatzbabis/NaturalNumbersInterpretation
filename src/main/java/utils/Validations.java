package utils;

import java.util.ArrayList;

public class Validations {

    public static boolean allValidations(String phoneNumber,ArrayList<String> phoneNumberInList){
        if (!onlyNumbersAndSpaces(phoneNumber)){
            return false;
        }
        else if (!rightLength(phoneNumber)){
            return false;
        }else if(!rightFirstsDigits(phoneNumber)){
            return false;
        }else if(!rightNumbersLengthInSequense(phoneNumberInList)){
            return false;
        }
        return true;
    }

    public static boolean rightLength(String phone){
        if (phone.length()==10 || phone.length()==14){
            return true;
        }
        System.out.println("The phone number must have '10' or '14' digits");
        return false;
    }
    public static boolean rightFirstsDigits(String phone){
        if (phone.substring(0,1).equals("2") || phone.substring(0,2).equals("69")){
            return true;
        }
        if (phone.substring(0,4).equals("0030") &&(phone.substring(4,5).equals("2") || phone.substring(4,6).equals("69"))){
            return true;
        }
        System.out.println("The number must start with '2' or '69' for demistic calls and with '00302'or '003069' for international calls");
        return false;
    }

    public static boolean rightNumbersLengthInSequense(ArrayList<String> phoneNumber){
        boolean flag=true;

        for (String number: phoneNumber) {

            if (number.length()>3){
                flag=false;
            }
        }
        if (!flag){
            System.out.println("Each number in the input sequence must be up to a three digit number");
        }
        return flag;
    }

    public static boolean onlyNumbersAndSpaces(String phoneNumber){

        if (phoneNumber.matches("[0-9 ]+")){

            return true;
        }
        System.out.println("The phone numbers must contain only numbers and spaces");
        return false;
    }

}
