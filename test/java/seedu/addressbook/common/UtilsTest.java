package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

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

        //No null objects
        assertNoNull("hi", "bye");
        assertNoNull(" ");
        assertNoNull(new Integer(1), new Double(2));
        assertNoNull(0,0,0,0);
        assertNoNull(false);
        assertNoNull(true);

        //some null objects
        assertSomeNull(null,null);
        assertSomeNull("2",null,new Float(10));
        assertSomeNull(new String("2222"), new Integer(2), null);
        assertSomeNull(null,"yes");

    }

    private void assertNoNull(Object... objects){ assertFalse(Utils.isAnyNull(objects));}

    private void assertSomeNull(Object... objects){ assertTrue(Utils.isAnyNull(objects));}

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
