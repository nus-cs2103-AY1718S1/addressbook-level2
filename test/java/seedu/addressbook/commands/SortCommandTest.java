
package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.Collections;
import java.util.List;

public class SortCommandTest {


    private AddressBook addressBook;

    private List<ReadOnlyPerson> sortedList;

    @Before
    public void setup() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());


        sortedList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
    }

    @Test
    public void executeSortCommandBehaviour() {
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());
        CommandResult result = command.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(sortedList), result.feedbackToUser);

    }

}
