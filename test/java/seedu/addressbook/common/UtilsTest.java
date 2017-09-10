package seedu.addressbook.common;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

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
        assertNoNull();

        // single null
        assertHasNull((Object) null);

        // single non-null
        assertNoNull(1);
        assertNoNull("");
        assertNoNull("abc");

        // null present
        assertHasNull("abc", null);
        assertHasNull(1, 2, null);
        assertHasNull(1, 2, "abc",null, "");

        // null absent
        assertNoNull("abc", "", 1, 2);
        assertNoNull("abc", 1);
        assertNoNull("abc", "", 2);
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

    private void assertNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }
}
