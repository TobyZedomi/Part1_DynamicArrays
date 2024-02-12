package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);


        /// Create an arrayList
        DynamicArrayList list = new DynamicArrayList();

        //// int variable to ask the user how many elements they want to add
        int ask;

        /// asking the user how many elements they want to add to the array
        System.out.println("How many elements do you want in the array: ");
        ask = keyboard.nextInt();

        /// string variable to ask user what value they want to add to the arrayList
        String value;

        /// Loop through the answer the user gives for much elements they want in the arrayList
        for (int i = 0; i < ask;i++){

            /// ask user what values theywant added to the arrayList
            System.out.println("Enter items you want: ");
            value = keyboard.next();

            //// add those values to the arrayList using add method
            list.add(value);
        }

        /// loop through the entire arrayList
        for (int i =0; i < list.size();i++){

            // output all the values in the arrayList
            System.out.println(list.get(i));
        }


        /// adding a value at a specific position

        /// string variable asking user if they want to add an element to arrayList
        String add;

        /// type yes to add ne element to arrayList or No
        System.out.println("Type yes to add an item at a specific position OR type No if you dont want to: ");
        add = keyboard.next();

        /// if the user types yes(case doesn't matter)
        if (add.equalsIgnoreCase("yes")){

            // variable for what position the array the user wants to add the new value to the arrayList
            int pos;

            /// variable for the value they will add to the arrayList
            String value2;

            /// asking what item the user wants to add
            System.out.println("Add item:");
            value2 = keyboard.next();

            // asking what position in the array they want the ne value to be added
            System.out.println("Position you want item to be added: ");
            pos = keyboard.nextInt();

            /// add the new value to the arrayList
            list.add(value2);
            /// add the new value to the arrayList at the specified position the user asked for
            list.add(value2,pos);

            /// loop through the entire arrayList
            for (int i = 0; i < list.size();i++){
                /// output all values of the arrayList
                System.out.println(list.get(i));
            }

        }
        /// if user types no(case doesn't matter)
        else if (add.equalsIgnoreCase("no")){
            //// output you dont want to add an item
            System.out.println("You don't want to add an item ");
        }



        /// variale for if user wants to remove item from arrayList OR not
        String remove;

        /// asking user to type yes if they want to remove an item from arrayList or no if they don't
        System.out.println("Type yes to remove item OR type no if you don't want to remove item: ");
        remove = keyboard.next();

        /// if user enters yes(case doesn't matter)
        if (remove.equalsIgnoreCase("yes")){

            /// variable for the value the user wants to remove
            String value3;

            /// ask the user what vvalue they want to remove in the arrayLiust
            System.out.println("Type item you want to remove: ");
            value3 = keyboard.next();

            /// ask the user from what position in the array they
            // want to start removing said value in the arrayList
            int position;
            System.out.println("Type position: ");
            position = keyboard.nextInt();

            /// use remove method to remove the first instance of the value in the array after a certain position
            list.remove(value3,position);


            /// loop through the entire arrayList
            for (int i = 0; i < list.size();i++){
                /// output all values in the array
                System.out.println(list.get(i));
            }

        }
        /// if user types no(case doesn't matter)
        else if (remove.equalsIgnoreCase("no")){
            /// it will output you dont want to remove an item
            System.out.println("You don't want to remove item");
        }

        /// variable to ask user if they want to clear the arrayList and set it back to 0
        String clear;

        ///ask use rot type yes to clear the arrayList and no if they want to
        System.out.println("Type yes if  you want to clear the array OR type no if don't: ");
        clear = keyboard.next();

        /// if user types yes(case doesn't matter)
        if (clear.equalsIgnoreCase("yes")){
            /// it will clear the arrayList and set back to using clear method
            list.clear();
        }
        /// if user types no it will output you don't want to clear data in the arrayList
        else if (clear.equalsIgnoreCase("no")){
            System.out.println("You don't want to clear data");
        }


        //checking if data got cleared ot not by outputting the values in the arrayList

        // loop through the entire arrayList
        for (int i = 0; i < list.size();i++){
            /// output elements in the arrayList
            System.out.println(list.get(i));
        }


    }
}
