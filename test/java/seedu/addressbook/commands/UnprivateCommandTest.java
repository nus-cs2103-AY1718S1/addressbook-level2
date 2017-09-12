package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

public class UnprivateCommandTest {
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;

    private static final String PHONE_PREFIX = "p";
    private static final String EMAIL_PREFIX = "e";
    private static final String ADDRESS_PREFIX = "a";

    private static final String PHONE = "phone number";
    private static final String EMAIL = "email address";
    private static final String ADDRESS = "address";

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", true),
                new Email("john@doe.com", true), new Address("395C Ben Road", true), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", true),
                new Email("jane@doe.com", true), new Address("33G Ohm Road", true), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", true),
                new Email("sam@doe.com", true), new Address("55G Abc Road", true), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", true),
                new Email("david@grant.com", true), new Address("44H Define Road", true),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void execute_emptyAddressBook_returnsPersonNotFoundMessage() {
        assertUnprivateFailsDueToNoSuchPerson(1, emptyAddressBook, listWithEveryone, PHONE_PREFIX);
    }

    @Test
    public void execute_noPersonDisplayed_returnsInvalidIndexMessage() {
        assertUnprivateFailsDueToInvalidIndex(10, addressBook, emptyDisplayList, PHONE_PREFIX);
    }

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {
        assertUnprivateFailsDueToInvalidIndex(0, addressBook, listWithEveryone, PHONE_PREFIX);
        assertUnprivateFailsDueToInvalidIndex(-1, addressBook, listWithEveryone, PHONE_PREFIX);
        assertUnprivateFailsDueToInvalidIndex(listWithEveryone.size() + 1, addressBook, listWithEveryone, PHONE_PREFIX);
    }

    @Test
    public void execute_validIndex_personIsUnprivated() throws PersonNotFoundException {
        assertUnprivateSuccessful(1, addressBook, listWithSurnameDoe, PHONE_PREFIX);
        assertUnprivateSuccessful(listWithSurnameDoe.size(), addressBook, listWithSurnameDoe, EMAIL_PREFIX);

        int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
        assertUnprivateSuccessful(middleIndex, addressBook, listWithSurnameDoe, ADDRESS_PREFIX);
    }

    /**
     * Creates a new delete command.
     *
     * @param targetVisibleIndex of the person that we want to delete
     */
    private UnprivateCommand createUnprivateCommand(int targetVisibleIndex, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList, String contactType) {

        UnprivateCommand command = new UnprivateCommand(targetVisibleIndex, contactType);
        command.setData(addressBook, displayList);

        return command;
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(UnprivateCommand unprivateCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = unprivateCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertUnprivateFailsDueToInvalidIndex(int invalidVisibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList, String contactType) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        UnprivateCommand command = createUnprivateCommand(invalidVisibleIndex, addressBook, displayList, contactType);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index cannot be deleted, because that person
     * is not in the address book.
     */
    private void assertUnprivateFailsDueToNoSuchPerson(int visibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList, String contactType) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        UnprivateCommand command = createUnprivateCommand(visibleIndex, addressBook, displayList, contactType);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index can be successfully deleted.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws PersonNotFoundException if the selected person is not in the address book
     */
    private void assertUnprivateSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList, String contactType) throws PersonNotFoundException {

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        boolean isSuccessful = expectedAddressBook.unprivatePerson(targetVisibleIndex, contactType);
        assertTrue(isSuccessful);
    }

}
