package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ModifyCommandTest {
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
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
    }

    @Test
    public void index_Out_of_Bounds_exception(){
        assert_Modify_failed_By_Invalid_Index(0, "p/123456",addressBook,listWithEveryone);
        assert_Modify_failed_By_Invalid_Index(-1, "a/china",addressBook, listWithEveryone);
        assert_Modify_failed_By_Invalid_Index(listWithEveryone.size()+1, "e/cekw123@gmail.com", addressBook, listWithEveryone);
    }

    @Test
    public void invalid_field_exception(){
        assert_modify_failed_By_invalid_field(1, "t/sfwef", addressBook, listWithEveryone);
    }

    @Test
    public void valid_info_test(){
        assert_Modify_success_By_valid_info(1, "p/123455", addressBook, listWithEveryone);
    }

    private void assert_Modify_success_By_valid_info(int person_idx, String args, AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        String expextedMessage="the information has been successfully changed!";
        ModifyCommand command=createModifyCommand(person_idx,args, addressBook, listWithEveryone);
        assertCommandBehavior(command,expextedMessage);
    }

    private void assert_modify_failed_By_invalid_field(int person_idx, String args, AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        String expectedMessage="Invalid input message, cannot change the desired person's information";
        ModifyCommand command=createModifyCommand(person_idx,args, addressBook, listWithEveryone);
        assertCommandBehavior(command, expectedMessage);
    }

    private void assert_Modify_failed_By_Invalid_Index(int person_idx, String args,AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        String expectedMessage="Invalid index, please enter valid index number!";
        ModifyCommand command=createModifyCommand(person_idx, args,addressBook,listWithEveryone);
        assertCommandBehavior(command,expectedMessage);
    }

    private ModifyCommand createModifyCommand(int person_idx, String args,AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        ModifyCommand command=new ModifyCommand(person_idx, args);
        command.setData(addressBook, listWithEveryone);

        return command;
    }

    private void assertCommandBehavior(ModifyCommand command, String expectedMessage) {
        CommandResult result=command.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
    }
}
