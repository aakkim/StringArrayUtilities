package com.zipcodewilmington;
import java.util.ArrayList;
import java.util.Arrays;

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
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(int i=0; i< array.length; i++) {
            if(array[i]==value);
            return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        for(int i=0; i<(array.length)/2; i++) {
            String temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;

        }
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for(int i=0; i<array.length/2; i++) {
            if(array[i]==array[array.length-1-i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String joinedArray = String.join(" ", array).toLowerCase();
        boolean[] keepTrack = new boolean[26]; // default values in boolean array is false
        int index = 0; // index of the difference between panagram.charAt(i) character and 'a' in ascii code (numeric value of letter)
        boolean panagram = true; // return true of false if string is a panagram
        for(int i=0; i<joinedArray.length(); i++) {
            if(joinedArray.charAt(i)>='a' && joinedArray.charAt(i)<='z'){
                index = joinedArray.charAt(i) - 'a'; //gets the index between charAt(i) and numeric value of 'a'/ the difference will be 0-25
            }
            keepTrack[index] = true; // mark as true if the character at that index exists in our string
        }
        for(int i=0; i<keepTrack.length; i++) { //with boolean panagram, we check to see if keepTrack array contains false
            if(keepTrack[i]==false) {
                panagram = false;
            }
        }

        return panagram;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurrences = 0;
            for(int i=0; i<array.length; i++) {
                if(array[i]==value) {
                    occurrences += 1;
                }
            }
        return occurrences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] excludeValue = new String[array.length-1]; // an element containing 'value' is removed from new array
        int index = 0;
        for(int i=0; i<array.length; i++) {
            if(!(array[i]==valueToRemove)) {
                excludeValue[index] = array[i];
                index ++;
            }
        }

        return excludeValue;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array)); //convert array to ArrayList to alter length
        int i = 0;
        int j = 1;

        while(i<list.size()-1) {
            if(list.get(i)==list.get(j)) {
                list.remove(i); // if element at index i & j are equal, remove element at index i
            } else { // if elements at index i & j are not the same, increment by one for each index to iterate through array
                i++;
                j++;
            }
        }
        String[] removeDup = new String[list.size()]; // Create new array to store results
        removeDup = list.toArray(removeDup); //Convert ArrayList to the new array

        return removeDup;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> list = new ArrayList<>(); //Create an ArrayList to add concatenated duplicates, no size given
        int i=0; //To iterate through array
        int j=0; //To add concatenated elements to ArrayList
        String total = ""; //To add the duplicates into one element

        total += array[i];
        while(i<array.length-1) {
            if(array[i]==array[i+1]) {
                total += array[i+1];
                if((i+1)==array.length-1) {  //If the last char was a duplicate and was added to total, place the value into the next index of ArrayList
                    list.add(j, total);
                }
            } else {
                list.add(j, total);
                total = array[i+1];
                j++; //Go to next index of ArrayList
                if((i+1)==array.length-1) {
                    list.add(j, total); //If the last char was not a duplicate, place the value into the next index of ArrayList
                }
            }
            i++; //Iterate to next index of array
        }
        String[] occurrencesJoined = new String[list.size()]; //Create new String array to convert ArrayList to Array
        occurrencesJoined = list.toArray(occurrencesJoined); // Convert ArrayList to Array

        System.out.println(Arrays.toString(array)); //Display String array object
        System.out.println(Arrays.toString(occurrencesJoined)); //Display String array object

        return occurrencesJoined;
    }


}
