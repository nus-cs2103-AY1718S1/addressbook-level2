package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FindPhoneCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //one digit, multiple match
        assertFindPhoneCommandBehavior(9, Arrays.asList(td.amy, td.bill, td.candy));
        //one digit, single match
        assertFindPhoneCommandBehavior(5, Arrays.asList(td.dan));
        //two digit, single match
        assertFindPhoneCommandBehavior(93, Arrays.asList(td.candy));
        //one digit, no match
        assertFindPhoneCommandBehavior(7, Collections.emptyList());
        //five digit, no match
        assertFindPhoneCommandBehavior(11119, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindPhoneCommandBehavior(int number, List<ReadOnlyPerson> expectedPersonList) {
        FindPhoneCommand command = createFindPhoneCommand(number);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindPhoneCommand createFindPhoneCommand(int number) {
        FindPhoneCommand command = new FindPhoneCommand(number);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
