package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SortCommandTest {

    private Command sortCommand;

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> originalList;
    private List<ReadOnlyPerson> ascendingList;
    private List<ReadOnlyPerson> descendingList;

    @Before
    public void setUp() throws Exception {
        Person alvin = new Person(new Name("Alvin Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person brandon = new Person(new Name("Brandon Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person jane = new Person(new Name("Jane Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person zoe = new Person(new Name("Zoe Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(alvin, brandon, jane, zoe);

        emptyDisplayList = TestUtil.createList();

        originalList = TestUtil.createList(alvin, brandon, jane, zoe);
        ascendingList = TestUtil.createList(alvin, brandon, jane, zoe);
        descendingList = TestUtil.createList(zoe, jane, brandon, alvin);
    }

    @Test
    public void execute() throws Exception {
        //empty list
        sortCommand = new SortCommand(1);
        sortCommand.setData(emptyAddressBook, emptyDisplayList);
        assertSortedList(emptyDisplayList);

        //descending list
        sortCommand = new SortCommand(-1);
        sortCommand.setData(addressBook, originalList);
        assertSortedList(descendingList);

        //ascending list
        sortCommand = new SortCommand(1);
        sortCommand.setData(addressBook, originalList);
        assertSortedList(ascendingList);
    }

    /**
     * Executes the sort command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertSortedList(List<ReadOnlyPerson> expectedPersonList) {
        CommandResult result = sortCommand.execute();

        List<? extends ReadOnlyPerson> sortedList = result.getRelevantPersons().get();
        assertEquals(sortedList, expectedPersonList);
    }
}
