package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        // no object
        assertNotNull();

        // one object, null
        assertIsNull((Object) null);

        // one object, not null
        assertNotNull(1);
        assertNotNull("");
        assertNotNull("123");

        // several objects, all not null
        assertNotNull(1, 2);
        assertNotNull("abc", "abd", "efg");

        // several null objects
        assertIsNull(1, 2, null);
        assertIsNull(4, null, "hi");
        assertIsNull(null, "hello", "world");

        // all null objects
        assertIsNull(null, null, null);
    }

    private void assertIsNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertNotNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }


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
