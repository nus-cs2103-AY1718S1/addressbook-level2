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
    public void isAnyNull() throws Exception {
        // no null objects
        assertIsNotNull();
        assertIsNotNull(1);
        assertIsNotNull("");
        assertIsNotNull("abc");
        assertIsNotNull("abc", "ab", "a");
        assertIsNotNull(1, 2);
        assertIsNotNull("abc", "abc");
        assertIsNotNull("abc", "", "abc", "ABC");
        assertIsNotNull("", "abc", "a", "abc");

        // null objects
        assertIsNull(null, 1, 1);
        assertIsNull(null, null);
        assertIsNull(null, "a", "b", null);
    }


    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertIsNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertIsNotNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }


}
