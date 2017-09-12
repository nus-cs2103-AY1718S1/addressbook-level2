package seedu.addressbook.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.commands.SortCommand;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

public class SortCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSortedPeople;

    private SortCommand newSortCommand;
    private SortCommand newSortCommandEmpty;

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

        emptyList = TestUtil.createList();
        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSortedPeople = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);

        newSortCommand = createSortCommand(addressBook, listWithEveryone);
        newSortCommandEmpty = createSortCommand(emptyAddressBook, emptyList);
    }

    @Test
    public void testSortExecuteWithNonEmptyBook() {
        CommandResult sortedCommandResult = newSortCommand.execute();
        Assert.assertEquals(listWithSortedPeople, sortedCommandResult.getRelevantPersons().get());
    }

    @Test
    public void testSortExecuteWithEmptyBook() {
        CommandResult sortedCommandResult = newSortCommandEmpty.execute();
        Assert.assertEquals(emptyList, sortedCommandResult.getRelevantPersons().get());
    }

    public static SortCommand createSortCommand(AddressBook addressbook, List<ReadOnlyPerson> listWithEveryone) {
        SortCommand newCreatedCommand = new SortCommand();
        newCreatedCommand.setData(addressbook, listWithEveryone);
        return newCreatedCommand;
    }


}
