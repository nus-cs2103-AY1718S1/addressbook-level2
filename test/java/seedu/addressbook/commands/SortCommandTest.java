package seedu.addressbook.commands;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.commands.*;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortCommandTest  {

    private AddressBook addressBook;
    private AddressBook SortedAddressBook;


    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> SortedListWithEveryone;

    private SortCommand commandForSort = new SortCommand();
    private ListCommand commandForCheck = new ListCommand();

    public void setup() throws Exception {

        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false), new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        /* The addressBook which stores the values without an order */
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        /* list of people */
        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);

        commandForSort.setData(addressBook, listWithEveryone);

        /* A new addressBook which stores the people with an order. */
        SortedAddressBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);
        SortedListWithEveryone = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);

        commandForCheck.setData(SortedAddressBook, SortedListWithEveryone);

    }

    /* To test whether the sortCommand sorts people correctly and gives the correct feedback

    */
    @Test
    public void AssertCorrectSort ()throws Exception {
        setup();
        CommandResult getExecuteResult = commandForSort.execute();
        CommandResult toCompare = commandForCheck.execute();
        assertEquals(getExecuteResult.feedbackToUser, toCompare.feedbackToUser);

    }

}
