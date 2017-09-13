package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;


public class SortCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    //private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    //private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> alphabeticalList = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> jumbledList = Arrays.asList(td.amy, td.dan, td.candy, td.bill);


    @Test
    //Checks if list is sorted in alphabetical order of names
    public void entriesInAlphabeticalOrder(List<ReadOnlyPerson> jumbledList) {

        SortCommand command = new SortCommand();
        CommandResult result = command.execute();
        assertEquals(alphabeticalList, result);

    }
}
