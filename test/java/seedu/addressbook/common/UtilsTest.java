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

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void isAnyNull() throws Exception {
        // null parameter
        checkExceptionIsNullPointerExceptionForIsAnyNullForNullParameter();

        // null objects only
        assertAnyNull(new Object[] {null});
        assertAnyNull(null, null, null, null);

        // no null objects
        assertNoAnyNull("hello");
        assertNoAnyNull(1, 2, 3);
        assertNoAnyNull(1, "hello", 3.4);
        assertNoAnyNull(1, new Integer(1), new String("hi"), new Object());

        // both null and non-null objects
        assertAnyNull("hello", null, null);
        assertAnyNull(1, null, 2);
        assertAnyNull(null, "hi", null);
        assertAnyNull(new Object(), new String("hello"), null);
        assertAnyNull(new Object[] {"hello", null, null});
    }

    public void assertNoAnyNull(Object... items) {
        assertFalse(Utils.isAnyNull(items));
    }

    public void assertAnyNull(Object... items) {
        assertTrue(Utils.isAnyNull(items));
    }

    public void checkExceptionIsNullPointerExceptionForIsAnyNullForNullParameter() {
        try {
            Utils.isAnyNull();
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }
}
