package seedu.addressbook.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
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

    private AddressBook newAddressBook;

    private List<ReadOnlyPerson> newListWithEveryone;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person daneDoe = new Person(new Name("Dane Doe"), new Phone("91234567", false),
                new Email("dane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person ballyGrant = new Person(new Name("Bally Grant"), new Phone("61121122", false),
                new Email("bally@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        newAddressBook = TestUtil.createAddressBook(johnDoe, daneDoe, ballyGrant, samDoe);
        newListWithEveryone = TestUtil.createList(johnDoe, daneDoe, ballyGrant, samDoe);
    }

    @Test
    public void execute() throws Exception {

        SortCommand command = new SortCommand();
        command.setData(newAddressBook, newListWithEveryone);

        //checks list to be unsorted.
        assertUnsorted(newAddressBook, newListWithEveryone);

        CommandResult result = command.execute();

        List<? extends ReadOnlyPerson> sortedList = result.getRelevantPersons().get();

        //checks the list to be sorted
        assertSortSuccessful(newAddressBook,sortedList);
        
    }

    private void assertUnsorted(AddressBook addressBook, List<ReadOnlyPerson> displayList) {
        assertFalse(isAddressBookSorted(addressBook,displayList));
    }

    private void assertSortSuccessful(AddressBook addressBook, List<? extends ReadOnlyPerson> displayList){
        assertTrue(isAddressBookSorted(addressBook,displayList));
    }

    private boolean isAddressBookSorted(AddressBook addressBook, List<? extends ReadOnlyPerson> displayList){
        for(int i = 0; i < displayList.size() - 1; i++){
            ReadOnlyPerson person1 = displayList.get(i);
            ReadOnlyPerson person2 = displayList.get(i+1);

            assertTrue(addressBook.containsPerson(person1));
            assertTrue(addressBook.containsPerson(person2));

            if (compareNamesAlphbetically(person1, person2)) return false;
        }
        return true;
    }

    private boolean compareNamesAlphbetically(ReadOnlyPerson person1, ReadOnlyPerson person2) {
        String name1 = person1.getName().toString();
        String name2 = person2.getName().toString();

        int compare = name1.compareTo(name2);
        if (compare > 0) {
            return true;
        }
        return false;
    }
}
