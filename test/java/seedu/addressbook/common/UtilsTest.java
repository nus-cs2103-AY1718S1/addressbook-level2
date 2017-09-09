package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;

public class UtilsTest {
    @Test
    public void util_isAnyNull() {
        // empty list
        assertNoNull();

        // only one object
        assertHasNull(null);

        // multiple object
        assertHasNull(1, null, "abc");

        AddressBook myBook = null;
        assertHasNull(myBook);
    }

    private void assertHasNull(Object... items) {
        assertTrue(Utils.isAnyNull(items));
    }

    private void assertNoNull(Object... items) {
        assertFalse(Utils.isAnyNull(items));
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
