package seedu.addressbook.common;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {
    @Test
    public void isAnyNull() throws Exception {
        // empty list
        assertFalse(Utils.isAnyNull());

        // one object
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull(1.0f));
        assertFalse(Utils.isAnyNull("123"));
        assertFalse(Utils.isAnyNull(true));

        // falsy objects
        assertFalse(Utils.isAnyNull(0));
        assertFalse(Utils.isAnyNull(0.0f));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull(false));

        // some objects
        assertFalse(Utils.isAnyNull(0, 1, 2));
        assertFalse(Utils.isAnyNull(1, "123", true));

        // nulls
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(1, null));
        assertTrue(Utils.isAnyNull(null, 1));
        assertTrue(Utils.isAnyNull(null, null));
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
