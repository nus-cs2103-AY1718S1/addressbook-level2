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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void elementsContainNull() throws Exception {
        // empty list
        assertNotNull();

        // only one non-null object
        assertNotNull(1);
        assertNotNull("");
        assertNotNull("abc");

        // one null object
        assertNull((Object) null);

        // multiple non-null objects
        assertNotNull("abc", "abc");
        assertNotNull("abc", "", "abc", "ABC");
        assertNotNull("", "abc", "a", "abc");
        assertNotNull(1, new Integer(1));

        // one null object with some non-null objects
        assertNull(null, 1, new Integer(1));
        assertNull(null, 1, "");
        assertNull("abc", 1, null);

        //multiple null objects
        assertNull(null, null);
        assertNull(null, "a", "b", null);

    }

    private void assertNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}
