package seedu.addressbook.common;

import static org.junit.Assert.assertEquals;
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
    public void isAnyNullTest() throws Exception {
        
        //one object
        assertTrue(Utils.isAnyNull((Object)null));
        assertFalse(Utils.isAnyNull(1));
        assertFalse(Utils.isAnyNull("null"));
        
        //more than 1 object
        assertTrue(Utils.isAnyNull("1", null, "3"));
        assertTrue(Utils.isAnyNull("1", null, null));
        
        //same Type
        assertFalse(Utils.isAnyNull("1", "2", "null", "4"));
        
        //different Types
        assertFalse(Utils.isAnyNull(1, "2", new int[]{1,2,3}));
        
        
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
