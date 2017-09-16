package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.List;


import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook unsortedAddressBook = td.getUnsortedAddressBook();
    private List unsortedPersonsList = TestUtil.createList(td.bill, td.dan, td.candy, td.amy);

    @Test
    public void execute_sortCompleted_returnsAlphabeticalOrder() throws Exception {
        SortCommand sortTest = new SortCommand();
        sortTest.addressBook = unsortedAddressBook;
        assertListSorted(sortTest.addressBook);
    }

    private void assertListSorted (AddressBook unsortedAddressBook) {
        unsortedAddressBook.sort();
        assertEquals(td.getTypicalAddressBook(), unsortedAddressBook);
    }




}
