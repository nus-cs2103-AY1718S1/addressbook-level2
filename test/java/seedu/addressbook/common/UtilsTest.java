package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {

        // No null objects
        assertIsAllNotNull();
        assertIsAllNotNull(1);
        assertIsAllNotNull("");
        assertIsAllNotNull("abc");
        assertIsAllNotNull("abc", "abc");
        assertIsAllNotNull("abc", "", "abc", "ABC");
        assertIsAllNotNull("", "abc", "a", "abc");
        assertIsAllNotNull("abc", "ab", "a");
        assertIsAllNotNull(1, 2);

        // Null objects
        assertIsAnyNull(1, null);
        assertIsAnyNull(null, 1);
        assertIsAnyNull(null, null);
        assertIsAnyNull(null, "a", "b", null);
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

    private void assertIsAnyNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertIsAllNotNull(Object... objects) { assertFalse(Utils.isAnyNull(Arrays.asList(objects))); }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
