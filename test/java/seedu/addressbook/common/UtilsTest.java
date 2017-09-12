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

        //no null

        assertNotNull(1, 2, 3);
        assertNotNull("abs", "nbv");
        assertNotNull(1, "abc");

        //only one null

        assertAreNull(null, "abc");
        assertAreNull(1, null);
        assertAreNull("abc", 1, null);

        //multiple null

        assertAreNull(null, null, 1);
        assertAreNull(null, "ab", null);
        assertAreNull(null, null, null);



    }
    private void assertAreNull (Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertNotNull (Object... objects) {assertFalse(Utils.isAnyNull(objects));}

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
