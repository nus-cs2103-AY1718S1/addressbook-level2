package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;

import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithAllTypicalPersonsUnsorted = Arrays.asList(td.getTypicalPersonsUnsorted());

    @Test
    public void sortAnEmptyList() {
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(emptyAddressBook, emptyPersonList);
        CommandResult result = sortCommand.execute();
        String expectedMessage = "0 persons listed!";
        assertEquals(expectedMessage, result.feedbackToUser);
    }

    @Test
    public void sortNonEmptyList() {
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(typicalAddressBook, listWithAllTypicalPersons);
        CommandResult expectedResult = sortCommand.execute();

        sortCommand.setData(typicalAddressBook, listWithAllTypicalPersonsUnsorted);
        CommandResult result = sortCommand.execute();
        assertEquals(expectedResult.feedbackToUser , result.feedbackToUser);
    }
}