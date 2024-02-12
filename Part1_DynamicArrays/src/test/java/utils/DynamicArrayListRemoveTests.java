/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author michelle
 */
public class DynamicArrayListRemoveTests {

    public DynamicArrayListRemoveTests() {
    }



    /**
     * Test of remove starting at position method, where the only instance appears AFTER the position specified.
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_OneInstanceInArray_AppearingAfterPosition() {
        System.out.println("Testing the remove from position method to remove something from a valid position, where " +
                "only one instance exists");
        String text = "alpha";
        String [] data = {"Entry Zero", "Entry One", "alpha", "beta"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }

        boolean expResult = true;
        boolean result = instance.remove(text, 1);
        assertEquals(expResult, result);
        int expSize = data.length - 1;
        assertEquals(expSize, instance.size());

        String [] updatedData = {"Entry Zero", "Entry One", "beta"};
        for(int i = 0; i < instance.size(); i++){
            assertEquals(updatedData[i], instance.get(i));
        }
    }

    /**
     * Test of remove starting at position method, where the only instance appears BEFORE the position specified.
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_OneInstanceInArray_AppearingBeforePosition() {
        System.out.println("Testing the remove from position method to remove something from a valid position, where " +
                "only one instance exists (but it appears before the specified position)");
        String text = "alpha";
        String [] data = {"alpha", "Entry Zero", "Entry One", "beta"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }

        boolean expResult = false;
        boolean result = instance.remove(text, 1);
        assertEquals(expResult, result);
        int expSize = data.length;
        assertEquals(expSize, instance.size());

        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }

    /**
     * Test of remove starting at position method, where all instances appear BEFORE the position specified.
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_MultipleInstancesInArray_AppearingBeforePosition() {
        System.out.println("Testing the remove from position method to remove something from a valid position, where " +
                "only one instance exists (but it appears before the specified position)");
        String text = "alpha";
        String [] data = {"alpha", "alpha", "alpha", "Entry Zero", "Entry One", "beta"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }

        boolean expResult = false;
        boolean result = instance.remove(text, 4);
        assertEquals(expResult, result);
        int expSize = data.length;
        assertEquals(expSize, instance.size());

        for(int i = 0; i < instance.size(); i++){
            assertEquals(data[i], instance.get(i));
        }
    }

    /**
     * Test of remove starting at position method, where all instances appear AFTER the position specified.
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_MultipleInstancesInArray_AppearingAfterPosition() {
        System.out.println("Testing the remove from position method to remove something from a valid position, where " +
                "only multiple instances exists (several after position, one before)");
        String text = "alpha";
        String [] data = {"Entry Zero", "alpha", "beta", "alpha", "alpha", "alpha"};
        DynamicArrayList instance = new DynamicArrayList();
        for(String s: data) {
            instance.add(s);
        }

        boolean expResult = true;
        boolean result = instance.remove(text, 3);
        assertEquals(expResult, result);

        int expSize = data.length - 1;
        assertEquals(expSize, instance.size());

        String [] updatedData = {"Entry Zero", "alpha", "beta", "alpha", "alpha"};
        for(int i = 0; i < instance.size(); i++){
            assertEquals(updatedData[i], instance.get(i));
        }
    }


    /**
     * Test of remove starting at position method, where lower bound is broken.
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_BreakingLowerBound() {
        System.out.println("Testing the remove from position method to remove something with " +
                "invalid starting position (less than 0).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove("text", -1);
        });
    }

    /**
     * Test of remove starting at position method, where upper bound is broken (greater than size).
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_BreakingUpperBound_GreaterThanSize() {
        System.out.println("Testing the remove from position method to remove something with " +
                "invalid starting position (greater than size).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove("text", 4);
        });
    }

    /**
     * Test of remove starting at position method, where upper bound is broken (equal to size).
     */
    @Test
    public void testRemoveStartingFromPos_ValidPosition_BreakingUpperBound_EqualToSize() {
        System.out.println("Testing the remove from position method to remove something with " +
                "invalid starting position (equal to size).");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            instance.remove("text", 3);
        });
    }

    /**
     * Test of remove starting at position method, where value to be deleted is null.
     */
    @Test
    public void testRemoveStartingFromPos_NullValue() {
        System.out.println("Testing the remove from position method to remove something where value to be removed is " +
                "null");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add("Entry Zero");
        instance.add("Entry One");
        instance.add("Entry Two");

        assertThrows(IllegalArgumentException.class, () -> {
            instance.remove(null, 1);
        });
    }



}