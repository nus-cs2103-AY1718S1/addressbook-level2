package seedu.addressbook.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UtilsTest {

    @Test
    public void isAnyNull_noArguments_returnsFalse() throws Exception {
        assertFalse(Utils.isAnyNull());
    }

    @Test
    public void isAnyNull_emptyArrayInput_returnsFalse() throws Exception {
        Object[] objectArray = new Object[]{};
        assertFalse(Utils.isAnyNull(objectArray));
    }

    @Test
    public void isAnyNull_emptyListInput_returnsFalse() throws Exception {
        ArrayList<Object> objectList = new ArrayList<>();
        assertFalse(Utils.isAnyNull(objectList));
    }

    @Test
    public void isAnyNull_oneIntegerInput_returnsFalse() throws Exception {
        assertFalse(Utils.isAnyNull(1));
    }

    @Test
    public void isAnyNull_oneStringInput_returnsFalse() throws Exception {
        assertFalse(Utils.isAnyNull("abc"));
    }

    @Test
    public void isAnyNull_nullObjectInput_returnsTrue() throws Exception {
        assertTrue(Utils.isAnyNull((Object) null));
    }

    @Test
    public void isAnyNull_multipleinputs_returnsFalse() throws Exception {
        assertFalse(Utils.isAnyNull(1, 2, 3, 4, 5));
        assertFalse(Utils.isAnyNull("string 1", "string 2", "string 3"));
    }

    @Test
    public void isAnyNull_multipleinputs_returnsTrue() throws Exception {
        assertTrue(Utils.isAnyNull("string 1", "string 2", null));
    }

    @Test
    public void isAnyNull_arrayWithNullinput_returnsTrue() throws Exception {
        Object[] arrayWithNull = new Object[2];
        arrayWithNull[0] = "abc";
        assertTrue(Utils.isAnyNull(arrayWithNull));
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
