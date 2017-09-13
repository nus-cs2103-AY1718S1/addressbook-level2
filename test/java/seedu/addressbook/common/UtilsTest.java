package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void elementsAreUnique() throws Exception {
        // Empty list
        assertAreUnique();

        // Only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // All objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // Some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);

        // Some objects are null
        assertNull((Object) null);
        assertNull("abc", "def", "ghk", null);
        assertNull(null, 1, new Integer(1));
        assertNull(null, null);
        assertNull(null, "a", "b", null);

        // All objects are not null
        assertNotNull("abc");
        assertNotNull("abc", "def", "ghk", "ABC");
        assertNotNull(2, 1, new Integer(1));
        assertNotNull(123, 456);
        assertNotNull("?", "a", "b", "okay");

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}
