package utils;

import java.util.ArrayList;
import java.util.Scanner;


import static utils.Interpretations.firstDigitCases;
import static utils.Validations.isAllValidationsTrue;


public class InsertNumber {

    //private String phoneNumbers;

    //private ArrayList<Integer> phone;

    public static String insertPhone() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object


        String phone;
        String phoneNumbersWithoutSpaces;
        ArrayList<String> phoneNumbersInList;
        do {
            System.out.println("Enter the phone Number: ");
            phone = sc.nextLine();  // Read user input
            phoneNumbersInList = sequenseWithoutSpaces(phone);
            phoneNumbersWithoutSpaces= phone.replaceAll("\\s+","");
        }while (!isAllValidationsTrue(phoneNumbersWithoutSpaces,phoneNumbersInList));
        return phone;
    }

        // if phoneNumber begins with "0030" take the other digits and begin the calculation of interpretation
        public static void internationalOrDomestic(String phone){



        if (phone.substring(0,1).equals("0") || phone.substring(0,2).equals("00")|| phone.substring(0,3).equals("003")) {

            int indexOfThirdZero=3;
            int index=2;
            for (int i=0; i<3; i++) indexOfThirdZero = phone.indexOf('0', indexOfThirdZero);
            String left = phone.substring(0, indexOfThirdZero);
            String right;
            System.out.println(phone.substring(indexOfThirdZero+1,indexOfThirdZero+2));
            if (phone.substring(indexOfThirdZero+1,indexOfThirdZero+2).equals(" ")) {
                 right = phone.substring(indexOfThirdZero + 2);
            }else{
                right = phone.substring(indexOfThirdZero + 1);
            }


            ArrayList <Integer> phoneNumbersInList=phoneNumbersWithoutSpaces(right);
            firstDigitCases(phoneNumbersInList,true);


        }
        else{

            ArrayList <Integer> phoneNumbersInList=phoneNumbersWithoutSpaces(phone);
            firstDigitCases(phoneNumbersInList,false);
        }
    }


    //Create an arrayList of Integers with the numbers of phoneNumber
    public static ArrayList<Integer> phoneNumbersWithoutSpaces(String phoneNumbers){
        ArrayList<Integer> phone=new ArrayList<Integer>();
        String[] arrayOfNumberDigitGroups = phoneNumbers.split("\\s+");

        for (String digit:arrayOfNumberDigitGroups
             ) {
            phone.add(Integer.parseInt(digit));
        }
        return phone;
    }

    //Create an arrayList of Strings with the numbers of phoneNumber
    public static ArrayList<String> sequenseWithoutSpaces(String phoneNumbers){
        ArrayList<String> phone=new ArrayList<String>();
        String[] arrayOfNumberDigitGroups = phoneNumbers.split("\\s+");

        for (String digit:arrayOfNumberDigitGroups
        ) {
            phone.add(digit);
        }
        return phone;
    }
}
