package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {

        //objects without null
        assertNotNull(1);
        assertNotNull("");
        assertNotNull("abc");
        assertNotNull("abc", "ab", "a");
        assertNotNull(1, 2);
        assertNotNull("abc", "abc");
        assertNotNull("abc", "", "abc", "ABC");
        assertNotNull("", "abc", "a", "abc");
        assertNotNull(1, new Integer(1));

        //objects with 1 null
        assertNull((Object) null);
        assertNull(1, new Integer(1), null);
        assertNull(null, 1, new Integer(1));

        //objects with multiple nulls
        assertNull(null, null);
        assertNull(null, "a", "b", null);
        assertNull("a", null, "b", null, "c", null);
    }


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique(null, "asd");
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

    private void assertNotNull(Object... objects) {
        assertFalse(Utils.isAnyNull(objects));
    }

    private void assertNull(Object... objects) {
        for(Object object: objects) {
            if(object == null) {
                assertTrue(Utils.isAnyNull(objects));
            }
        }
    }
}
