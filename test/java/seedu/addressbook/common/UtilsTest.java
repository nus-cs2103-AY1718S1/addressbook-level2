package seedu.addressbook.common;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

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
        // empty list
        assertNotNull();

        // only one object
        assertNull((Object) null);
        assertNotNull(1);
        assertNotNull("");
        assertNotNull("abc");

        // all objects null
        assertNull(null, null, null);
        assertNull(null, null);

        // no objects null
        assertNotNull(1, 2);
        assertNotNull("abc", "def");

        // some objects null
        assertNull("abc", null);
        assertNull("abc", null, "abc", null);
        assertNull(null, 1, new Integer(1));
        assertNull(null, "a", "b", null);
    }

    private void assertNull(Object... objects) {
        assertTrue(Utils.isAnyNull((objects)));
    }

    private void assertNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull((objects)));
    }
}
