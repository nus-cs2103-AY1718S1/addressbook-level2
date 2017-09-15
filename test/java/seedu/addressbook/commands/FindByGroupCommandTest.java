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


public class FindByGroupCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //Single match
        assertFindCommandBehavior(new String[]{"work"}, Arrays.asList(td.dan));

        //No matches
        assertFindCommandBehavior(new String[]{"home"}, Collections.emptyList());

        //Multiple matches, single keyword
        assertFindCommandBehavior(new String[]{"friends"}, Arrays.asList(td.amy, td.bill, td.candy));

        //multiple matches, multiple keywords
        assertFindCommandBehavior(new String[]{"friends", "work"},
                Arrays.asList(td.amy, td.bill, td.candy, td.dan));
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindByGroupCommand command = createFindCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindByGroupCommand createFindCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindByGroupCommand command = new FindByGroupCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}

