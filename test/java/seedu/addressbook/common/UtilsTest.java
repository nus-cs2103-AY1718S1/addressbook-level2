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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull(){
        // no items
        assertNoNull();

        // a single null
        assertHasNull((Object) null);

        // combination of different objects, none of which is null
        assertNoNull(1, 2, 3);
        assertNoNull(1, "Justin", new Integer(3));
        assertNoNull("Justin", 1, 2, 3);

        //combination of different objects, with at least one null mixed in it
        assertHasNull(1, 2, null, 3);
        assertHasNull("Justin", null, new Integer(3), null, 5);
        assertHasNull(null, null);
        assertHasNull(1, 2, "Justin", new Integer(9), "CS2103", 1, null);
    }

    private void assertHasNull(Object... objects){
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNoNull(Object... objects){
        assertFalse(Utils.isAnyNull(objects));
    }

}
