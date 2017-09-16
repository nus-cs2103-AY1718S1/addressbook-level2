package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EditCommandTest {

    private AddressBook beforeEditNameBook;
    private AddressBook afterEditNameBook;

    private AddressBook beforeEditPhoneBook;
    private AddressBook afterEditPhoneBook;

    private AddressBook beforeEditEmailBook;
    private AddressBook afterEditEmailBook;

    private AddressBook beforeEditAddressBook;
    private AddressBook afterEditAddressBook;

    private List<ReadOnlyPerson> emptyDisplayList;

    @Before
    public void setUp() throws Exception{

        Person beforeJohnDoeName = new Person(new Name("Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person afterJohnDoeName = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        Person beforeJohnDoePhone = new Person(new Name("John Doe"), new Phone("61234568", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person afterJohnDoePhone = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        Person beforeJohnDoeEmail = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john123@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person afterJohnDoeEmail = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        Person beforeJohnDoeAddress = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395CDC Ben Road", false), new UniqueTagList());
        Person afterJohnDoeAddress = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        beforeEditNameBook = TestUtil.createAddressBook(beforeJohnDoeName);
        afterEditNameBook = TestUtil.createAddressBook(afterJohnDoeName);

        beforeEditPhoneBook = TestUtil.createAddressBook(beforeJohnDoePhone);
        afterEditPhoneBook = TestUtil.createAddressBook(afterJohnDoePhone);

        beforeEditEmailBook = TestUtil.createAddressBook(beforeJohnDoeEmail);
        afterEditEmailBook = TestUtil.createAddressBook(afterJohnDoeEmail);

        beforeEditAddressBook = TestUtil.createAddressBook(beforeJohnDoeAddress);
        afterEditAddressBook = TestUtil.createAddressBook(afterJohnDoeAddress);

        emptyDisplayList = TestUtil.createList();

    }

    @Test
    public void execute_name_edit_success(){
        EditCommand command = createEditCommand("Doe", "name", "John Doe", beforeEditNameBook, emptyDisplayList);
        assertCommandBehaviour(command, EditCommand.MESSAGE_SUCCESS, afterEditNameBook, beforeEditNameBook);
    }

    @Test
    public void execute_phone_edit_success(){
        EditCommand command = createEditCommand("John Doe", "phone", "61234567", beforeEditPhoneBook, emptyDisplayList);
        assertCommandBehaviour(command, EditCommand.MESSAGE_SUCCESS, afterEditPhoneBook, beforeEditPhoneBook);
    }

    @Test
    public void execute_email_edit_success(){
        EditCommand command = createEditCommand("John Doe", "email", "john@doe.com", beforeEditEmailBook, emptyDisplayList);
        assertCommandBehaviour(command, EditCommand.MESSAGE_SUCCESS, afterEditEmailBook, beforeEditEmailBook);
    }

    @Test
    public void execute_address_edit_success(){
        EditCommand command = createEditCommand("John Doe", "address", "395C Ben Road", beforeEditAddressBook, emptyDisplayList);
        assertCommandBehaviour(command, EditCommand.MESSAGE_SUCCESS, afterEditAddressBook, beforeEditAddressBook);
    }

    /**
     * Creates a new edit command.
     */
    private EditCommand createEditCommand(String editPerson, String property, String value, AddressBook addressbook, List<ReadOnlyPerson> displayList){
        EditCommand command = new EditCommand(editPerson, property, value);
        command.setData(addressbook, displayList);
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

}
