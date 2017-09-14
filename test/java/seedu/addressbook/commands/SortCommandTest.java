package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class SortCommandTest {
    private AddressBook testAddressBook;
    private AddressBook sortedAddressBook;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        testAddressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe); //not sorted
        sortedAddressBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);
    }

    @Test
    public void isAddressBookSorted() throws Exception {
        assertNotSorted(testAddressBook);
        testAddressBook.sort();
        assertSorted(testAddressBook);
    }

    private void assertNotSorted(AddressBook testAddressBook) {
        assertNotEquals(testAddressBook, sortedAddressBook);
    }

    private void assertSorted(AddressBook testAddressBook) {
        assertEquals(testAddressBook, sortedAddressBook);
    }
}
