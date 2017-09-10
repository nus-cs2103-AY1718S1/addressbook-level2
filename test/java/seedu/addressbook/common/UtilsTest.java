package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

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
    public void elementsContainNull() throws Exception {
        // empty list
        assertNoneNull();

        // only one null object
        assertAnyNull((Object) null);

        // all objects have no null
        assertNoneNull(1);
        assertNoneNull("");
        assertNoneNull("abc");
        assertNoneNull("abc", "ab", "a");
        assertNoneNull(1, 2);

        // some identical objects
        assertNoneNull("abc", "abc");
        assertNoneNull("abc", "", "abc", "ABC");
        assertNoneNull("", "abc", "a", "abc");
        assertNoneNull(1, new Integer(1));

        // objects including null
        assertAnyNull(null, 1, new Integer(1));
        assertAnyNull(null, null);
        assertAnyNull(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertAnyNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNoneNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}
