package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertTagCommandBehavior(new String[]{"Family"}, Arrays.asList(td.bill));

        //same word, different case: not matched
        assertTagCommandBehavior(new String[]{"test"}, Collections.emptyList());

        //partial word: not matched
        assertTagCommandBehavior(new String[]{"est"}, Collections.emptyList());

        //multiple words: matched
        assertTagCommandBehavior(new String[]{"Test", "Family"},
                Arrays.asList(td.bill, td.candy, td.dan));

        //repeated keywords: matched
        assertTagCommandBehavior(new String[]{"Family", "Family"}, Arrays.asList(td.bill));

        //Keyword matching a word in address: not matched
        assertTagCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertTagCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        TagCommand command = createTagCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private TagCommand createTagCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        TagCommand command = new TagCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
