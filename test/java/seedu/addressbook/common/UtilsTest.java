package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull () throws Exception {
        // empty list
        assertContainsNoNull();

        // lists of items containing null objects
        assertContainsNull(1, null);
        assertContainsNull(2, "Calvin", null, null );
        assertContainsNull(3, null, "Wyn", null, null);

        // all items are not null objects
        assertContainsNoNull(1, 2, 3);
        assertContainsNoNull(1, "Calvin", "Wyn");
        assertContainsNoNull("Calvin", "Wyn", "Wei Hong");
    }

    private void assertContainsNoNull(Object... objects) {
        assertFalse(Utils.isAnyNull((objects)));
    }

    private void assertContainsNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
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
