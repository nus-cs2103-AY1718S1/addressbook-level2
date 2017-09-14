package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.util.TypicalPersons;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();
    private final TypicalPersons tdUnsorted = new TypicalPersons();

    @Test
    public void execute() throws Exception {
        addressBook.removePerson(tdUnsorted.amy);
        addressBook.addPerson(tdUnsorted.amy);
        assertSortCommandBehavior(tdUnsorted);
        assertEquals(td.getTypicalAddressBook(), tdUnsorted.getTypicalAddressBook());
    }

    private void assertSortCommandBehavior(TypicalPersons tdUnsorted) {
     tdUnsorted.getTypicalAddressBook().sort();
    }

}