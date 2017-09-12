package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
        Object null_obj = null;

        // single null object
        assertAreNull(null_obj);


        // list with multiple objects, with null
        assertAreNull(null, "b", "c");
        assertAreNull("ab", null, "cd");
        assertAreNull("", "abc", null);
        assertAreNull(null, 2, 3);
        assertAreNull(null, new Integer(2), 3);

        // list of nulls
        assertAreNull(null, null, null);

        // empty list
        assertNotNull();

        // one object
        assertNotNull("abc");
        assertNotNull(1);
        assertNotNull("");

        // list with multiple objects, no null
        assertNotNull("a", "b", "c");
        assertNotNull("ab", "bc", "cd");
        assertNotNull("", "abc", "def");
        assertNotNull(1, 2, 3);
    }

      /*
     * Utility methods ====================================================================================
     */



    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertAreNull(Object... objects) {
            assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNotNull(Object... objects) {
            assertFalse(Utils.isAnyNull(objects));
    }

}
