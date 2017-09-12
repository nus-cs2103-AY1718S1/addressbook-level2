package seedu.addressbook.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.addressbook.common.Utils.isAnyNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    /**
     * Asserts that null objects are properly captured by isAnyNull.
     */
    public  void assertIsAnyNull(){

        Object nullObject = null;
        assertFalse(isAnyNull()) ;
        assertTrue(isAnyNull(nullObject));
        assertFalse(isAnyNull(" ", " ", 0, false));
        assertFalse(isAnyNull("Item1", true, 123, 33.4, 'a'));
        assertTrue(isAnyNull("Item1", null, 123, 33.4));
        assertTrue(isAnyNull(null, null, null, null));
    }
}
