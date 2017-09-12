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

public class FindEasilyCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons tdE = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy"}, Arrays.asList(tdE.amy));

        //same word, different case: matched
        assertFindEasilyCommandBehavior(new String[]{"aMy"}, Arrays.asList(tdE.amy));

        //partial word: not matched
        assertFindEasilyCommandBehavior(new String[]{"my"}, Collections.emptyList());

        //multiple words, same case: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy", "Bill", "Candy","Destiny"},
                Arrays.asList(tdE.amy, tdE.bill, tdE.candy));

        //multiple words, different case: matched
        assertFindEasilyCommandBehavior(new String[]{"AMy", "BiLl", "candy","DESTINY"},
                Arrays.asList(tdE.amy, tdE.bill, tdE.candy));

        //repeated keywords: matched
        assertFindEasilyCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(tdE.amy));

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

