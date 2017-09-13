package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;


import java.util.List;

public class SortCommandTest {

    private Command sortCommand;


    private AddressBook addressBook;

    private List<ReadOnlyPerson> sortedList;
    private List<ReadOnlyPerson> unsortedList ;

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

        addressBook = TestUtil.createAddressBook(alvin, brandon, jane, zoe);


        sortedList = TestUtil.createList(alvin, brandon, jane, zoe);
        unsortedList = TestUtil.createList(zoe, jane, brandon, alvin);
    }

    @Test
    public void execute() throws Exception {


        //checking by sorting the unsorted list

        sortCommand = new SortCommand();
        sortCommand.setData(addressBook, sortedList);
        assertSortedList(unsortedList);
    }

    /**
     * Executes the sort command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertSortedList(List<ReadOnlyPerson> expectedPersonList) {
        CommandResult result = sortCommand.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }
}