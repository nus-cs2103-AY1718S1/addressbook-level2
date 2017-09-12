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
    public void isAnyNull() {
        //no arguments
        assertNoNull();
        
        //null argument, in multiples
        assertSomeNull((Object) null);
        assertSomeNull(null, null, null);
        
        //one argument, no nulls
        assertNoNull(2);
        assertNoNull("Test");
        assertNoNull("");
        assertNoNull(false);
        
        //multiple arguments, no nulls
        assertNoNull(1,2,3,4);
        assertNoNull("String, test", 1, 12, "23");
        assertNoNull(new Integer(5), false);
        assertNoNull(false, 1, "false");
        
        //multiple arguments, some nulls
        assertSomeNull(1, null);
        assertSomeNull("true", null, "false");
        assertSomeNull(1,2,3,4,5,6,7,8,null,10);
        assertSomeNull(null, null, 2, null, null);
        
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
    
    private void assertSomeNull(Object... objects) {assertTrue(Utils.isAnyNull(objects)); }
    
    private void assertNoNull(Object... objects) {assertFalse(Utils.isAnyNull(objects));}
}
