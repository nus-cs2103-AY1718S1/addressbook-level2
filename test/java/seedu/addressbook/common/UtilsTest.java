package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception{
        //has at least 1 null obj
        assertAreNull((Object)null);
        assertAreNull((Object) null, null, null);
        assertAreNull((Object) null, 1, 2, 3);
        //has no null obj
        assertAreNotNull(1);
        assertAreNotNull(1,2,3);
    }
    private void assertAreNull(Object... item) {
        assertTrue(Utils.isAnyNull(item));
    }
    private void assertAreNotNull(Object... item) {
        assertFalse(Utils.isAnyNull(item));
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
}
