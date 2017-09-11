package seedu.addressbook.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.addressbook.common.Utils.isAnyNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
    /**
     * Asserts that null objects are properly captured by isAnyNull.
     */
    public  void assertIsAnyNull(){
        boolean noObjectsTest = isAnyNull();
        boolean emptyObjectTest = isAnyNull(" ", " ", 0);
        boolean noNullObjectTest = isAnyNull("Item1", "Item2", 123, 33.4, 'a');
        boolean nullPresentTest = isAnyNull("Item1", null, 123, 33.4);
        boolean allNullTest = isAnyNull(null, null, null, null);

        boolean[] testResults = {noObjectsTest, emptyObjectTest, noNullObjectTest, nullPresentTest, allNullTest};
        boolean[] expected = {false, false, false, true, true};

        Assert.assertArrayEquals(testResults, expected);
    }
}
