package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();
    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook addressBook;
    private AddressBook emptyAddressBook;

    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> displayList;


    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person annie = new Person(new Name("annie"), new Phone("91223367", false),
                new Email("annie@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, annie, davidGrant, samDoe);
        emptyDisplayList = TestUtil.createList();
    }

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertSortCommandBehavior(    );

    }
    /**
     * Asserts that the SortCommand reports the error.
     */
    private static void assertSortError(AddressBook addressBook, String expectedMessage) {
        assertSortCommandBehavior(new SortCommand(), addressBook);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The original addressbook data is not modified after executing SortCommand.
     */
    private static void assertSortCommandBehavior(Command sortCommand, AddressBook addressBook) {

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        List<ReadOnlyPerson> PersonList = addressBook.getAllPersons().immutableListView();

        sortCommand.setData(addressBook, PersonList);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected.
        assertEquals(Command.getMessageForPersonSortShownSummary(PersonList), result.feedbackToUser);

        // addressbook was not modified.
        assertEquals(expectedAddressBook.getAllPersons(), addressBook.getAllPersons());
    }


}

