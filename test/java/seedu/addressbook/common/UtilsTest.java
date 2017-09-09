package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

public class UtilsTest {
    @Test
    public void isAnyNull() throws Exception {
        // no object
        assertAreNotNull();

        // all are non-null objects
        assertAreNotNull(new Integer(1), "abc");
        assertAreNotNull(new ArrayList<String>());

        // at least one is a null object
        String[] stringArrayWithoutObjects = new String[3]; // array contains 3 null objects
        assertAreNull(stringArrayWithoutObjects[2], new Integer(2), "abc");
        assertAreNull(stringArrayWithoutObjects[0]);
        assertAreNull(stringArrayWithoutObjects[0], null);

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


    private void assertAreNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertAreNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
