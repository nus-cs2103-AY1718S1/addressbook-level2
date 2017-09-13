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
        //empty list
        assertWithoutNull();

        //with nulls
        assertWithNull(null);
        assertWithNull("abc", null);
        assertWithNull(1, 2, null, 3);
        assertWithNull(null, null, null, null);

        //without null
        assertWithoutNull("abc");
        assertWithoutNull(1, 2, 3, 4);
        assertWithoutNull("abc", "def", 123);
        assertWithoutNull(123, "0", "abc", 456);

    }

    public void assertWithNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    public void assertWithoutNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
