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

public class FindCommandEasilyTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.amy));

        //same word, different case: matched
        assertFindEasilyCommandBehavior(new String[]{"aMy"}, Collections.emptyList());

        //partial word: not matched
        assertFindEasilyCommandBehavior(new String[]{"my"}, Collections.emptyList());

        //multiple words: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy", "Bill", "Candy", "Destiny"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(td.amy));

        //Keyword matching a word in address: not matched
        assertFindEasilyCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindEasilyCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindEasilyCommand command = createFindEasilyCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindEasilyCommand createFindEasilyCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindEasilyCommand command = new FindEasilyCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}

