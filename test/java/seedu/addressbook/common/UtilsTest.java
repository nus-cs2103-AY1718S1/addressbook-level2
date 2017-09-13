package seedu.addressbook.common;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        //empty list
        assertFalse(Utils.isAnyNull());
        
        //only one object
        assertTrue(Utils.isAnyNull((Object) null));
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull("abc"));
        assertFalse(Utils.isAnyNull(""));
        
        //multiple objects
        assertTrue(Utils.isAnyNull( null, null));
        assertTrue(Utils.isAnyNull("abc", null, "cdd"));
        assertFalse(Utils.isAnyNull(1, "bb"));
        
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
