package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.storage.StorageForDeleted;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestoreCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;
    private StorageForDeleted storageForDeleted;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;

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
        storageForDeleted = TestUtil.createStorageForDeleted();
        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);

    }

    @Test
    public void execute_RestoreWithoutDeletion() throws Exception {
        assertRestoreFailsDueToNoPersonToRestore(addressBook, listWithEveryone);
    }

    @Test
    public void execute_RestoreSuccessfully() throws Exception {
        assertRestoreSuccessful(1, addressBook, listWithEveryone);
    }

    private void assertRestoreFailsDueToNoPersonToRestore(AddressBook addressBook,
                                                          List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_NO_ONE_IN_STORAGE_FOR_DELETED;

        RestoreCommand command = createRestoreCommand(addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }



    private DeleteCommand createDeleteCommand(int targetVisibleIndex, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) {
        DeleteCommand command = new DeleteCommand(targetVisibleIndex);
        command.setData(addressBook, displayList, storageForDeleted);

        return command;
    }

    /**
     * Creates a new restore command.
     */
    private RestoreCommand createRestoreCommand(AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) {

        RestoreCommand command = new RestoreCommand();
        command.setData(addressBook, displayList, storageForDeleted);

        return command;
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(RestoreCommand restoreCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = restoreCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Asserts that the person at the specified index can be successfully deleted.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertRestoreSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) throws UniquePersonList.PersonNotFoundException {

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);


        //delete first
        DeleteCommand deleteCommand = createDeleteCommand(targetVisibleIndex, addressBook, displayList);
        CommandResult deleteResult = deleteCommand.execute();

        //then add to create the expected addressBook
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        AddCommand addCommand = new AddCommand((Person) targetPerson);
        addCommand.setData(expectedAddressBook, displayList, storageForDeleted);
        CommandResult addResult = addCommand.execute();

        String expectedMessage = String.format("New person added: %1$s", targetPerson);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        RestoreCommand command = createRestoreCommand(actualAddressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }
}

