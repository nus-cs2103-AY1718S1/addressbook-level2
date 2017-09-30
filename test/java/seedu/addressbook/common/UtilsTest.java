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
    public void isAnyNull() throws Exception {


        // empty list
        assertIsNotNull();

        // only one object
        assertIsNull((Object) null);
        assertIsNotNull(6);
        assertIsNotNull("");
        assertIsNotNull("abcd", "bcd");

        // all objects are null or not null
        assertIsNull(null, null);
        assertIsNotNull("abcd", "bcd", "1", "254");


        // null in some
        assertIsNull("abc", null);


    }

    private void assertIsNull(Object... obj) {
        assertTrue(Utils.isAnyNull(obj));
    }


    private void assertIsNotNull(Object... obj) {
        assertFalse(Utils.isAnyNull(obj));
    }


    public void notNull() {
        assertFalse(Utils.isAnyNull(1, 2, 3,"abc", 4, 5, 6));
    }


    public void notNull_v2() {
        assertFalse(Utils.isAnyNull(""));
    }

    public void Null_v2() {
        assertTrue(Utils.isAnyNull((Object) null));
    }
    @Test
    public void Null() {
        assertTrue(Utils.isAnyNull(1, 2, 3, null, 4, 5, 6));
    }


}
