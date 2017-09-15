package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook unsortedAddressBook = td.getUnsortedAddressBook();

    @Test
    public void execute_sortCompleted_returnsAlphabeticalOrder() throws Exception {
        assertListSorted(unsortedAddressBook);
    }

    private void assertListSorted (AddressBook unsortedAddressBook) {
        unsortedAddressBook.sort();
        assertEquals(td.getTypicalAddressBook(), unsortedAddressBook);
    }




}
