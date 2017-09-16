package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;



public class EditCommandTest {

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

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe);

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe);
    }

    @Test
    public void execute_noPersonDisplayed_returnsInvalidIndexMessage() throws IllegalValueException {
        assertEditingFailsDueToInvalidIndex(2, addressBook, emptyDisplayList);
    }

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() throws IllegalValueException {
        assertEditingFailsDueToInvalidIndex(0, addressBook, listWithEveryone);
        assertEditingFailsDueToInvalidIndex(-1, addressBook, listWithEveryone);
        assertEditingFailsDueToInvalidIndex(listWithEveryone.size() + 1, addressBook, listWithEveryone);
    }

    @Test
    public void editCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidEditCmdThrowsException(1, number, true, "", false, "", false);
        }
    }

    @Test
    public void editCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidEditCmdThrowsException(2, "", false, email, true, "", false);
        }
    }

    @Test
    public void editCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidEditCmdThrowsException(3, "", false, "", false, address, true);
        }
    }

    @Test
    public void execute_validIndex_personIsEdited() throws UniquePersonList.PersonNotFoundException, IllegalValueException {
        assertEditingSuccessful(1, "00000000", false, addressBook, listWithSurnameDoe);
        assertEditingSuccessful(listWithSurnameDoe.size(), "11111111", true, addressBook, listWithSurnameDoe);
    }

    /**
     * Creates a new edit command.
     *
     * @param targetVisibleIndex of the person that we want to edit
     */
    private EditCommand createEditCommand(int targetVisibleIndex, String phone, boolean isPhonePrivate, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) throws IllegalValueException {

        EditCommand command = new EditCommand(targetVisibleIndex, phone, isPhonePrivate,
                                                    "", false, "", false);
        command.setData(addressBook, displayList);

        return command;
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(EditCommand editCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = editCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertEditingFailsDueToInvalidIndex(int invalidVisibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) throws IllegalValueException {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        EditCommand command = createEditCommand(invalidVisibleIndex, Phone.EXAMPLE, true, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }


    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidEditCmdThrowsException(int targetIndex, String phone,
                                                                 boolean isPhonePrivate, String email, boolean isEmailPrivate, String address,
                                                                 boolean isAddressPrivate) {
        try {
            new EditCommand(targetIndex, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate);
        } catch (IllegalValueException e) {
            return;
        }
        if (!phone.equals("")) {
            String error = String.format(
                    "An add command was successfully constructed with invalid input: %s %s %s",
                    targetIndex, phone, isPhonePrivate);
            fail(error);
        }
        if (!email.equals("")) {
            String error = String.format(
                    "An add command was successfully constructed with invalid input: %s %s %s",
                    targetIndex, email, isEmailPrivate);
            fail(error);
        }
        if (!address.equals("")) {
            String error = String.format(
                    "An add command was successfully constructed with invalid input: %s %s %s",
                    targetIndex, address, isAddressPrivate);
            fail(error);
        }
    }

    @Test
    public void editCommand_validData_correctlyConstructed() throws Exception {
        EditCommand command = new EditCommand(1, Phone.EXAMPLE, true, "", false,
                "", false);
        Object[] newPersonData = command.getNewPersonData();

        Phone newPhone = (Phone) newPersonData[1];
        assertTrue(newPhone.equals(new Phone(Phone.EXAMPLE, true)));
        assertTrue(newPhone.isPrivate());

        command = new EditCommand(2, "", false, Email.EXAMPLE, true,
                "", false);
        newPersonData = command.getNewPersonData();

        Email newEmail = (Email) newPersonData[2];
        assertTrue(newEmail.equals(new Email(Email.EXAMPLE, true)));
        assertTrue(newEmail.isPrivate());

        command = new EditCommand(3, "", false, "", false,
                Address.EXAMPLE, true);
        newPersonData = command.getNewPersonData();

        Address newAddress = (Address) newPersonData[3];
        assertTrue(newAddress.equals(new Address(Address.EXAMPLE, true)));
        assertTrue(newAddress.isPrivate());
    }

    /**
     * Asserts that the person at the specified index can be successfully edited.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertEditingSuccessful(int targetVisibleIndex, String phone, boolean isPhonePrivate, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) throws UniquePersonList.PersonNotFoundException,IllegalValueException {

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);
        Object[] newPersonData = new Object[EditCommand.EDIT_PERSON_DATA_COUNT];
        newPersonData[EditCommand.EDIT_PERSON_DATA_INDEX_PHONE] = new Phone(phone, isPhonePrivate);

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        expectedAddressBook.editPerson(targetPerson, newPersonData);
        String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_PERSON_SUCCESS, targetPerson);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        EditCommand command = createEditCommand(targetVisibleIndex, phone, isPhonePrivate, actualAddressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }
}