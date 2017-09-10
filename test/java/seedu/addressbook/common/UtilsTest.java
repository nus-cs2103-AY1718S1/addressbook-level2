package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void elementsAreUnique() throws Exception {
        assertAreUnique("abc","ab","abd");
    }

    @Test
    public void elementsNotUnique() throws Exception{
        assertNotUnique("ab","ab",null);
        assertNotUnique(null,"abc","ab","abc");
    }

    @Test
    public void noNullElements() throws Exception{
        // empty list
        assertNoNull();

        // only one object
        assertNoNull(1);
        assertNoNull("");
        assertNoNull("abc");

        // all objects unique
        assertNoNull("abc", "ab", "a");
        assertNoNull(1, 2);

        // some identical objects
        assertNoNull("abc", "abc");
        assertNoNull("abc", "", "abc", "ABC");
        assertNoNull("", "abc", "a", "abc");
        assertNoNull(1, new Integer(1));
    }

    @Test
    public void haveNullElements() throws Exception{
        assertExistNull((Object)null);
        assertExistNull(null, 1, new Integer(1));
        assertExistNull("abc", null, "ab");
        assertExistNull("cda", "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertExistNull(Object... objects) {
        assertTrue(Utils.isAnyNull(objects));
    }

    private void assertNoNull(Object... objects){
        assertFalse(Utils.isAnyNull(objects));
    }
}
