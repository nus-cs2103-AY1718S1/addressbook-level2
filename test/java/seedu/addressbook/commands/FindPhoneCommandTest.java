package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class FindPhoneCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        /* Single Search Term */
        //one digit, multiple match
        assertFindPhoneCommandBehavior(new String[] {"9"}, Arrays.asList(td.amy, td.bill, td.candy));
        //one digit, single match
        assertFindPhoneCommandBehavior(new String[] {"5"}, Arrays.asList(td.dan));
        //two digit, single match
        assertFindPhoneCommandBehavior(new String[] {"93"}, Arrays.asList(td.candy));
        //one digit, no match
        assertFindPhoneCommandBehavior(new String[] {"7"}, Collections.emptyList());
        //five digit, no match
        assertFindPhoneCommandBehavior(new String[] {"11119"}, Collections.emptyList());
        /* Multiple Inclusive Search Terms */
        //multiple match
        assertFindPhoneCommandBehavior(new String[] {"91", "933", "5"}, Arrays.asList(td.amy, td.candy, td.dan));
        //single match
        assertFindPhoneCommandBehavior(new String[] {"9111", "119", "191"}, Arrays.asList(td.amy));
        //no match
        assertFindPhoneCommandBehavior(new String[] {"7", "11119", "22229", "33339"}, Collections.emptyList());
        /* Multiple Inclusive and Exclusive Search Terms */
        //multiple match
        assertFindPhoneCommandBehavior(new String[] {"9", "-393"}, Arrays.asList(td.amy, td.bill));
        //single match
        assertFindPhoneCommandBehavior(new String[] {"9", "-33", "-191"}, Arrays.asList(td.bill));
        //no match
        assertFindPhoneCommandBehavior(new String[] {"911", "-9"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindPhoneCommandBehavior(String[] numbersString, List<ReadOnlyPerson> expectedPersonList) {
        FindPhoneCommand command = createFindPhoneCommand(numbersString);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindPhoneCommand createFindPhoneCommand(String[] numbersString) {
        FindPhoneCommand command = new FindPhoneCommand(numbersString);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
