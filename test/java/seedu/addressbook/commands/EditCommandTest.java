package seedu.addressbook.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.util.TestUtil;

import java.util.HashMap;
import java.util.List;

public class EditCommandTest {

    private AddressBook addressBook;

    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listAfterEdit;
    private HashMap<String, String> updateValuesHashMap;
    private HashMap<String, String> invalidUpdateValuesHashMap;
    private int targetVisibleIndexToEdit = 1;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());
        Person johnDoeEdited = new Person (new Name("Johnie Doe"), new Phone("61234561", false),
                new Email("johnie@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        listAfterEdit = TestUtil.createList(janeDoe, davidGrant, samDoe, johnDoeEdited);
        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);

        updateValuesHashMap = new HashMap<>();
        updateValuesHashMap.put("n", "Johnie Doe");
        updateValuesHashMap.put("p", "61234561");
        updateValuesHashMap.put("e", "johnie@doe.com");

        invalidUpdateValuesHashMap = new HashMap<>();
        invalidUpdateValuesHashMap.put("a/", "XXX");

    }

    @Test
    public void testExecuteEdit() throws IllegalValueException {
        EditCommand validEditCommand = createEditCommand(targetVisibleIndexToEdit, updateValuesHashMap,
                addressBook, listWithEveryone);
        CommandResult validEditResult = validEditCommand.execute();
        Assert.assertEquals(listAfterEdit, validEditResult.getRelevantPersons().get());
    }

    @Test
    public void testInvalidEditValue() throws IllegalValueException {
        EditCommand invalidEditCommand = createEditCommand(targetVisibleIndexToEdit, updateValuesHashMap,
                addressBook, listWithEveryone);
        try {
            invalidEditCommand.execute();
        } catch (IllegalValueException e) {
            return ;
        }
    }

    public static EditCommand createEditCommand(int targetVisibleIndexToEdit, HashMap<String, String> updateValuesHashMap,
                                         AddressBook addressBook, List<ReadOnlyPerson> listWithEveryone) {
        EditCommand newEditCommand = new EditCommand(targetVisibleIndexToEdit, updateValuesHashMap);
        newEditCommand.setData(addressBook, listWithEveryone);
        return newEditCommand;
    }

}
