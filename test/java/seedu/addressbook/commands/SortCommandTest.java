package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithSomeTypicalPersons = Arrays.asList(td.amy, td.candy, td.dan);

    @Test
    public void execute_sortASCWithPeople() throws Exception {
        // empty addressbook
        assertSortWithEmptyAddressBook(emptyAddressBook,emptyPersonList,"asc");

        // non-empty addressbook
        assertSortWithNonEmptyAddressBook(typicalAddressBook, listWithAllTypicalPersons,"asc");

    }

    /**
     * Asserts that the sort is able to be completed despite an empty address book
     */
    private void assertSortWithEmptyAddressBook(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons, String option){
        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS);

        assertSortBehavior(new SortCommand(option),addressBook,relevantPersons,expectedMessage);

        expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS);

        assertSortBehavior(new SortCommand(option),addressBook,relevantPersons,expectedMessage);
    }

    private void assertSortWithNonEmptyAddressBook(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons, String option) {
        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS);

        assertSortBehavior(new SortCommand(option), addressBook, relevantPersons, expectedMessage);

        expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS);

        assertSortBehavior(new SortCommand(option), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);

        sortCommand.setData(addressBook, relevantPersons);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected.
        assertEquals(expectedMessage, result.feedbackToUser);
    }
}
