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

public class FindEmailCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindEmailCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.amy));

        //same word, different case: not matched
        assertFindEmailCommandBehavior(new String[]{"aMy"}, Collections.emptyList());

        //partial word: not matched
        assertFindEmailCommandBehavior(new String[]{"my"}, Collections.emptyList());

        //multiple words: matched
        assertFindEmailCommandBehavior(new String[]{"Amy", "Bill", "Candy", "Destiny"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindEmailCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(td.amy));

        //Keyword matching a word in address: not matched
        assertFindEmailCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindEmailCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindEmailCommand command = createFindEmailCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindEmailCommand createFindEmailCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindEmailCommand command = new FindEmailCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
