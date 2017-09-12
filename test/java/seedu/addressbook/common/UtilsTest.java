package seedu.addressbook.common;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    private Utils utililty;

    @Before
    public void setUp() throws Exception {
        utililty = new Utils();
    }

    @Test
    public void isAnyNull() throws Exception {
        //Empty List
        //assertIfAnyNull();

        //only one object
        assertIfAnyNull(1, (Object) null);
        assertIfAnyNull(0, 1);

        //more than one object
        assertIfAnyNull(1,(Object)  null,1,2);
        assertIfAnyNull(1,1,2,(Object) null);
        assertIfAnyNull(1,1,(Object) null,2);
        assertIfAnyNull(0,1,2,3);
        assertIfAnyNull(1,(Object) null, (Object) null, (Object) null);
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

    private void assertIfAnyNull(int choice, Object... objects) {
        if(choice == 1) { //expect result to be true
            assertTrue(utililty.isAnyNull(objects));
        } else { //expect result to be false
            assertFalse(utililty.isAnyNull(objects));
        }
    }
}