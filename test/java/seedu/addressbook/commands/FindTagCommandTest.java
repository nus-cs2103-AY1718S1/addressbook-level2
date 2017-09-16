package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class FindTagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindCommandBehavior(new String("Test"), Arrays.asList(td.dan));

        //same word, different case: not matched
        assertFindCommandBehavior(new String("test"), Collections.emptyList());

        //partial word: not matched
        assertFindCommandBehavior(new String("est"), Collections.emptyList());

    }

    /**
     * Executes the findtag command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String keyword, List<ReadOnlyPerson> expectedPersonList) {
        FindtagCommand command = createFindtagCommand(keyword);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindtagCommand createFindtagCommand(String keyword) {
        FindtagCommand command = new FindtagCommand(keyword);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
