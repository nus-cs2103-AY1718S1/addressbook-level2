package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;


import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> sortDisplayList;
    private List<ReadOnlyPerson> DisplayList;

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

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        emptyDisplayList = TestUtil.createList();
        DisplayList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        sortDisplayList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);

    }
    // case 1: empty list
    @Test
    public void execute_sortWithEmptyAddressBook() {
        assertSort(new SortCommand(), emptyAddressBook, emptyDisplayList, emptyDisplayList);
    }
    // case 2: filled list
    @Test
    public void execute_sortWithAddressBook() {
        assertSort(new SortCommand(), addressBook, DisplayList, sortDisplayList);
    }

    /**
     * Execute the SortCommand with related message
     * Check whether the result is expected
     */
    private void assertSort (Command SortCommand, AddressBook addressBook, List<ReadOnlyPerson> relatedList, List<ReadOnlyPerson> expectedList) {
        SortCommand.setData(addressBook, relatedList);
        CommandResult result = SortCommand.execute();

        assertEquals(expectedList, result.getRelevantPersons().get());
    }





}