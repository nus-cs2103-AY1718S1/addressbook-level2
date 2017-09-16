package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeleteRangeCommandTest {
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

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

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void execute_emptyAddressBook_returnsPersonNotFoundMessage() {
        assertDeletionFailsDueToNoSuchPerson(1, 2, emptyAddressBook, listWithEveryone);
    }

    @Test
    public void execute_noPersonDisplayed_returnsInvalidIndexMessage() {
        assertDeletionFailsDueToInvalidIndex(1, 2, addressBook, emptyDisplayList);
    }

    @Test
    public void execute_targetPersonNotInAddressBook_returnsPersonNotFoundMessage()
            throws IllegalValueException {
        Person notInAddressBookPerson = new Person(new Name("Not In Book"), new Phone("63331444", false),
                new Email("notin@book.com", false), new Address("156D Grant Road", false), new UniqueTagList());
        List<ReadOnlyPerson> listWithPersonNotInAddressBook = TestUtil.createList(notInAddressBookPerson);

        assertDeletionFailsDueToNoSuchPerson(1, 2, addressBook, listWithPersonNotInAddressBook);
    }

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {
        assertDeletionFailsDueToInvalidIndex(0, 0, addressBook, listWithEveryone);
        assertDeletionFailsDueToInvalidIndex(-1, -1, addressBook, listWithEveryone);
        assertDeletionFailsDueToInvalidIndex(listWithEveryone.size() + 1, listWithEveryone.size() + 1, addressBook, listWithEveryone);
    }

    @Test
    public void execute_validIndex_personIsDeleted() throws UniquePersonList.PersonNotFoundException {
        assertDeletionSuccessful(1, 1, addressBook, listWithSurnameDoe);
        assertDeletionSuccessful(listWithSurnameDoe.size(), listWithSurnameDoe.size(), addressBook, listWithSurnameDoe);

        int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
        assertDeletionSuccessful(middleIndex, middleIndex, addressBook, listWithSurnameDoe);
    }

    /**
     * Creates a new delete command.
     *
     * @param visibleIndices of the people that we want to delete
     */
    private DeleteRangeCommand createDeleteRangeCommand(ArrayList<Integer> visibleIndices, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) {

        DeleteRangeCommand command = new DeleteRangeCommand(visibleIndices);
        command.setData(addressBook, displayList);

        return command;
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(DeleteRangeCommand deleteRangeCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = deleteRangeCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Asserts that the start index and end index are not valid for the given display list.
     */
    private void assertDeletionFailsDueToInvalidIndex(int invalidVisibleStartIndex, int invalidVisibleEndIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;
        ArrayList<Integer> invalidVisibleIndices = new ArrayList<>();
        invalidVisibleIndices.add(invalidVisibleStartIndex);
        invalidVisibleIndices.add(invalidVisibleEndIndex);

        DeleteRangeCommand command = createDeleteRangeCommand(invalidVisibleIndices, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index cannot be deleted, because that person
     * is not in the address book.
     */
    private void assertDeletionFailsDueToNoSuchPerson(int visibleStartIndex, int visibleEndIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK;
        ArrayList<Integer> visibleIndices = new ArrayList<>();
        visibleIndices.add(visibleStartIndex);
        visibleIndices.add(visibleEndIndex);

        DeleteRangeCommand command = createDeleteRangeCommand(visibleIndices, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the people within the specified indices can be successfully deleted.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertDeletionSuccessful(int targetVisibleStartIndex, int targetVisibleEndIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) throws UniquePersonList.PersonNotFoundException {
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        for (int i=targetVisibleStartIndex; i<= targetVisibleEndIndex;i++) {
            ReadOnlyPerson targetPerson = displayList.get(i- TextUi.DISPLAYED_INDEX_OFFSET);


            expectedAddressBook.removePerson(targetPerson);

        }
        String expectedMessage = DeleteRangeCommand.MESSAGE_DELETE_RANGE_SUCCESS + targetVisibleStartIndex + " to " + targetVisibleEndIndex;

        ArrayList<Integer> visibleIndices = new ArrayList<>();
        visibleIndices.add(targetVisibleStartIndex);
        visibleIndices.add(targetVisibleEndIndex);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        DeleteRangeCommand command = createDeleteRangeCommand(visibleIndices, actualAddressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }
}
