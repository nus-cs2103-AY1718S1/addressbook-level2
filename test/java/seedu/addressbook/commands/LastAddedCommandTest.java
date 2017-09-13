package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LastAddedCommandTest {
    private final AddressBook addressBook = new AddressBook();

    @Test
    public void lastAddedCommand_lastAddedPersonCorrectlyListed() throws Exception {
        Person p = TestUtil.generateTestPerson();
        addressBook.addPerson(p);
        List<ReadOnlyPerson> expectedPersonList = new ArrayList<>();
        expectedPersonList.add(p);
        LastAddedCommand command = new LastAddedCommand();
        command.setData(addressBook, Collections.emptyList());
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForLastAddedSummary(expectedPersonList), result.feedbackToUser);
    }

}
