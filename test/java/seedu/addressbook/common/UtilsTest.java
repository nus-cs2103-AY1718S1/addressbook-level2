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
        //empty list
        assertHasNoNull();

        // only one object that is not null
        assertHasNoNull("abc");
        assertHasNoNull(1);

        // only one object that is null
        assertHasNull((Object) null);
        
        // multiple objects none of which are null
        assertHasNoNull("abt", "ABT", "123");
        assertHasNoNull(123, 123, 99);
        assertHasNoNull("abt", 123, "0");
        
        // multiple objects some of which are null
        assertHasNull(123, null, "hello");
        assertHasNull(null, null, 1);

    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    public void assertHasNull(Object... objects) {  assertTrue(Utils.isAnyNull(objects)); }

    public void assertHasNoNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }

}
