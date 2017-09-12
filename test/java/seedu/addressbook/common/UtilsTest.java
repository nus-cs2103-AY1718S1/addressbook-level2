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
        // empty list
        assertDontHaveNull();

        // no nulls
        assertDontHaveNull(1);
        assertDontHaveNull(1, 2, 3, 4, 5);
        assertDontHaveNull("abc");
        assertDontHaveNull("abc", "def", "ghi");

        // have nulls
        assertHaveNull(null, null);
        assertHaveNull(1, null);
        assertHaveNull(1, null, 2, 3, 4);
        assertHaveNull(1, null, 2, null, null);
        assertHaveNull(null, null, null, null, null);

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertHaveNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertDontHaveNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }
}
