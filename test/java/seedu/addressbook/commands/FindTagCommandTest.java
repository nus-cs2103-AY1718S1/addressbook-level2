package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.commands.Command;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.commands.FindCommand;
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
        assertFindTagCommandBehavior(new String[]{"Test"}, Arrays.asList(td.dan));

        //same word, different case: not matched
        assertFindTagCommandBehavior(new String[]{"test"}, Collections.emptyList());

        //partial word: not matched
        assertFindTagCommandBehavior(new String[]{"Tes"}, Collections.emptyList());

        //multiple tags: matched
        assertFindTagCommandBehavior(new String[]{"Carrot", "Test"},
                Arrays.asList(td.amy, td.bill, td.dan));

        //repeated tags: matched
        assertFindTagCommandBehavior(new String[]{"Test", "Test"}, Arrays.asList(td.dan));

        //Tag matching a word in address: not matched
        assertFindTagCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindTagCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindTagCommand command = createFindTagCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindTagCommand createFindTagCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindTagCommand command = new FindTagCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
