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
public class DynamicArrayListRandomTests {

    public DynamicArrayListRandomTests() {
    }



    /**
     * Test of clear method, performed on a populated list.
     */
    @Test
    public void testClear() {
        System.out.println("Testing clear with a populated list");
        DynamicArrayList instance = new DynamicArrayList();
        instance.add(null);
        instance.add("Hi");
        instance.add("hi");
        instance.add(null);
        instance.add("hi");
        instance.add("hello");
        instance.add(null);
        instance.add("Hi");

        int expResult = 0;
        instance.clear();
        int result = instance.size();
        assertEquals(expResult, result);

        // Confirm it can still be added to
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(0);
        assertEquals(text, textReturned);
    }

    /**
     * Test of clear method, performed on an empty list.
     */
    @Test
    public void testClear_EmptyList() {
        System.out.println("Testing clear with an empty list");
        DynamicArrayList instance = new DynamicArrayList();
        int expResult = 0;
        instance.clear();
        int result = instance.size();
        assertEquals(expResult, result);

        // Confirm it can still be added to
        String text  = "Aloha";
        instance.add(text);
        String textReturned = instance.get(0);
        assertEquals(text, textReturned);
    }

}