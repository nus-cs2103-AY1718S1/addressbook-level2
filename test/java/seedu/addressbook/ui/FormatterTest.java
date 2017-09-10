package seedu.addressbook.ui;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    Formatter formatter;
    Class formatterClass;

    @Before
    public void setUp() {
        formatter = new Formatter();
        formatterClass = formatter.getClass();
    }

    @Test
    public void formatter_printIndexItem() throws Exception {
        Class<?>[] paramTypes = {int.class, String.class};

        Method method = formatterClass.getDeclaredMethod("getIndexedListItem", paramTypes);
        method.setAccessible(true);

        String result = (String) method.invoke(formatter, 1, "something");
        assertEquals("\t1. something", result);
    }
}
