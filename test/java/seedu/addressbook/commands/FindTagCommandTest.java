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
        assertFindTagCommandBehavior(new String[]{"Homework"}, Arrays.asList(td.eric));

        //same word, different case: not matched
        assertFindTagCommandBehavior(new String[]{"tEst"}, Collections.emptyList());

        //partial word: not matched
        assertFindTagCommandBehavior(new String[]{"es"}, Collections.emptyList());

        //multiple words: matched
        assertFindTagCommandBehavior(new String[]{"Test", "Homework"},
                Arrays.asList(td.dan, td.eric));

        //repeated keywords: matched
        assertFindTagCommandBehavior(new String[]{"Test", "Test"}, Arrays.asList(td.dan));

        //Keyword matching a word in address: not matched
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
