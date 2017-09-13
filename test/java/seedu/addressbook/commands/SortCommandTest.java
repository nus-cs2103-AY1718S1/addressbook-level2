package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

public class SortCommandTest {

    private  AddressBook emptyAddressBook ;
    private  AddressBook addressBookInOrder  ;
    private  AddressBook addressBookNoOrder ;

    private List<ReadOnlyPerson> emptyDisplayList ;
    private List<ReadOnlyPerson> listSorted;
    private List<ReadOnlyPerson> listUnsorted ;

    @Before
    public void setUp()throws Exception{
        Person aaron = new Person(new Name("Aaron"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person ben = new Person(new Name("Ben"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person cat = new Person(new Name("Cat"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person david = new Person(new Name("David"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook=TestUtil.createAddressBook();
        addressBookInOrder=TestUtil.createAddressBook(aaron,ben,cat,david);
        addressBookNoOrder=TestUtil.createAddressBook(david,cat,ben,aaron);

        emptyDisplayList=TestUtil.createList();
        listSorted=TestUtil.createList(aaron,ben,cat,david);
        listUnsorted=TestUtil.createList(david,cat,ben,aaron);
    }
    @Test
    public void execute_noPersonInAddressBookToSort_returnsAddressBookEmptyMessage() {
        SortCommand command = new SortCommand();
        command.setData(emptyAddressBook,emptyDisplayList);
        CommandResult result = command.execute();
        assertEquals(SortCommand.MESSAGE_LIST_EMPTY,result.feedbackToUser);
    }
    @Test
    public void  execute_filledAddressBook_addressBookIsSorted() {
        Command command = new SortCommand();
        command.setData(addressBookNoOrder,listUnsorted);
        CommandResult result = command.execute();
        assertEquals(SortCommand.MESSAGE_SUCCESS,result.feedbackToUser);
        assertEquals(true, (TestUtil.isIdentical(addressBookInOrder.getAllPersons(), addressBookNoOrder.getAllPersons())));
    }

}