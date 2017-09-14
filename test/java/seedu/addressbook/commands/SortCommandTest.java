package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
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
    private AddressBook sortedAddressBook;

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
        sortedAddressBook = TestUtil.createAddressBook(ballyGrant, daneDoe, johnDoe, samDoe);
        newListWithEveryone = TestUtil.createList(johnDoe, daneDoe, ballyGrant, samDoe);
    }

    @Test
    public void execute() throws Exception {

        SortCommand command = new SortCommand();
        command.setData(newAddressBook, newListWithEveryone);


        assertUnsorted(newAddressBook, newListWithEveryone);

        CommandResult result = command.execute();

        List<? extends ReadOnlyPerson> sortedList = result.getRelevantPersons().get();

        assertSortSuccessful(newAddressBook,sortedList);

        //check whether newAddressBook is actually sorted by comparing it with sortedAddressBook
        assertEquals(newAddressBook,sortedAddressBook);
        
    }

    /**
     * Asserts that the people listed in the addressBook is not alphabetically sorted.
     */
    private void assertUnsorted(AddressBook addressBook, List<ReadOnlyPerson> displayList) {
        assertFalse(isAddressBookSorted(addressBook,displayList));
    }

    /**
     * Asserts that the people listed in the addressBook is alphabetically sorted.
     */
    private void assertSortSuccessful(AddressBook addressBook, List<? extends ReadOnlyPerson> displayList){
        assertTrue(isAddressBookSorted(addressBook,displayList));
    }

    /**
     * Help method to check whether the people listed in the addressBook is
     * alphabetically sorted or not.
     */
    private boolean isAddressBookSorted(AddressBook addressBook, List<? extends ReadOnlyPerson> displayList){
        for(int i = 0; i < displayList.size() - 1; i++){
            ReadOnlyPerson person1 = displayList.get(i);
            ReadOnlyPerson person2 = displayList.get(i+1);

            assertTrue(addressBook.containsPerson(person1));
            assertTrue(addressBook.containsPerson(person2));

            if (compareNamesAlphabetically(person1, person2)) return false;
        }
        return true;
    }

    /**
     * Help method to check whether person1 at index i and person2 at index i+1
     * of the addressBook is alphabetically sorted or not.
     */
    private boolean compareNamesAlphabetically(ReadOnlyPerson person1, ReadOnlyPerson person2) {
        String name1 = person1.getName().toString();
        String name2 = person2.getName().toString();

        int compare = name1.compareTo(name2);
        if (compare > 0) {
            return true;
        }
        return false;
    }
}
