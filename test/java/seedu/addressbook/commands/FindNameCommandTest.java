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

public class FindNameCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindCommandBehavior("Amy", Arrays.asList(td.amy));

        //same word, different case: matched
        assertFindCommandBehavior("aMy", Arrays.asList(td.amy));

        //partial word: not matched
        assertFindCommandBehavior("my", Collections.emptyList());

        //multiple words: matched
        assertFindCommandBehavior("amy bill candy Destiny",
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindCommandBehavior("Amy Amy", Arrays.asList(td.amy));

        //Keyword matching a word in address: not matched
        assertFindCommandBehavior("Clementi", Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindNameCommand command = createFindNameCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindNameCommand createFindNameCommand(String keywords) {
        FindNameCommand command = new FindNameCommand(keywords);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
