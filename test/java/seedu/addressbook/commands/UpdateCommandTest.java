package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UpdateCommandTest {
    private AddressBook addressBook;
    private Person[] persons;

    @Before
    public void setUp() {
        TypicalPersons td = new TypicalPersons();
        addressBook = td.getTypicalAddressBook();
        persons = td.getTypicalPersons();
    }

    @Test
    public void updateCommand_updateName_reflectChanges() throws Exception {
        Person firstPerson = persons[0];
        UpdateCommand command = new UpdateCommand(1, "Amy Steven",
                null, false, null, false,
                null, false, Collections.emptySet());
        command.setData(addressBook, Arrays.asList(persons));
        command.execute();
        assertEquals("Amy Steven", firstPerson.getName().toString());
    }
}
