package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

public class EditCommandTest {

    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    private static final int VALID_INDEX = 1;

    private AddressBook addressBook;

    private List<ReadOnlyPerson> listWithSurnameDoe;

    @Before
    public void setUp() throws Exception {
        Person bigDoe = new Person(new Name("Big Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        addressBook = TestUtil.createAddressBook(bigDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(bigDoe, janeDoe, samDoe);
    }

    //TODO: Construct more JUnit tests
    @Test
    public void editCommand_invalidIndex_throwsException() {
    }

    @Test
    public void editCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidEditCmdThrowsException(VALID_INDEX, name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidEditCmdThrowsException(VALID_INDEX, Name.EXAMPLE, number, false, Email.EXAMPLE, true,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidEditCmdThrowsException(VALID_INDEX, Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidEditCmdThrowsException(VALID_INDEX, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, address, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void editCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidEditCmdThrowsException(VALID_INDEX, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, Address.EXAMPLE, false, tagsToAdd);
        }
    }

    @Test
    public void editCommand_validIndex_personIsEdited() throws Exception {
        assertEditSuccessful(1, addressBook, listWithSurnameDoe,
                Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, true,
                Address.EXAMPLE, true, EMPTY_STRING_LIST);
        assertEditSuccessful(listWithSurnameDoe.size(), addressBook, listWithSurnameDoe,
                Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, true,
                Address.EXAMPLE, true, EMPTY_STRING_LIST);

        int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
        assertEditSuccessful(middleIndex, addressBook, listWithSurnameDoe,
                Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, true,
                Address.EXAMPLE, true, EMPTY_STRING_LIST);
    }

    /**
     * Creates a new edit command.
     *
     */
    private EditCommand createEditCommand(int targetVisibleIndex,
                                          AddressBook addressBook, List<ReadOnlyPerson> displayList,
                                          String name, String phone, boolean isPhonePrivate,
                                          String email, boolean isEmailPrivate,
                                          String address, boolean isAddressPrivate,
                                          Set<String> tags) throws IllegalValueException{

        EditCommand command = new EditCommand(targetVisibleIndex,
                name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
        command.setData(addressBook, displayList);

        return command;
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

    /**
     * Asserts that the person at the specified index can be successfully edited with valid data.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertEditSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                      List<ReadOnlyPerson> displayList, String name,
                                      String phone, boolean isPhonePrivate,
                                      String email, boolean isEmailPrivate,
                                      String address, boolean isAddressPrivate,
                                      Set<String> tags)
            throws UniquePersonList.PersonNotFoundException, IllegalValueException{

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);

        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        Person replacement = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                new UniqueTagList(tagSet));

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        ReadOnlyPerson editedPerson = expectedAddressBook.editPerson(targetPerson, replacement);
        String expectedMessage = String.format(EditCommand.MESSAGE_EDITED_PERSON_SUCCESS, editedPerson);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        EditCommand command = createEditCommand(targetVisibleIndex, actualAddressBook, displayList,
                                                name, phone, isPhonePrivate,
                                                email, isEmailPrivate, address,
                                                isAddressPrivate, tags);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(EditCommand editCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = editCommand.execute();

        assertEquals(expectedMessage, result.getFeedbackToUser());
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }
}
