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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull() throws Exception {

        // no null object
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull(1, 2, 3));
        assertFalse(Utils.isAnyNull("a"));
        assertFalse(Utils.isAnyNull("a", "ab", "abc"));
        assertFalse(Utils.isAnyNull(1, 2, "a", "b", 1.0, 2.0));

        // one or more null object
        final String nullString = null;
        assertTrue(Utils.isAnyNull(nullString));
        assertTrue(Utils.isAnyNull("a", "b", null));
        assertTrue(Utils.isAnyNull(1, 2, 3, "a", "b", 1.0, 2.0, 3.0, null));
        assertTrue(Utils.isAnyNull(nullString, null));
        assertTrue(Utils.isAnyNull("a", "b", null, null));
        assertTrue(Utils.isAnyNull(1, 2, 3, "a", "b", 1.0, 2.0, 3.0, null, null));
    }
}
