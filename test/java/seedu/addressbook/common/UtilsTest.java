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
    public void isAnyNull() throws Exception{
        // Empty
        assertNoNull();

        // No null object
        assertNoNull(1);
        assertNoNull(1, 2, 3, 4);
        assertNoNull("abc");
        assertNoNull("abc", 1, 2, "def");

        // Contains null object
        assertHasNull(1, null);
        assertHasNull(1, null, 2, 3, 4);
        assertHasNull(1, null, 2, null, null);
        assertHasNull("abc",null, null, null, null);
    }
    private void assertHasNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertNoNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {

        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
