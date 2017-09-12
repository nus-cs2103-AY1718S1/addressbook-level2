package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
    public void isAnyNull() {

        //empty list
        assertIsNotAnyNull();

        //only with null
        assertIsAnyNull((Object) null);

        //some objects with null
        assertIsAnyNull("asdf", "sdfg", null);
        assertIsAnyNull(new Integer(1), null, new Integer(4));
        assertIsAnyNull(null, null, null, "test");

        //without null
        assertIsNotAnyNull("asdd", "test", "psfd");
        assertIsNotAnyNull(new Integer(3), new Integer(0), new Integer(45));
        assertIsNotAnyNull(Arrays.asList(1,2,3));
        assertIsNotAnyNull("asdf", new Integer(3), "testing");

    }

    private void assertIsAnyNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertIsNotAnyNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

}
