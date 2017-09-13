package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;
    private AddressBook addressBookASCOrder;
    private AddressBook addressBookDSCOrder;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> ascDisplayList;
    private List<ReadOnlyPerson> dscDisplayList;

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
        addressBookASCOrder = TestUtil.createAddressBook(davidGrant,janeDoe,johnDoe,samDoe);
        addressBookDSCOrder = TestUtil.createAddressBook(samDoe,johnDoe,janeDoe,davidGrant);

        emptyDisplayList = TestUtil.createList();
        ascDisplayList = TestUtil.createList(davidGrant,janeDoe,johnDoe,samDoe);
        dscDisplayList = TestUtil.createList(samDoe,johnDoe,janeDoe,davidGrant);

    }

    @Test
    public void execute_sortASCWithoutPeople() throws Exception {
        // empty addressbook
        assertSortWithEmptyAddressBook(emptyAddressBook,emptyDisplayList,emptyDisplayList,"asc");
    }

    @Test
    public void execute_sortDSCWithoutPeople() throws Exception {
        // empty addressbook
        assertSortWithEmptyAddressBook(emptyAddressBook,emptyDisplayList,emptyDisplayList,"dsc");
    }

    @Test
    public void execute_sortASCWithPeople() throws Exception {
        // Filled addressbook
        assertSortWithAddressBook(addressBook,dscDisplayList,ascDisplayList,"asc");
    }

    @Test
    public void execute_sortDSCWithPeople() throws Exception {
        // Filled addressbook
        assertSortWithAddressBook(addressBook,ascDisplayList,dscDisplayList,"dsc");
    }

    /**
     * Asserts that the sort is able to be completed with an empty address book
     */
    private void assertSortWithEmptyAddressBook(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,List<ReadOnlyPerson> expectedList,
                                                String option){
        assertSortBehavior(new SortCommand(option),addressBook,relevantPersons,expectedList);
    }

    /**
     * Asserts that the sort is able to be completed with a non empty address book
     */
    private void assertSortWithAddressBook(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,List<ReadOnlyPerson> expectedList,
                                           String option){
        assertSortBehavior(new SortCommand(option),addressBook,relevantPersons,expectedList);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, List<ReadOnlyPerson> expectedList) {
        sortCommand.setData(addressBook, relevantPersons);
        CommandResult result = sortCommand.execute();

        assertEquals(expectedList, result.getRelevantPersons().get());
    }
}
