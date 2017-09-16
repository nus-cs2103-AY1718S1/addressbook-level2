package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private AddressBook addressBook;
    private List<ReadOnlyPerson> sortedList;
    private List<ReadOnlyPerson> originalList;

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
        sortedList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        originalList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);

    }

    @Test
    public void execute_sort_returns_sortedListToUser() {
        SortCommand command = createSortCommand(false); //boolean does not matter
        CommandResult result = command.execute();
        assertEquals(result.getRelevantPersons().get(), sortedList);
    }

    @Test
    public void execute_savedSort_returns_savedAddressBookOrdering() {
        SortCommand command = createSortCommand(true);
        command.execute();
        assertEquals(addressBook.getAllPersons().immutableListView(), sortedList);
    }

    @Test
    public void execute_unsavedSort_returns_unchangedAddressBookOrdering() {
        SortCommand command = createSortCommand(false);
        command.execute();
        assertEquals(addressBook.getAllPersons().immutableListView(), originalList);
    }

    private SortCommand createSortCommand(boolean isSavedSort) {
        SortCommand command = new SortCommand(isSavedSort);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }



}
