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

public class SortCommandTest {
    private AddressBook addressBook;
    private AddressBook emptyAddressBook;

    private List<ReadOnlyPerson> personList;
    private List<ReadOnlyPerson> emptyPersonList;
    private List<ReadOnlyPerson> expectedDisplayList;


    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person annie = new Person(new Name("Annie"), new Phone("91223367", false),
                new Email("annie@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, annie, davidGrant, samDoe);
        emptyPersonList = TestUtil.createList();

        personList = TestUtil.createList(johnDoe, annie, samDoe, davidGrant);
        expectedDisplayList = TestUtil.createList(annie, davidGrant, johnDoe, samDoe);
    }

    @Test
    public void execute() throws Exception {
        assertSortSuccess(addressBook, personList, expectedDisplayList);
        assertSortSuccess(emptyAddressBook, emptyPersonList, emptyPersonList);
    }


    /**
     *
     */
    private void assertSortSuccess(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                   List<ReadOnlyPerson> expectedDisplayList ) {
        SortCommand newCommand = new SortCommand();
        newCommand.setData(addressBook, relevantPersons);

        CommandResult result = newCommand.execute();
        List<? extends ReadOnlyPerson> displayedPersonList = result.getRelevantPersons().get();

        assertResultVerified(displayedPersonList, expectedDisplayList);
    }

    /**
     * Asserts that the actual displayed result is the same as expected result
     * by checking the order of the name.
     *
     * @param personsToBeViewed the actual sorted list of persons
     * @param expectedPersonsToBeViewed the expected sorted list of persons
     */
    private void assertResultVerified(List<? extends ReadOnlyPerson> personsToBeViewed,
                                      List<ReadOnlyPerson> expectedPersonsToBeViewed) {

        assertEquals(personsToBeViewed.size(), expectedPersonsToBeViewed.size());
        assertCheckOrderByNames(personsToBeViewed, expectedPersonsToBeViewed);
        assertSortCommandBehavior(new SortCommand(), addressBook);
    }


    /**
     * Asserts that the names in two person lists are in the same order.
     */
    private void assertCheckOrderByNames(List<? extends ReadOnlyPerson> personList1,
                                  List<ReadOnlyPerson> personList2) {
        for(int i = 0; i < personList1.size(); i++) {
            ReadOnlyPerson p1 = personList1.get(i);
            ReadOnlyPerson p2 = personList2.get(i);
            assertEquals(p1.getName(), p2.getName());
        }
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

