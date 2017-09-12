package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.addressbook.commands.SortableCommand.POSSIBLE_SORT_ARGUMENTS;
import static seedu.addressbook.commands.SortableCommand.isValidSortArgument;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class SortableCommandTest {

    private SortableCommand sortableCommand;
    
    @Before
    public void setUp() { sortableCommand = new SortableCommand(null); }
    
    @Test
    public void testIsValidSortArgument() {
        for (String sortArgument : POSSIBLE_SORT_ARGUMENTS) {
            assertTrue(isValidSortArgument(sortArgument));
        }
        assertFalse(isValidSortArgument("\n"));
        assertFalse(isValidSortArgument("abcd"));
        assertFalse(isValidSortArgument("hello"));
        assertFalse(isValidSortArgument("r3c4q"));
        assertFalse(isValidSortArgument("d/"));
        assertFalse(isValidSortArgument("pp/"));
    }
    
    @Test
    public void testHasSortArguments() throws Exception {
        Method innerHasSortArguments = SortableCommand.class.getDeclaredMethod("hasSortArguments", null);
        innerHasSortArguments.setAccessible(true);
        
        boolean testEmptyCommandArguments = (boolean) innerHasSortArguments.invoke(sortableCommand, null);
        assertFalse(testEmptyCommandArguments);

        sortableCommand = new SortableCommand(new ArrayList<>(POSSIBLE_SORT_ARGUMENTS));
        
        boolean testAllCommandArguments = (boolean) innerHasSortArguments.invoke(sortableCommand, null);
        assertTrue(testAllCommandArguments);
    }
    
    @Test
    public void testSortArgumentCompareValue() throws Exception {
        Method innerSortArgumentCompareValue = SortableCommand.class.getDeclaredMethod("sortArgumentCompareValue", String.class, ReadOnlyPerson.class, ReadOnlyPerson.class);
        innerSortArgumentCompareValue.setAccessible(true);
        
        TypicalPersons typicalPersons = new TypicalPersons();
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"n/", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.amy.getName().toString().compareTo(typicalPersons.candy.getName().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"p/", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.amy.getPhone().toString().compareTo(typicalPersons.candy.getPhone().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"a/", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.amy.getAddress().toString().compareTo(typicalPersons.candy.getAddress().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"e/", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.amy.getEmail().toString().compareTo(typicalPersons.candy.getEmail().toString()));

        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"n/desc", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.candy.getName().toString().compareTo(typicalPersons.amy.getName().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"p/desc", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.candy.getPhone().toString().compareTo(typicalPersons.amy.getPhone().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"a/desc", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.candy.getAddress().toString().compareTo(typicalPersons.amy.getAddress().toString()));
        assertEquals((int) innerSortArgumentCompareValue.invoke(sortableCommand,"e/desc", typicalPersons.amy, typicalPersons.candy),
                typicalPersons.candy.getEmail().toString().compareTo(typicalPersons.amy.getEmail().toString()));
    }

}
