package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithSomeTypicalPersons = Arrays.asList(td.amy, td.candy, td.dan);

    @Test
    public void execute_empty_addressbook_Message() {
        // empty addressbook
        assertViewErrorEmptyList(emptyAddressBook, emptyPersonList);
    }

    @Test
    public void execute_valid_addressbook_Message(){
        assertValidList(typicalAddressBook, listWithAllTypicalPersons);
    }

    private void assertValidList(AddressBook typicalAddressBook, List<ReadOnlyPerson> listWithAllTypicalPersons) {
        assertViewCorrect(typicalAddressBook, listWithAllTypicalPersons,
                String.format("Sorted successful for "+Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, listWithAllTypicalPersons.size()));
    }

    private void assertViewCorrect(AddressBook typicalAddressBook, List<ReadOnlyPerson> listWithAllTypicalPersons, String expectedMessage) {
        assertViewBehavior(new SortCommand(), typicalAddressBook, listWithAllTypicalPersons, expectedMessage);
    }

    private void assertViewErrorEmptyList(AddressBook emptyAddressBook, List<ReadOnlyPerson> emptyPersonList) {
        assertViewError(emptyAddressBook, emptyPersonList, "The addressbook is empty, you don't need to sort it!");
    }

    private void assertViewError(AddressBook emptyAddressBook, List<ReadOnlyPerson> emptyPersonList, String expectedMessage) {
        assertViewBehavior(new SortCommand(), emptyAddressBook, emptyPersonList, expectedMessage);
    }

    private static void assertViewBehavior(Command SortCommand,AddressBook emptyAddressBook, List<ReadOnlyPerson> emptyPersonList,
                                           String expectedMessage) {
        SortCommand.setData(emptyAddressBook,emptyPersonList);
        CommandResult result=SortCommand.execute();

        assertEquals(expectedMessage,result.feedbackToUser);
    }
}
