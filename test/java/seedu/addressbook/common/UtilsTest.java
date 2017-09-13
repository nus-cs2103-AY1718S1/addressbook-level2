package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
    
    @Test
    public void isAnyNull() throws Exception {
        //null object
        assertIsAnyNull((Object) null);
        
        //only one object
        assertIsAnyNotNull(1);
        assertIsAnyNotNull("");
        assertIsAnyNotNull("abcde");
        
        //multiple objects with null objects
        assertIsAnyNull(1, (Object) null);
        assertIsAnyNull("abcde", "heheh", (Object) null);
        assertIsAnyNull("abcde", (Object) null, "heheh");
        assertIsAnyNull((Object) null, (Object) null);
        assertIsAnyNull("abc",(Object) null, (Object) null,"ABC");
        
        //multiple objects with no null objects
        assertIsAnyNotNull(1, "abc", "");
        assertIsAnyNotNull("hehehe", "abc", 1, 1091);
        assertIsAnyNotNull("ab", "AB", "aB", "Ab");
        assertIsAnyNotNull(1, new Integer(1), "xyzw");
    }
    
    private void assertIsAnyNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertIsAnyNotNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }
}
