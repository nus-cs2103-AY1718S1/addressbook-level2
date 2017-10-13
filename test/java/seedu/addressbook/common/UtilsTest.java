package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void isAnyNullTest() {

        //pass it any set of varargs and if none are null then it should be false
        //try a variety of non-null 'zero values' and things that are like null
        assertFalse(Utils.isAnyNull());
        assertFalse(Utils.isAnyNull(1, 2, 3));
        assertFalse(Utils.isAnyNull(0));
        assertFalse(Utils.isAnyNull("the", "dog", "you"));
        assertFalse(Utils.isAnyNull(""));
        assertFalse(Utils.isAnyNull(new ArrayList<>()));

        Object[] testArray = new Object[2];
        testArray[0] = null;
        testArray[1] = 10;
        assertFalse(Utils.isAnyNull(testArray[1]));
        //my testing indicates that testArray!=null but it still sets off the null detector method

        //a set of varargs containing any kind of null should return true
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, 1, 2, "hello"));
        assertTrue(Utils.isAnyNull(1, 2, null, "hello"));
        assertTrue(Utils.isAnyNull(1, 2, "hello", null));
        assertTrue(Utils.isAnyNull(null, null, 3, -1, "cat"));
        assertTrue(Utils.isAnyNull(3, -1, null, null, "cat"));
        assertTrue(Utils.isAnyNull(3, -1, null, "cat", null, new Object()));
        assertTrue(Utils.isAnyNull(null, null, null));
        assertTrue(Utils.isAnyNull(testArray[0]));


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
