package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

public class TagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertTagCommandBehavior(new String[]{"Test"}, Arrays.asList(td.dan));

        //same word, different case: not matched
        assertTagCommandBehavior(new String[]{"test"}, Collections.emptyList());

        //partial word: not matched
         assertTagCommandBehavior(new String[]{"Tes"}, Collections.emptyList());

        //multiple words: matched
        assertTagCommandBehavior(new String[]{"Test" ,"Funny"},
                Arrays.asList(td.dan, td.bill));

        //repeated keywords: matched
        assertTagCommandBehavior(new String[]{"Test", "Test"}, Arrays.asList(td.dan));

        //Keyword matching a word in address: not matched
        assertTagCommandBehavior(new String[]{"Hello"}, Collections.emptyList());
    }

    /**
     * Executes the tag command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertTagCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        TagCommand command = createFindCommand(keywords);
        CommandResult result = command.execute();
        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private TagCommand createFindCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        TagCommand command = new TagCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }
}
