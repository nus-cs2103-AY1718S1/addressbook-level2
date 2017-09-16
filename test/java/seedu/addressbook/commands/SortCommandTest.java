package seedu.addressbook.commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;
import java.util.List;


public class SortCommandTest {

    private AddressBook initialAddressBook;
    private AddressBook sortedAddressBook;

    private List<ReadOnlyPerson> sortedDisplayList;


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

        initialAddressBook = TestUtil.createAddressBook(johnDoe, janeDoe, samDoe, davidGrant);
        sortedAddressBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);

        sortedDisplayList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
    }

    @Test
    public void execute() throws Exception {

        SortCommand command = createSortCommand();
        assertCommandBehaviour(command,
                command.MESSAGE_SUCCESS + command.getMessageForPersonListShownSummary(sortedDisplayList),
                 initialAddressBook, sortedAddressBook);

    }

    private void assertCommandBehaviour(SortCommand sortCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = sortCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    private SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(initialAddressBook, Collections.emptyList());

        return command;
    }
}