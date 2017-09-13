package seedu.addressbook.common;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        //empty list
        assertNotNull();

        // only one object
        assertAnyNull((Object) null);

        // all objects null
        assertAnyNull(null, null, null);

        // all objects not null
        assertNotNull("a", "b");

        // some not null
        assertAnyNull("abc", null);
        assertAnyNull("abc", null, "abc", "ABC");
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
    private void assertAnyNull(Object... objects) {assertTrue(Utils.isAnyNull(objects));}

    private void assertNotNull(Object... objects) {assertFalse(Utils.isAnyNull(objects));}

    private void assertAreUnique(Object... objects) {assertTrue(Utils.elementsAreUnique(Arrays.asList(objects))); }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
