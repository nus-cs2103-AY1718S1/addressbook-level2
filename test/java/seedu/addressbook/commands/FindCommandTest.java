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
        //same word, same case: matched
        assertFindCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.amy));

        //same word, different case: not matched
        assertFindCommandBehavior(new String[]{"aMy"}, Collections.emptyList());

        //partial word: not matched
        assertFindCommandBehavior(new String[]{"my"}, Collections.emptyList());

        //multiple words: matched
        assertFindCommandBehavior(new String[]{"Amy", "Bill", "Candy", "Destiny"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(td.amy));

        //Keyword matching a word in 2 addresses, 1 public 1 private:  matched
        assertFindCommandBehavior(new String[]{"Clementi"}, Arrays.asList(td.amy));

        //Keyword is contained in 3 emails, all public:  matched
        assertFindCommandBehavior(new String[]{"@gmail"}, Arrays.asList(td.amy, td.bill, td.candy));

        //Keyword is contained in 1 email, which is private:  not matched
        assertFindCommandBehavior(new String[]{"ss@tt"}, Collections.emptyList());

        //Keyword matching 1 phone number that is public:  matched
        assertFindCommandBehavior(new String[]{"91119111"}, Arrays.asList(td.amy));

        //Keyword matching 1 phone number that is private:  not matched
        assertFindCommandBehavior(new String[]{"123456"}, Collections.emptyList());
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
