package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull() throws Exception {
        // empty list
        assertIsNotNull();

        // only one object
        assertIsNull((Object) null);
        assertIsNotNull(1);
        assertIsNotNull("");
        assertIsNotNull("abc");

        // all objects are null
        assertIsNull(null, null);
        assertIsNull(null, null, null);

        // all objects are not null
        assertIsNotNull("abc", "ab", "a");
        assertIsNotNull(1, 2);

        // some objects are null
        assertIsNull("abc", null);
        assertIsNull("abc", null, "abc", null);
        assertIsNull(null, "a", "b");
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

    private void assertIsNull(Object... items) {
        assertTrue(Utils.isAnyNull(items));
    }

    private void assertIsNotNull(Object... items) {
        assertFalse(Utils.isAnyNull(items));
    }
}
