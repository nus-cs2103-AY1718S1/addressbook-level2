package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;

public class EditCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    
    private static final String FIELD_TYPE_PHONE = "p";
    private static final String FIELD_TYPE_EMAIL = "e";
    private static final String FIELD_TYPE_ADDRESS = "a";
    private static final String FIELD_TYPE_INVALID = "i";

    private static final String VALID_VALUE_PHONE = "99999999";
    private static final String VALID_VALUE_EMAIL = "newEmail@domain.com";
    private static final String VALID_VALUE_ADDRESS = "New Address";

    private static final String INVALID_VALUE_PHONE = "invalid";
    private static final String INVALID_VALUE_EMAIL = "invalid";
    
    @Test
    public void editCommand_invalidPhone_throwsException() throws Exception {
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);
        
        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_PHONE, INVALID_VALUE_PHONE);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();
        
        assertEquals(EditCommand.MESSAGE_INCORRECT_PARAMETERS, result.feedbackToUser);
    }
    
    @Test
    public void editCommand_validPhone_correctResult() throws Exception{
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);
        
        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_PHONE, VALID_VALUE_PHONE);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(String.format(EditCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }
    
    @Test
    public void editCommand_invalidEmail_throwsException() throws Exception {
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);

        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_EMAIL, INVALID_VALUE_EMAIL);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(EditCommand.MESSAGE_INCORRECT_PARAMETERS, result.feedbackToUser);
    }
    
    @Test
    public void editCommand_validEmail_correctResult() throws Exception{
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);

        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_EMAIL, VALID_VALUE_EMAIL);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(String.format(EditCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }
    
    @Test
    public void editCommand_validAddress_correctResult() throws Exception{
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);
        
        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_ADDRESS, VALID_VALUE_ADDRESS);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(String.format(EditCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }

    @Test
    public void editCommand_invalidField_throwsExcetion() throws Exception{
        // Add test person
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(p);

        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_INVALID, VALID_VALUE_PHONE);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(EditCommand.MESSAGE_FIELD_TYPE_NOT_RECOGNISED, result.feedbackToUser);
    }

    @Test
    public void editCommand_personDoesNotExist_throwsExcetion() throws Exception{
        // Create test person without adding to Address Book
        Person p = TestUtil.generateTestPerson();
        AddressBook addressBook = new AddressBook();

        // Edit test person
        String personName = p.getName().toString();
        EditCommand editCommand = new EditCommand(personName, FIELD_TYPE_PHONE, VALID_VALUE_PHONE);
        editCommand.setData(addressBook, EMPTY_PERSON_LIST);
        CommandResult result = editCommand.execute();

        assertEquals(EditCommand.MESSAGE_PERSON_NOT_FOUND, result.feedbackToUser);
    }
    
}



