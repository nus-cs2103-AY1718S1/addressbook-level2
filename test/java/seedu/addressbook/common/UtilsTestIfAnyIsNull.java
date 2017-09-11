package seedu.addressbook.common;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTestIfAnyIsNull {
    @Test
    public void checkForNullTest() {
        assertTrue(Utils.isAnyNull(new Integer[]{1,2,null}));
    }
}