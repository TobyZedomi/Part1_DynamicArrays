package utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author michelle
 */
public class DynamicArrayList {

    private String [] store;

    private int num_elements;
    private int capacity = 10;
    private int expansionFactor = 10;

/// default constructor

    /**
     * Make the length of the array store 10 as capacity is assigned to 10
     */
    public DynamicArrayList(){

        /// capacity is set to 10
        capacity = 10;

        /// length of array is set to what the capacity was assigned to
        store = new String[capacity];
    }

    /// added constructor

    /**
     * Expand the array when space has ran out
     * @param expansionFactor is the amount of how much we should expand the array when space is needed
     */

    public DynamicArrayList(int expansionFactor) {


        /// id the expansion factor is less than 0 or is equal to 0
        if (expansionFactor < 0 || expansionFactor == 0){

            /// it will print an Out Of Bounds with a throw
            throw new IllegalArgumentException("Out of bounds");
        }

        //// expansion factor is set to whatever the user assigned expansion factor to be
        this.expansionFactor = expansionFactor;
        /// is the extra space in the array being added with expansion factor
        store = new String[expansionFactor];
    }


    /**
     * Get how much elements are in the array
     * @return the amount of elements in the array
     */
    public int size(){

        //// returns the amount of elements in the array
        return num_elements;
    }


    /**
     * Get the value in the array at a certain position
     * @param pos is the position that is being searched
     * @return the value of the array in that position
     */
    public String get(int pos){

        /// if position is equal or greater that length of array OR position is less than 0
        if (pos >= num_elements || pos < 0)

            /// it will output Invalid position supplied using a throw
            throw new IndexOutOfBoundsException("Invalid position supplied");

        /// return the value in the array at that position entered by the user
       return store[pos];
    }


    /**
     * Get the first position of a value in the array
     * @param value is the value that uis being searched
     * @return the position that the value entered is in the array
     */
    public int indexOf(String value){

        //// Loop through the entire array
        for (int i = 0; i < num_elements;i++){

            /// if the value entered is equal to a value in the array
            if (store[i].equalsIgnoreCase(value)){

                // return the position of that value
                return i;
            }
        }

        /// return -1 if the value entered is not in the array
        return -1;
    }

    /**
     * Add a value into the array
     * @param value is the value that is being added into the array
     * @return true if the value is added to the array ad false if it isnt added to the arrray
     */
    public boolean add(String value){

        /// boolean variable is set to false
        boolean found = false;

        /// if the length of the array that is being tracked is equal to the array length of store
        if (num_elements == store.length){

            /// create a new String array and have it be the length of the store array
            // with the expansion factor added as the array will need to increase in s
            // ize as there is no space in the array for the new value being added
            String [] duplicateData = new String[store.length+expansionFactor];
            /// use the array copy in built method to copy all data from the original
            // store array and put into the new array
            System.arraycopy(store,0,duplicateData,0,num_elements);

            /// set the store array to the new array duplicateData
            store = duplicateData;

/// found will be set to true
            found = true;

        }

        /// the store array length will then include the value that is to be added
        store[num_elements] = value;
        /// tracker to track the added value bing added into the array
        num_elements++;


        /// return true if added and false if it wasnt added
        return found;

    }

    /**
     * Add a value into the array at a certain position
     * @param value is the value that is being searched
     * @param pos is the position that is being searched
     */
    public void add (String value, int pos){

        //// if the position is less than 0 OR position is greater than the array length
if (pos < 0 || pos > num_elements){

    /// it will output Out Of Bounds using a throw
    throw new IndexOutOfBoundsException("Out of bounds ");
}

/// create a variable called prev and set it to the value that is being added
String prev = value;


/// loop from the position entered tot the end of the array
for (int i = pos; i < num_elements;i++){

    /// Create a variable called temp and set the value of the store array to it
    String temp = store[i];
    // set the value of the store array to the value enetered
    store[i] = prev;
    /// set the  value of the store array into the temp variable.
    // This is shifting the data to add the new value
    prev = temp;

}

    }


    /**
     * Remove the first value in the array after a certain position in the array
     * @param value is the value that is being searched
     * @param pos is the position that is being searched
     * @return true if the value was removed and return false if the value wasn't removed
     */
    public boolean remove(String value, int pos){

        /// create a boolean variable and set it to false
        boolean found = false;

        /// if position is less than 0 and position is grater than or equal to the array length
        if (pos < 0 || pos >= num_elements){
            /// it will output Out Of Bounds using a throw
            throw new IndexOutOfBoundsException("Out of bounds ");
        }

        /// if the value entered is null
        if (value == null){
            // it will output Out Of Bounds using a throw
            throw new IllegalArgumentException("Out of bounds ");
        }


        /// loop from the position entered all the way to the end of the array, -1 is used to make sure it doesn't go over the array length
        for (int i = pos; i < num_elements -1;i++){

            /// if the value entered is equal to an element in the store array
            if (value.equalsIgnoreCase(store[i])){

                /// set that value and put it at the end of the array.+1 is used to go up in the array
               store[i] = store[i+1];
               /// set it to null and minus the array length by -1
                store[num_elements -1 ] = null;
                /// minus array length by 1 using tracker and track it
                num_elements--;

                // set found to true if removed
                found = true;
            }

        }
        /// return true if removed and false if not removed
        return found;
    }

    /**
     * Set the array length back to 0
     */
    public void clear(){

        /// making sure there are no elements in the array and clears it all
        num_elements = 0;
    }

}
