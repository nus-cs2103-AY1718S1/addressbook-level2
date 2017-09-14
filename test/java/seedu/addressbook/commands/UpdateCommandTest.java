package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

        // Notice the offset of targetVisibleIndex is 1.
        UpdateCommand command = new UpdateCommand(1, "Amy Steven",
                null, false, null, false,
                null, false, Collections.emptySet());
        command.setData(addressBook, Arrays.asList(persons));
        command.execute();

        assertEquals("Amy Steven", firstPerson.getName().toString());
    }

    @Test
    public void updateCommand_updateTags_reflectTagSetChanges() throws Exception {
        Person firstPerson = persons[3];
        Set<String> new_tags = new HashSet<>();
        new_tags.add("another");

        // Notice the offset of targetVisibleIndex is 1.
        UpdateCommand command = new UpdateCommand(4, null,
                null, false, null, false,
                null, false, new_tags);
        command.setData(addressBook, Arrays.asList(persons));
        command.execute();

        assertEquals(2, firstPerson.getTags().toSet().size());
    }
}
