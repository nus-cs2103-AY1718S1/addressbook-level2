package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

public class FindTagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindTagCommandBehavior(new String[] {"family"}, Arrays.asList(td.amy, td.candy));

        //same word, different case: matched
        assertFindTagCommandBehavior(new String[] {"Friends"}, Arrays.asList(td.bill, td.candy));

        //partial word: not matched
        assertFindTagCommandBehavior(new String[] {"fam"}, Collections.emptyList());

        //multiple words: matched
        assertFindTagCommandBehavior(new String[] {"family", "friends"}, Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindTagCommandBehavior(new String[] {"family", "family"}, Arrays.asList(td.amy, td.candy));

        //Keyword matching a word in address: not matched
        assertFindTagCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

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
