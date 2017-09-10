package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
    public void isAnyNullFalse() throws Exception {
        Utils newUtils = new Utils();
        ArrayList<Integer> arrayListTest = new ArrayList<Integer>();
        arrayListTest.add(5);
        HashSet<Integer> hashTest = new HashSet<Integer>();
        hashTest.add(2);
        assertFalse(newUtils.isAnyNull(hashTest,arrayListTest));
    }

    @Test
    public void isAnyNullTrue() throws Exception {
        Utils newUtils = new Utils();
        assertTrue(newUtils.isAnyNull(null,null,new ArrayList<Integer>()));
    }


    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
