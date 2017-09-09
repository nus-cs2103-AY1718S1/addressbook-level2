package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void testIsAnyNull() throws Exception {

        Object[] objectArray = new Object[]{};
        Object[] arrayWithNull = new Object[2];
        arrayWithNull[0] = (Object) "abc";
        ArrayList<Object> objectList = new ArrayList<>();

        //no arguments
        assertFalse(Utils.isAnyNull());

        //empty list
        assertFalse(Utils.isAnyNull(objectArray));
        assertFalse(Utils.isAnyNull(objectList));

        //only one object
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull("abc"));
        assertTrue(Utils.isAnyNull((Object) null));

        //multiple objects
        assertFalse(Utils.isAnyNull(1, 2, 3, 4, 5));
        assertFalse(Utils.isAnyNull("string 1", "string 2", "string 3"));
        assertTrue(Utils.isAnyNull("string 1", "string 2", null));
        assertTrue(Utils.isAnyNull(arrayWithNull));
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
