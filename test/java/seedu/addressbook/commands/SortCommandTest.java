package seedu.addressbook.commands;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import java.util.*;

import org.junit.Before;
import org.junit.Test;


import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;


public class SortCommandTest {
    private AddressBook unsortedBook;
    private AddressBook sortedBookByName;
    private AddressBook sortedBookByPhone;
    private AddressBook sortedBookByEmail;

    @Before
    public void setUp() throws Exception {
        Person Alpha = new Person(new Name("Alpha"),
                new Phone("123456", false),
                new Email("alpha@gmail.com", false),
                new Address("123, Clementi Rd, #01-23", false),
                new UniqueTagList());

        Person Bravo = new Person(new Name("Beta"),
                new Phone("888888", false),
                new Email("beta@gmail.com", false),
                new Address("123, Tampines Rd, #01-23", false),
                new UniqueTagList());

        Person Charlie = new Person(new Name("Charlie"),
                new Phone("61234567", false),
                new Email("charlie@gmail.com", false),
                new Address("123, Bugis Rd, #01-23", false),
                new UniqueTagList());

        Person Delta = new Person(new Name("Delta"),
                new Phone("999", false),
                new Email("delta@gmail.com", false),
                new Address("123, Woodlands Rd, #01-25", false),
                new UniqueTagList());

        Person Echo = new Person(new Name("Echo"),
                new Phone("1234567", false),
                new Email("echo@gmail.com", false),
                new Address("123, Kent Ridge Rd, #01-24", false),
                new UniqueTagList());

        sortedBookByName = TestUtil.createAddressBook(Alpha, Bravo, Charlie, Delta, Echo);
        sortedBookByPhone = TestUtil.createAddressBook(Delta, Alpha, Bravo, Echo, Charlie);
        sortedBookByEmail = TestUtil.createAddressBook(Alpha, Bravo, Charlie, Delta, Echo);
        unsortedBook = TestUtil.createAddressBook(Echo, Delta, Charlie, Bravo, Alpha);

    }

    @Test
    public void sortAddressBookTest() {
        unsortedBook.sortByName();
        assertSorted(unsortedBook, sortedBookByName);

        unsortedBook.sortByPhone();
        assertSorted(unsortedBook, sortedBookByPhone);

        unsortedBook.sortByEmail();
        assertSorted(unsortedBook, sortedBookByEmail);
    }

    public void assertSorted(AddressBook actual, AddressBook expected) {
        assertEquals(actual, expected);
    }

}