package seedu.addressbook.commands;

import org.junit.Before;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.util.TypicalPersons;

public class UpdateCommandTest {
    private TypicalPersons td;
    private AddressBook addressBook;
    private Person[] persons;

    @Before
    public void setUp() {
        td = new TypicalPersons();
        addressBook = td.getTypicalAddressBook();
        persons = td.getTypicalPersons();
    }
}
