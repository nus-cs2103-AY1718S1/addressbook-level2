package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;

public class UpdateCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();

    @Test
    public void updateCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidUpdateCmdThrowsException(name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void updateCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidUpdateCmdThrowsException(Name.EXAMPLE, number, false, Email.EXAMPLE, true,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void updateCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                                         "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidUpdateCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
                    Address.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void updateCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidUpdateCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, address, true, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void updateCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                                         { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidUpdateCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, Address.EXAMPLE, false, tagsToAdd);
        }
    }

    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidUpdateCmdThrowsException(String name, String phone,
            boolean isPhonePrivate, String email, boolean isEmailPrivate, String address,
            boolean isAddressPrivate, Set<String> tags) {
        try {
            new UpdateCommand(name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate,
                    tags);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An add command was successfully constructed with invalid input: %s %s %s %s %s %s %s %s",
                name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
        fail(error);
    }

    @Test
    public void updateCommand_validData_correctlyConstructed() throws Exception {
        UpdateCommand command = new UpdateCommand(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                Address.EXAMPLE, true, EMPTY_STRING_LIST);
        ReadOnlyPerson p = command.getPerson();

        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals(Name.EXAMPLE, p.getName().fullName);
        assertEquals(Phone.EXAMPLE, p.getPhone().value);
        assertTrue(p.getPhone().isPrivate());
        assertEquals(Email.EXAMPLE, p.getEmail().value);
        assertFalse(p.getEmail().isPrivate());
        assertEquals(Address.EXAMPLE, p.getAddress().value);
        assertTrue(p.getAddress().isPrivate());
        boolean isTagListEmpty = !p.getTags().iterator().hasNext();
        assertTrue(isTagListEmpty);
    }

    @Test
    public void addAndUpdateCommand_emptyAddressBook_addressBookContainsPerson() {
        Person p = TestUtil.generateTestPerson();
        Person p_other = TestUtil.generateOtherTestPerson();
        AddCommand addCommand = new AddCommand(p);
        UpdateCommand updateCommand = new UpdateCommand(p_other);
        AddressBook book = new AddressBook();
        addCommand.setData(book, EMPTY_PERSON_LIST);
        updateCommand.setData(book, EMPTY_PERSON_LIST);
        addCommand.execute();
        UniquePersonList people = book.getAllPersons();
        assertTrue(people.contains(p));
        CommandResult result = updateCommand.execute();

        people = book.getAllPersons();
        assertTrue(people.contains(p_other));
        assertEquals(1, people.immutableListView().size());
        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(String.format(UpdateCommand.MESSAGE_SUCCESS, p_other), result.getFeedBackToUser());
    }

}
