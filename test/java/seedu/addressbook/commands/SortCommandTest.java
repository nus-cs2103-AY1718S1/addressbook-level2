package seedu.addressbook.commands;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TypicalPersons;

public class SortCommandTest {

    private AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

    @Test
    public void execute() throws Exception {
        assertSortCommandBehavior(Arrays.asList(allPersons.get(0), allPersons.get(1), allPersons.get(2), allPersons.get(3)));

        addNewPerson(new Person(new Name("Abbie Tan"), new Phone("92345678",false), new Email("abbie@hotmail.com", false),
                     new Address("Alpha Tekong Street", false), new UniqueTagList(new Tag("Hello"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(0), allPersons.get(1), allPersons.get(2), allPersons.get(3)));

        addNewPerson(new Person(new Name("Benedict Kwah"), new Phone("97654321",false), new Email("ben@gmail.com", false),
                     new Address("Binny Besar Road", false), new UniqueTagList(new Tag("Lonely"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(2), allPersons.get(3)));

        addNewPerson(new Person(new Name("Charmine Lim"), new Phone("92344444",false), new Email("charlizard@gmail.com", false),
                     new Address("Jalan Charlie Avenue 2", false), new UniqueTagList(new Tag("Charliazard"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(2),
                                                allPersons.get(6), allPersons.get(3)));

        addNewPerson(new Person(new Name("Dickson Chua"), new Phone("85554444",false), new Email("dick@gmail.com", false),
                     new Address("Delta Avenue 2", false), new UniqueTagList(new Tag("Love"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(2),
                                                allPersons.get(6), allPersons.get(3), allPersons.get(7)));

        addNewPerson(new Person(new Name("Amelia Ong"), new Phone("85546667",false), new Email("AOng@gmail.com", false),
                     new Address("Woodlands Avenue 8", false), new UniqueTagList(new Tag("Dogs"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(8), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(2),
                                                allPersons.get(6), allPersons.get(3), allPersons.get(7)));

        addNewPerson(new Person(new Name("Winston Manhattan"), new Phone("85547757",false), new Email("mahattan@gmail.com", false),
                     new Address("Mahattan Street 15", false), new UniqueTagList(new Tag("Cats"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(8), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(2),
                                                allPersons.get(6), allPersons.get(3), allPersons.get(7), allPersons.get(9)));

        addNewPerson(new Person(new Name("Breanne Ting"), new Phone("91536962",false), new Email("breanneting@gmail.com", false),
                     new Address("Hillstone Street 1", false), new UniqueTagList(new Tag("Food"))));
        assertSortCommandBehavior(Arrays.asList(allPersons.get(4), allPersons.get(8), allPersons.get(0), allPersons.get(5), allPersons.get(1), allPersons.get(10),
                                                allPersons.get(2), allPersons.get(6), allPersons.get(3), allPersons.get(7), allPersons.get(9)));

    }

    public void addNewPerson(Person person) throws IllegalValueException {
        addressBook.addPerson(person);
        allPersons = addressBook.getAllPersons().immutableListView();
    }

    /**
     * Executes the sort command and verifies the sorted result
     * matches the persons in the expectedPersonList exactly.
     */
    public void assertSortCommandBehavior(List<ReadOnlyPerson> expectedPersonList) {
        SortCommand command = createSortCommand();
        CommandResult result = command.execute();

        assertEquals(expectedPersonList, result.getRelevantPersonsList());
        assertEquals(Command.getMessageForPersonSortedListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    public SortCommand createSortCommand() {
        SortCommand command = new SortCommand();
        command.setData(addressBook, Collections.emptyList());

        return command;
    }
}