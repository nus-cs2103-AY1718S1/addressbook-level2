package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

import java.util.*;

import static org.junit.Assert.*;

public class EditCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    private static final int INDEX_EXAMPLE = 1;

    @Test
    public void editCommand_invalidIndex_throwsException() {
        final int[] invalidIndexes = {0};
        for (int index : invalidIndexes) {
            assertConstructingInvalidEditCmdThrowsException(index, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidEditCmdThrowsException(INDEX_EXAMPLE, name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidEditCmdThrowsException(INDEX_EXAMPLE, Name.EXAMPLE, number, false, Email.EXAMPLE, true,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidEditCmdThrowsException(INDEX_EXAMPLE, Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidEditCmdThrowsException(INDEX_EXAMPLE, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, address, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidEditCmdThrowsException(INDEX_EXAMPLE, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, Address.EXAMPLE, false, tagsToAdd);
        }
    }

    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidEditCmdThrowsException(int index, String name, String phone,
                                                                boolean isPhonePrivate, String email, boolean isEmailPrivate, String address,
                                                                boolean isAddressPrivate, Set<String> tags) {
        try {
            new EditCommand(index, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate,
                    tags);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An edit command was successfully constructed with invalid input: %d %s %s %s %s %s %s %s %s",
                index, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
        fail(error);
    }

//    /**
//     * Asserts that the person at the specified index can be successfully deleted.
//     *
//     * The addressBook passed in will not be modified (no side effects).
//     *
//     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
//     */
//    private void assertEditSuccessful(int targetVisibleIndex, AddressBook addressBook,
//                                          List<ReadOnlyPerson> displayList) throws UniquePersonList.PersonNotFoundException {
//
//        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);
//
//        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
//        expectedAddressBook.removePerson(targetPerson);
//        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS, targetPerson);
//
//        AddressBook actualAddressBook = TestUtil.clone(addressBook);
//
//        DeleteCommand command = createDeleteCommand(targetVisibleIndex, actualAddressBook, displayList);
//        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
//    }

//    @Test
//    public void addCommand_emptyAddressBook_addressBookContainsPerson() {
//        Person p = TestUtil.generateTestPerson();
//        AddCommand command = new AddCommand(p);
//        AddressBook book = new AddressBook();
//        command.setData(book, EMPTY_PERSON_LIST);
//        CommandResult result = command.execute();
//        UniquePersonList people = book.getAllPersons();
//
//        assertTrue(people.contains(p));
//        assertEquals(1, people.immutableListView().size());
//        assertFalse(result.getRelevantPersons().isPresent());
//        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
//    }
}
