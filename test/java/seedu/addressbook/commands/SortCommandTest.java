package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {


    /**
     * Asserts that the SortCommand reports the error.
     */
    private static void assertSortError(AddressBook addressBook, String expectedMessage) {
        assertSortBehavior(new SortCommand(), addressBook, expectedMessage);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The original addressbook data is not modified after executing SortCommand.
     */
    private static void assertSortCommandBehavior(Command sortCommand, AddressBook addressBook) {

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        List<ReadOnlyPerson> PersonList = addressBook.getAllPersons().immutableListView();

        sortCommand.setData(addressBook, PersonList);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected.
        assertEquals(Command.getMessageForPersonSortShownSummary(PersonList), result.feedbackToUser);

        // addressbook was not modified.
        assertEquals(expectedAddressBook.getAllPersons(), addressBook.getAllPersons());
    }


}

