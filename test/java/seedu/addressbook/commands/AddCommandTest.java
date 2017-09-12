package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;

public class AddCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();

    @Test
    public void addCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidAddCmdThrowsException(name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void addCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, number, true, Email.EXAMPLE, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }

    @Test
    public void addCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                                         "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, email, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }
    @Test
    public void addCommand_invalidUnit_throwsException() {
        final String[] invalidUnit = { "", " ", "#a", "1-2", "#a-"};
        for (String unit : invalidUnit) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, unit, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }
    @Test
    public void addCommand_invalidPostalCode_throwsException() {
        final String[] invalidPostalCodes = { "", " ", "abv", "123sdf", "12345", "1234567"};
        for (String postalCode : invalidPostalCodes) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, postalCode, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        }
    }


    @Test
    public void addCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                                         { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, tagsToAdd);
        }
    }

    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidAddCmdThrowsException(String name, String phone,
            boolean isPhonePrivate, String email, boolean isEmailPrivate, String block,
            boolean isBlockPrivate,String street,
            boolean isStreetPrivate,String unit,
            boolean isUnitPrivate,String postalCode,
            boolean isPostalCodePrivate, Set<String> tags) {
        try {
            new AddCommand(name, phone, isPhonePrivate, email, isEmailPrivate, block, isBlockPrivate,
                    street, isStreetPrivate, unit, isUnitPrivate, postalCode, isPostalCodePrivate,
                    tags);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An add command was successfully constructed with invalid input: %s %s %s %s %s %s %s %s %s %s %s %s %s %s",
                name, phone, isPhonePrivate, email, isEmailPrivate, block, isBlockPrivate,
                street, isStreetPrivate, unit, isUnitPrivate, postalCode, isPostalCodePrivate, tags);
        fail(error);
    }

    @Test
    public void addCommand_validData_correctlyConstructed() throws Exception {
        AddCommand command = new AddCommand(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                Block.EXAMPLE, false, Street.EXAMPLE, false, Unit.EXAMPLE, false, PostalCode.EXAMPLE, false, EMPTY_STRING_LIST);
        ReadOnlyPerson p = command.getPerson();

        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals(Name.EXAMPLE, p.getName().fullName);
        assertEquals(Phone.EXAMPLE, p.getPhone().value);
        assertTrue(p.getPhone().isPrivate());
        assertEquals(Email.EXAMPLE, p.getEmail().value);
        assertFalse(p.getEmail().isPrivate());
        assertEquals(Block.EXAMPLE, p.getBlock().value);
        assertFalse(p.getBlock().isPrivate());
        assertEquals(Street.EXAMPLE, p.getStreet().value);
        assertFalse(p.getStreet().isPrivate());
        assertEquals(Unit.EXAMPLE, p.getUnit().value);
        assertFalse(p.getUnit().isPrivate());
        assertEquals(PostalCode.EXAMPLE, p.getPostalCode().value);
        assertFalse(p.getPostalCode().isPrivate());
        boolean isTagListEmpty = !p.getTags().iterator().hasNext();
        assertTrue(isTagListEmpty);
    }

    @Test
    public void addCommand_emptyAddressBook_addressBookContainsPerson() {
        Person p = TestUtil.generateTestPerson();
        AddCommand command = new AddCommand(p);
        AddressBook book = new AddressBook();
        command.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = command.execute();
        UniquePersonList people = book.getAllPersons();

        assertTrue(people.contains(p));
        assertEquals(1, people.immutableListView().size());
        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }

    @Test
    public void addCommand_addressBookAlreadyContainsPerson_addressBookUnmodified() throws Exception {
        Person p = TestUtil.generateTestPerson();
        AddressBook book = new AddressBook();
        book.addPerson(p);
        AddCommand command = new AddCommand(p);
        command.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = command.execute();

        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(AddCommand.MESSAGE_DUPLICATE_PERSON, result.feedbackToUser);
        UniquePersonList people = book.getAllPersons();
        assertTrue(people.contains(p));
        assertEquals(1, people.immutableListView().size());
    }
}
