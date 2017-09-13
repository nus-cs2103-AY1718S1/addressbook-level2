package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithSomeTypicalPersons = Arrays.asList(td.amy, td.dan, td.candy);
    
    @Test
    public void execute_FailedSorting_returnsEmptyListMessage() {
        // empty addressbook
        assertSortFail(emptyAddressBook, emptyPersonList);
    }

    @Test
    public void execute_SuccessfulSorting_returnsSortedList() {
        // non-empty addressbook
        assertSortSuccess(typicalAddressBook, listWithSomeTypicalPersons);
        assertSortSuccess(typicalAddressBook, listWithAllTypicalPersons);
    }

    /**
     * Asserts that a Sort command can sort {@code addressBook} 
     * persons in the given {@code relevantPersons} list.
     */
    private void assertSortSuccess(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons){
        String expectedMessage = SortCommand.MESSAGE_SUCCESS;
        
        assertSortBehavior(new SortCommand(), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Asserts that a Sort command report an error for empty list
     */
    private void assertSortFail(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons){
        String expectedMessage = String.format(Messages.MESSAGE_FAILED_SORTING);
        assertSortBehavior(new SortCommand(), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that Sort Command exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The original addressbook data is modified after executing SortCommand.
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage){ 
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        
        sortCommand.setData(addressBook, relevantPersons);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected
        assertEquals(expectedMessage, result.giveFeedback());
        
        // address book was modified equally
        assertEquals(expectedAddressBook.getAllPersons(), addressBook.getAllPersons());
    }
    
}
