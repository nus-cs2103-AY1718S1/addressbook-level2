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

public class PhoneCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same number: matched
        assertPhoneCommandBehavior(new String[]{"91119111"}, Arrays.asList(td.amy));

        //different number: not matched
        assertPhoneCommandBehavior(new String[]{"91119112"}, Collections.emptyList());

        //partial number: not matched
        assertPhoneCommandBehavior(new String[]{"9111911"}, Collections.emptyList());

        //multiple numbers: matched
        assertPhoneCommandBehavior(new String[]{"91119111", "92229222", "93339333", "00000000"},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated numbers: matched
        assertPhoneCommandBehavior(new String[]{"1234556", "1234556"}, Arrays.asList(td.dan));

        //Keyword matching a number in address: not matched
        assertPhoneCommandBehavior(new String[]{"3"}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertPhoneCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        PhoneCommand command = createPhoneCommand(keywords);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private PhoneCommand createPhoneCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        PhoneCommand command = new PhoneCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
