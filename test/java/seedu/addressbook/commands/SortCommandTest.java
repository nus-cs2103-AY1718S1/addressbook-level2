package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook addressBook;
    private AddressBook emptyAddressBook;
    private AddressBook sortedAddressBook;

    private List<ReadOnlyPerson> emptyList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        sortedAddressBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);

        emptyList = TestUtil.createList();
    }

    @Test
    public void execute_nonEmptyList_returnsSortingSuccessfulMessage() {
        assertSortingSuccessful(addressBook, emptyList, sortedAddressBook);
    }

    @Test
    public void execute_EmptyList_returnsSortingFailedMessage() {
        assertSortingFailed(emptyAddressBook, emptyList);
    }

    /**
     * Create the sorting command to sort the list
     */
    private SortCommand createSortCommand(AddressBook addressBook, List<ReadOnlyPerson> emptyList) {
        SortCommand command = new SortCommand();
        command.setData(addressBook, emptyList);
        return command;
    }

    /**
     * Assert a non-empty addressBook so the addressBook can be sorted successfully
     */
    private void assertSortingSuccessful(AddressBook addressBook, List<ReadOnlyPerson> emptyList,
                                            AddressBook expectedAddressBook) {
        SortCommand command = createSortCommand(addressBook, emptyList);
        CommandResult result = command.execute();
        assertEquals(result.feedbackToUser, SortCommand.MESSAGE_SORT_ADDRESSBOOK_SUCCESS);
        assertEquals(addressBook.getAllPersons(), expectedAddressBook.getAllPersons());
    }

    /**
     * Assert an empty addressBook so the sorting will display an error message
     */
    private void assertSortingFailed (AddressBook addressBook, List<ReadOnlyPerson> emptyList) {
        SortCommand command = createSortCommand(addressBook, emptyList);
        CommandResult result = command.execute();
        assertEquals(result.feedbackToUser, Messages.MESSAGE_SORTING_FAILED);
    }
}