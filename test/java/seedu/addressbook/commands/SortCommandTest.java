package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static seedu.addressbook.commands.Command.getMessageForPersonListShownSummary;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;
    private AddressBook sortedAddressBook;

    private List<ReadOnlyPerson> originalList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false),
                new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, davidGrant);
        sortedAddressBook = TestUtil.createAddressBook(davidGrant, johnDoe);

        originalList = TestUtil.createList(johnDoe, davidGrant);
    }

    @Test
    public void execute_emptyAddressBook_returnsEmptyBookMessage() {
        assertSortFailDueToEmptyAddressBook(emptyAddressBook, originalList);
    }

    @Test
    public void execute_successfulSort() {
        assertSortSuccessful(addressBook, sortedAddressBook, originalList);
    }

    /**
     * Creates a new sort command
     */
    public SortCommand createSortCommand(AddressBook addressBook, List<ReadOnlyPerson> displayList) {
        SortCommand command = new SortCommand();
        command.setData(addressBook, displayList);

        return command;
    }

    /**
     * Asserts that sort will fail with an empty address book.
     */
    public void assertSortFailDueToEmptyAddressBook(AddressBook addressBook, List<ReadOnlyPerson> displayList) {
        String expectedMessage = Messages.MESSAGE_EMPTY_ADDRESSBOOK;

        SortCommand command = createSortCommand(addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that sort will be successful.
     */
    private void assertSortSuccessful(AddressBook unsortedAddressBook, AddressBook sortedAddressBook,
                                      List<ReadOnlyPerson> displayList) {

        AddressBook actualAddressBook = TestUtil.clone(unsortedAddressBook);
        AddressBook expectedAddressBook = TestUtil.clone(sortedAddressBook);
        String expectedMessage = String.format(SortCommand.MESSAGE_SORT_SUCCESS + "\n" +
                getMessageForPersonListShownSummary(displayList), displayList);

        SortCommand command = createSortCommand(actualAddressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(SortCommand sortCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = sortCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }
}
