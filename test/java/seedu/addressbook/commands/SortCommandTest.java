package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;

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

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void execute_invalidParams() {
        // check for invalid params
        assertSortError(addressBook, listWithEveryone, " weeeee", "No such sort");

    }


    /**
     * Executes the sort command for the given params and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertSortCommandBehavior(String sorting, AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        SortCommand command = createSortCommand(sorting, addressBook);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(listWithEveryone), result.feedbackToUser);
    }

    /**
     * Asserts that the Sortcommand reports the given error for the given input.
     */
    private static void assertSortError(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                        String params, String expectedMessage) {
        assertSortBehavior(new SortCommand(params), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Creates a new sort command.
     *
     * @param sorting of the order we want to sort
     */
    private SortCommand createSortCommand(String sorting, AddressBook addressBook
                                             ) {

        SortCommand command = new SortCommand(sorting);
        command.setData(addressBook, Collections.emptyList());

        return command;
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that SortCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The CommandResult it returns has no relevant persons.
     * 3. The original addressbook data is modified after executing SortCommand.
     */
    private static void assertSortBehavior(Command sortCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);

        sortCommand.setData(addressBook, relevantPersons);
        CommandResult result = sortCommand.execute();

        // feedback message is as expected and there are no relevant persons returned.
        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(Optional.empty(), result.getRelevantPersons());

    }

}