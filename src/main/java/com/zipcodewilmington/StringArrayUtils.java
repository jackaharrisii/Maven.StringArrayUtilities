package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
//        System.out.print(value);
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
/*        this was working for the reverse string, but was breaking the palindrome test
            for (int i  = 0; i < array.length/2; i++){
            String temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-i-1] = temp;
        }
*/
//changed to this method instead to make it work for the palindrome test
        String[] result = new String[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[array.length - 1 - i] = array[i];
        }
        System.out.print(array);
        //why does print(array) give such a weird output? that's definitely not the array I'm trying to print....
//        return array;
        return result;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String[] oldArray = array;
        String[] newArray = reverse(array);

        System.out.print(array);
//        System.out.print(newArray);
        if (Arrays.equals(oldArray, newArray)) {
            return true;
        }

        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] pangram = new boolean[26];    //create a boolean array of true or false for each character in the alphabet
        System.out.println(Arrays.toString(pangram));                                        //testing to verify java created an array of false values
        String strArr = Arrays.toString(array); //create a single string from the array to search
        int pIndex = 0;                         //create an index number to use inside the boolean array to note which letter we're talking about

        for (int i = 0; i < strArr.length(); i++) {                       //interate over each character in the string
            if ('A' <= strArr.charAt(i) && strArr.charAt(i) <= 'Z')      //tests for capital letters
                pIndex = strArr.charAt(i) - 'A';                         //sets the index to the slot for the letter found
            else if ('a' <= strArr.charAt(i) && strArr.charAt(i) <= 'z')  //tests for lowercase letters
                pIndex = strArr.charAt(i) - 'a';                         //sets the index to the slot for the letter found
            pangram[pIndex] = true;                                      //sets the marker for the letter found to true
        }
        System.out.println(Arrays.toString(pangram));        //test to verify that pangram properly checked each letter
        for (int i = 0; i <= 25; i++)             //checks each slot of the pangram array
            if (pangram[i] == false)         //checks to see if any slot in the array is false
                return false;                     //for the first false found in the array, return false and end isPangramic
        return true;                              //if it made it through the entire pangram array without finding any false, return true and end isPangramic
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int output = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                output++;
            }
        }
        return output;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] output = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                output[count] = array[i];
                count++;
            }
        }
        return output;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                list.add(array[i]);
            }
        }
        list.add(array[array.length - 1]);
        String output[] = new String[list.size()];
        for (int j = 0; j < list.size(); j++) {
            output[j] = list.get(j);
        }
        return output;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

//  simpler logic
//      1. create a holder string
//      2. add the first item to the string
//      3. create a for loop
//          - if [i] matches [i-1], add to string
//          - if [i] != [i-1], add a space and then add to string
//      4. split the string into an array, using the spaces to denote new items in the array

        String temp;
        temp = array[0];
        String[] output;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                temp += array[i];
            } else {
                temp += " " + array[i];
            }
        }
        output = temp.split(" ");
        return output;
    }
}