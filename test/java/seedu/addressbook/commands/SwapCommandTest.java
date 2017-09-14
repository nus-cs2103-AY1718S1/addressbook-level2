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


public class SwapCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        // Both case matched, swap
        assertSwapCommandBehavior(new String[]{"Amy", "Bill"},
                Arrays.asList(td.amy, td.bill));
    }

    private void assertSwapCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        SwapCommand command = createSwapCommand(keywords);
        HashSet<String> expected = new HashSet<>();
        expected.add("Bill");
        expected.add("Amy");
        assertEquals(expected, command.getKeywords());
    }

    private SwapCommand createSwapCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        SwapCommand command = new SwapCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
