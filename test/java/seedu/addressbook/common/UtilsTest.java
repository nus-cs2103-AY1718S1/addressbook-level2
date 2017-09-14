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
    public void isAnyNull() throws NullPointerException
    {
        try {
            //Return true
            assertTrue(Utils.isAnyNull((Object) null));
            assertTrue(Utils.isAnyNull("abc", null));
            assertTrue(Utils.isAnyNull(null, null));

            //Return false
            assertFalse(Utils.isAnyNull("abc"));
            assertFalse(Utils.isAnyNull("abc", "null"));
            assertFalse(Utils.isAnyNull("null", "null"));

            //Should return error
            assertTrue(Utils.isAnyNull( null));
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
    }



    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
