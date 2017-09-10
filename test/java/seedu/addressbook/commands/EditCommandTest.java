package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.*;

public class EditCommandTest {

    private AddressBook EditedAddressBook;
    private AddressBook addressBook;
    private String CommandString = "1 p/999";
    private List<ReadOnlyPerson> listWithEveryone;
    private String MESSAGE_SUCCESS = "SUCCESSFULLY EDITED PHONE";


    @Before
    public void SetUp() throws Exception {
        Person john = new Person(new Name("John Doe"), new Phone("91172232", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person jane = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person johnEdited = new Person(new Name("John Doe"), new Phone("999", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        EditedAddressBook = TestUtil.createAddressBook(johnEdited, jane);
        addressBook = TestUtil.createAddressBook(john, jane);
        listWithEveryone = TestUtil.createList(john, jane);

    }
    //JUNIT TEST WITH PHONE ONLY

    @Test
    public void testEdit() throws Exception {
        assertsEditSuccess(CommandString, addressBook, EditedAddressBook, listWithEveryone);
    }
    @Test
    public void testEditMessage() throws Exception{
        assertsEditMessage(CommandString, addressBook, EditedAddressBook, listWithEveryone);
    }

    public EditCommand createEditCommand(String CommandString, AddressBook addressBook, List<ReadOnlyPerson> displayList){
        EditCommand command = new EditCommand(CommandString);
        command.setData(addressBook, displayList);
        return command;
    }

    public void assertsEditSuccess(String CommandString, AddressBook addressbook, AddressBook editedAddressBook,
                                   List<ReadOnlyPerson> displayList){
        EditCommand command = createEditCommand(CommandString, addressbook, displayList);
        command.execute();
        assertEquals(addressbook, editedAddressBook);
    }
    public void assertsEditMessage(String CommandString, AddressBook addressbook, AddressBook editedAddressBook,
                                   List<ReadOnlyPerson> displayList){
        EditCommand command = createEditCommand(CommandString, addressbook, displayList);
        CommandResult result = command.execute();
        assertEquals(result.feedbackToUser, MESSAGE_SUCCESS);
    }

}