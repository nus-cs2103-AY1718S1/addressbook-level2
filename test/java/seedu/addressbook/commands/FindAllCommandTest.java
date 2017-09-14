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

public class FindAllCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindAllCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.amy));

        //same word, different case: not matched
        assertFindAllCommandBehavior(new String[]{"Amy"}, Arrays.asList(td.candy));

        //partial word: not matched
        assertFindAllCommandBehavior(new String[]{"my"}, Collections.emptyList());

        //multiple words: matched
        assertFindAllCommandBehavior(new String[]{"Amy", "Bill", "Candy", "Destiny"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindAllCommandBehavior(new String[]{"Amy", "Amy"}, Arrays.asList(td.amy));

        //Keyword matching a word in address: not matched
        assertFindAllCommandBehavior(new String[]{"Clementi"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindAllCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindAllCommand command = createFindAllCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindAllCommand createFindAllCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));

        /**
         * Convert all input set of keyword to lowerCase
         * Code adapted from:
         * https://stackoverflow.com/questions/2644637/how-to-lowercase-every-element-of-a-collection-efficiently
         */
        String[] tempKeywordSet = keywordSet.toArray(new String[0]);
        for (int i=0; i<tempKeywordSet.length; ++i)
        {
            tempKeywordSet[i] = tempKeywordSet[i].toLowerCase();
        }
        keywordSet.clear();
        keywordSet.addAll(Arrays.asList(tempKeywordSet));

        FindAllCommand command = new FindAllCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

    public static void replace(Set<String> strings)
    {
        String[] stringsArray = strings.toArray(new String[0]);
        for (int i=0; i<stringsArray.length; ++i)
        {
            stringsArray[i] = stringsArray[i].toLowerCase();
        }
        strings.clear();
        strings.addAll(Arrays.asList(stringsArray));
    }
}