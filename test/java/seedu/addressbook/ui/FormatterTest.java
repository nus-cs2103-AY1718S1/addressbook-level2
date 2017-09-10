package seedu.addressbook.ui;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Test
    public void formatter_printIndexItem() throws Exception {
        Class formatterClass = Class.forName("seedu.addressbook.ui.Formatter");
        Class<?>[] paramTypes = {int.class, String.class};

        Method method = formatterClass.getDeclaredMethod("getIndexedListItem", paramTypes);
        method.setAccessible(true);

        String result = (String) method.invoke(formatterClass.newInstance(), 1, "something");
        assertEquals("\t1. something", result);
    }
}
