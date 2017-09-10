package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void elementsAreUnique() throws Exception {
        assertAreUnique("abc","ab","abd");
    }

    @Test
    public void elementsNotUnique() throws Exception{
        assertNotUnique("ab","ab",null);
    }

    @Test
    public void anyNullElements(){
        // empty list
        assertFalse(Utils.isAnyNull());

        // only one object
        assertTrue(Utils.isAnyNull((Object) null));
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull("abc"));

        // all objects unique
        assertFalse(Utils.isAnyNull("abc", "ab", "a"));
        assertFalse(Utils.isAnyNull(1, 2));

        // some identical objects
        assertFalse(Utils.isAnyNull("abc", "abc"));
        assertFalse(Utils.isAnyNull("abc", "", "abc", "ABC"));
        assertFalse(Utils.isAnyNull("", "abc", "a", "abc"));
        assertFalse(Utils.isAnyNull(1, new Integer(1)));
        assertTrue(Utils.isAnyNull(null, 1, new Integer(1)));
        assertTrue(Utils.isAnyNull("abc", null, "ab"));
        assertTrue(Utils.isAnyNull("cda", "a", "b", null));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
