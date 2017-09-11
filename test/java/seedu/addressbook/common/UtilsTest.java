package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {
    @Test
    public void isAnyNull() throws Exception {
        //Empty List
        assertAreNotNull();

        //Only one object
        assertAreNotNull((Object) null);
        assertAreNotNull(1);
        assertAreNotNull("");
        assertAreNotNull("abc");

        //Null at the end
        assertAreNotNull(1,null);
        assertAreNotNull("",null);
        assertAreNotNull("abc",null);

        //Null at the start
        assertAreNotNull(null,1);
        assertAreNotNull(null,"");
        assertAreNotNull(null,"abc");
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

    private void assertAreNotNull(Object... objects){
        assertNotNull(Utils.isAnyNull(Arrays.asList(objects)));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
