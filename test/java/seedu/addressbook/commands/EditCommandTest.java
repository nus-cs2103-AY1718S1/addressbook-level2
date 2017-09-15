package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.UniqueTagList;

import seedu.addressbook.ui.TextUi;

import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EditCommandTest {
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    private static final int INDEX_EXAMPLE = 1;

    private AddressBook editedAddressBook;
    private AddressBook uneditedAddressBook;

    private List<ReadOnlyPerson> listWithUneditedPerson;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());

        Person editedJohnDoe = new Person(new Name("John Doe"), new Phone("98765432", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        editedAddressBook = TestUtil.createAddressBook(editedJohnDoe, janeDoe);
        uneditedAddressBook = TestUtil.createAddressBook(johnDoe, janeDoe);

        listWithUneditedPerson = TestUtil.createList(johnDoe, janeDoe);
    }

    @Test
    public void editCommand_invalidIndex_returnsInvalidIndexMessage() {
        assertEditFailsDueToInvalidIndex(0, uneditedAddressBook, listWithUneditedPerson);
        assertEditFailsDueToInvalidIndex(-1, uneditedAddressBook, listWithUneditedPerson);
        assertEditFailsDueToInvalidIndex(listWithUneditedPerson.size() + 1, uneditedAddressBook, listWithUneditedPerson);
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

    @Test
    public void editCommand_validIndex_personIsEdited() throws IllegalValueException{
        Person editedPerson = new Person(new Name("John Doe"), new Phone("98765432", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        assertEditCmdReturnsCorrectList(1, editedPerson, uneditedAddressBook, listWithUneditedPerson);
    }

    /**
     * Asserts that attempting to construct an edit command with the supplied
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

    private void assertEditFailsDueToInvalidIndex(int index, AddressBook uneditedAddressBook, List<ReadOnlyPerson> listWithUneditedPerson) {
        try {
            Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                    new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
            ReadOnlyPerson target = listWithUneditedPerson.get(index - TextUi.DISPLAYED_INDEX_OFFSET);
            uneditedAddressBook.editPerson(index, target, janeDoe);
        } catch (IllegalValueException e) {
            return;
        } catch (IndexOutOfBoundsException ie) {
            return;
        } catch (UniquePersonList.PersonNotFoundException pnfe) {
            return;
        }
    }

    /**
     * Asserts that using the edit command returns the same addressbook as the expected output
     */
    private void assertEditCmdReturnsCorrectList(int targetIndex, Person toEdit, AddressBook uneditedAddressBook,
                                                 List<ReadOnlyPerson> displayList) {
        try {
            ReadOnlyPerson targetPerson = displayList.get(targetIndex - TextUi.DISPLAYED_INDEX_OFFSET);
            uneditedAddressBook.editPerson(1, targetPerson, toEdit);
            assertEquals(uneditedAddressBook, editedAddressBook);
        } catch (UniquePersonList.PersonNotFoundException pnef) {
        }
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
