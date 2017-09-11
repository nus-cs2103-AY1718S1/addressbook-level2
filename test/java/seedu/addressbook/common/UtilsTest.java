package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void isAnyNull() {
        // no arguments
        assertFalse(Utils.isAnyNull());
        
        // non-empty arguments with generic Java Object()s
        assertFalse(Utils.isAnyNull(new Object()));
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull(new Object(), new Object(), new Object()));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull("Hello", new Integer(3)));
        assertFalse(Utils.isAnyNull(new ArrayList<String>(), new ArrayList<>(), new Long(-1)));
        
        // non-empty list with null Object()s, and other Java objects
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, new Integer(1)));
        assertTrue(Utils.isAnyNull(null, new Random()));
        assertTrue(Utils.isAnyNull(new Object(), null, new Object()));
        
        // non-empty arguments with literals
        assertTrue(Utils.isAnyNull(null, 1, 2, 3));
        assertTrue(Utils.isAnyNull(1, 2, 3, null));
        assertFalse(Utils.isAnyNull(1, 2, 3));
        assertTrue(Utils.isAnyNull(null, null, null, null));
        
        // another way of catching isFirstAndOnlyNull()
        try {
            Utils.isAnyNull(null);
            fail("NullPointerException failed to call.");
        } catch (NullPointerException ex) {
            // nothing need be done here.
        }
    }

    /**
     * Tests the case for the method isAnyNull when the first and only argument is the Java literal 'null'
     * 
     * Note: DO NOT implement any other cases here.
     * Only asserts that the method threw NullPointerException, not any particular line of code.
     */
    @Test(expected = NullPointerException.class)
    public void isFirstAndOnlyNull() {
        Utils.isAnyNull(null);
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
