package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void isAnyNull() {
        // empty list
        assertHasNoNull();

        // Any non-empty list
        assertHasNoNull(1);
        assertHasNoNull("a", "b");

        // non empty list with just one null at the beginning
        assertHasNull(null, "abc");
        assertHasNull((null), "", new Object());
        assertHasNull(null, new Object(), new Object());

        // non empty list with nulls in the middle
        assertHasNull("abc", null, null, "test");
        assertHasNull("", null, "111");

        // non empty list with one null as the last element
        assertHasNull("", "abc", null);
        assertHasNull("aaa", "123", null);


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

    private void assertHasNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertHasNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}