package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook addressBook;
    private List<? extends ReadOnlyPerson> addressBookEntries;

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

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        addressBookEntries = TestUtil.createList(johnDoe, janeDoe, samDoe, davidGrant);
    }

    /*
        Asserts that the Sort Command is able to sort the address book entries by lexographical order of name
     */
    @Test
    public void testSortByName() {
        SortCommand sorter = new SortCommand();
        sorter.setData(addressBook,addressBookEntries);
        CommandResult result = sorter.execute();
        Optional<List<? extends ReadOnlyPerson>> resultContainer = result.getRelevantPersons();
        assertTrue(resultContainer.isPresent());
        List<? extends ReadOnlyPerson> actualList = resultContainer.get();
        List<? extends ReadOnlyPerson> sortedList = new ArrayList<>(actualList);
        sortedList.sort(ReadOnlyPerson.compareByName);
        assertEquals(sortedList,actualList);
    }
}