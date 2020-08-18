package utils;

import java.util.ArrayList;
import java.util.Scanner;


import static utils.Interpretations.interpretations;
import static utils.Validations.allValidations;


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
        }while (!allValidations(phoneNumbersWithoutSpaces,phoneNumbersInList));
        return phone;
    }


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
            interpretations(phoneNumbersInList,true);


        }
        else{

            ArrayList <Integer> phoneNumbersInList=phoneNumbersWithoutSpaces(phone);
            interpretations(phoneNumbersInList,false);
        }
    }



    public static ArrayList<Integer> phoneNumbersWithoutSpaces(String phoneNumbers){
        ArrayList<Integer> phone=new ArrayList<Integer>();
        String[] arrayOfNumberDigitGroups = phoneNumbers.split("\\s+");

        for (String digit:arrayOfNumberDigitGroups
             ) {
            phone.add(Integer.parseInt(digit));
        }
        return phone;
    }

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
