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

public class FindCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case, public email: matched
        assertFindCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.amy));
        assertFindCommandBehavior(new String[]{"ab@gmail.com"}, Arrays.asList(td.amy));

        //same word, different case, public email: not matched
        assertFindCommandBehavior(new String[]{"aMy"}, Collections.emptyList());
        assertFindCommandBehavior(new String[]{"Ab@gMail.com"}, Collections.emptyList());

        //partial word, public email: not matched
        assertFindCommandBehavior(new String[]{"my"}, Collections.emptyList());
        assertFindCommandBehavior(new String[]{"ab@gmail"}, Collections.emptyList());

        //multiple words, public emails: matched
        assertFindCommandBehavior(new String[]{"Amy", "Bill", "Candy", "Destiny"},
                Arrays.asList(td.amy, td.bill, td.candy));
        assertFindCommandBehavior(new String[]{"ab@gmail.com", "bc@gmail.com", "cd@gmail.com"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords, public email: matched
        assertFindCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(td.amy));
        assertFindCommandBehavior(new String[]{"ab@gmail.com", "ab@gmail.com"}, Arrays.asList(td.amy));

        //private email: not matched
        assertFindCommandBehavior(new String[]{"ss@tt.com"}, Collections.emptyList());
        assertFindCommandBehavior(new String[]{"sS@tt.com"}, Collections.emptyList());
        assertFindCommandBehavior(new String[]{"ss@tt"}, Collections.emptyList());
        assertFindCommandBehavior(new String[]{"ss@tt.com", "ab@gmail.com"}, Arrays.asList(td.amy));
        assertFindCommandBehavior(new String[]{"ss@tt.com", "ss@tt.com"}, Collections.emptyList());

        //Keyword matching a word in address: not matched
        assertFindCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindCommand command = createFindCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindCommand createFindCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindCommand command = new FindCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
