package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.List;

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


public class SortCommandTest {

    private AddressBook addressBook;
    private List<ReadOnlyPerson> listInSortedOrder;
    private List<ReadOnlyPerson> emptyList;

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

        listInSortedOrder = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        emptyList = TestUtil.createList();

    }

    @Test
    public void execute() throws Exception {
        assertSortInRightOrder(this.addressBook, this.listInSortedOrder);
    }

    private void assertSortInRightOrder(AddressBook addressBook, List<ReadOnlyPerson> listInSortedOrder) {
        assertSortCommand(createSortCommand(addressBook), listInSortedOrder);
    }

    /**
     * Asserts if the sortCommand returns person in the order of expectedList.
     */
    private void assertSortCommand(SortCommand sortCommand, List<ReadOnlyPerson> expectedList) {
        CommandResult result = sortCommand.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(expectedList), result.feedbackToUser);
    }

    private SortCommand createSortCommand(AddressBook addressBook) {
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(addressBook, this.emptyList); // setting up list is not important for sort
        return sortCommand;
    }
}
