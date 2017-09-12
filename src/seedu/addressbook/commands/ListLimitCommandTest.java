package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListLimitCommandTest {
    private TypicalPersons td = new TypicalPersons();
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());


    @Test
    public void execute() throws IllegalValueException {
        // empty addressbook
        assertListLimitCommandBehavior(emptyAddressBook,-1,"0 persons listed!");
        assertListLimitCommandBehavior(emptyAddressBook,0,"0 persons listed!");
        assertListLimitCommandBehavior(emptyAddressBook,2,"0 persons listed!");

        // non-empty addressbook
        assertListLimitCommandBehavior(typicalAddressBook,-1, "0 persons listed!");
        assertListLimitCommandBehavior(typicalAddressBook,0, "0 persons listed!");
        assertListLimitCommandBehavior(typicalAddressBook,2, "2 persons listed!");
    }

    private void assertListLimitCommandBehavior(AddressBook addressBook, int targetVisibleIndex, String expectedMessage) {

        assertListLimitBehavior(new ListLimitCommand(targetVisibleIndex), addressBook, listWithAllTypicalPersons, expectedMessage);
    }

    private static void assertListLimitBehavior(Command listLimitCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {
        listLimitCommand.setData(addressBook, relevantPersons);
        CommandResult result = listLimitCommand.execute();
        assertEquals(expectedMessage, result.feedbackToUser);
    }

}
