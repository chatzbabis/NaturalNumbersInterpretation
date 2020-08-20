package utils;

import java.util.ArrayList;
import java.util.Scanner;


import static utils.Interpretations.beginInterpretation;
import static utils.Validations.isValid;


public class PhoneNumber {

    public static String getPhoneInput() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        String phone;
        String phoneNumbersWithoutSpaces;
        ArrayList<String> phoneNumbersInList;
        do {
            System.out.println("Enter the phone Number: ");
            phone = sc.nextLine();  // Read user input
            phoneNumbersInList = sequenceWithoutSpaces(phone);
            phoneNumbersWithoutSpaces= phone.replaceAll("\\s+","");
        }while (!isValid(phoneNumbersWithoutSpaces,phoneNumbersInList));
        return phone;
    }

        // if phoneNumber begins with "0030" take the other digits and begin the calculation of interpretation
        public static void internationalOrDomestic(String phone){

        if (phone.substring(0,1).equals("0") || phone.substring(0,2).equals("00")|| phone.substring(0,3).equals("003")) {

            int indexOfThirdZero=3;
            for (int i=0; i<3; i++) indexOfThirdZero = phone.indexOf('0', indexOfThirdZero);
            String rightPartAfterThirdZero;
            System.out.println(phone.substring(indexOfThirdZero+1,indexOfThirdZero+2));
            if (phone.substring(indexOfThirdZero+1,indexOfThirdZero+2).equals(" ")) {
                 rightPartAfterThirdZero = phone.substring(indexOfThirdZero + 2);
            }else{
                rightPartAfterThirdZero = phone.substring(indexOfThirdZero + 1);
            }

            ArrayList <Integer> phoneNumbersInList=phoneNumbersWithoutSpaces(rightPartAfterThirdZero);
            beginInterpretation(phoneNumbersInList,true);

        }
        else{
            ArrayList <Integer> phoneNumbersInList=phoneNumbersWithoutSpaces(phone);
            beginInterpretation(phoneNumbersInList,false);
        }
    }


    //Create an arrayList of Integers with the numbers of phoneNumber
    public static ArrayList<Integer> phoneNumbersWithoutSpaces(String phoneNumbers){
        ArrayList<Integer> phoneNumbersInList = new ArrayList<>();
        String[] arrayOfNumberDigitGroups = phoneNumbers.split("\\s+");

        for (String digit:arrayOfNumberDigitGroups) {
            phoneNumbersInList.add(Integer.parseInt(digit));
        }
        return phoneNumbersInList;
    }

    //Create an arrayList of Strings with the numbers of phoneNumber
    public static ArrayList<String> sequenceWithoutSpaces(String phoneNumbers){
        ArrayList<String> phone=new ArrayList<String>();
        String[] arrayOfNumberDigitGroups = phoneNumbers.split("\\s+");

        for (String digit:arrayOfNumberDigitGroups
        ) {
            phone.add(digit);
        }
        return phone;
    }
}
