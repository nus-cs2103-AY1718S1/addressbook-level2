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
    public void isAnyNull() throws Exception {
        // empty list
        assertFalse(Utils.isAnyNull());
        
        // list of objects none of which is null
        assertFalse(Utils.isAnyNull(new Integer(1), new Double(23.5), "NotNullObject"));
        assertFalse(Utils.isAnyNull(new Integer(52)));
        assertFalse(Utils.isAnyNull(new Integer(1), "aaa", 'c', "BBBB", "XXX "));
        
        // list of objects of which some are null
        assertTrue(Utils.isAnyNull("other", "background", null, "objects"));
        assertTrue(Utils.isAnyNull(null, null));
        assertTrue(Utils.isAnyNull("other", "background", new Integer(5), null));        
        assertTrue(Utils.isAnyNull(null,"other", "background", new Integer(5)));        
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
