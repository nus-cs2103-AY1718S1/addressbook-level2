package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


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
    
    @Test
    public void elementsHaveNull() throws Exception {
        // empty list
        assertFalse(Utils.isAnyNull());
        
        // test fails when only 1 null value is provided
        // should modify isAnyNull method?
        
        // some arguments with null values
        assertTrue(Utils.isAnyNull(1, null));
        assertTrue(Utils.isAnyNull(null, "one"));
        assertTrue(Utils.isAnyNull(null, null, null));
        assertTrue(Utils.isAnyNull(1, 2, 3, "four", null));

        // some arguments without null values
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull(1, "one"));
        assertFalse(Utils.isAnyNull("", "one"));
        assertFalse(Utils.isAnyNull("one", 1, ""));
        assertFalse(Utils.isAnyNull(1, 2, 3, "four", ""));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

}
