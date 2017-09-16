package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;
import java.util.Optional;

public class SortCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyList;
    private List<ReadOnlyPerson> personList;
    private List<ReadOnlyPerson> expectedSortedList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), new UniqueTagList());
        Person ann = new Person(new Name("Ann"), new Phone("91234567", false),
                new Email("ann@doe.com", false), new Address("33G Ohm Road", false), new UniqueTagList());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), new UniqueTagList());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                new UniqueTagList());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, ann, davidGrant, samDoe);

        emptyList = TestUtil.createList();
        personList = TestUtil.createList(johnDoe, ann, davidGrant, samDoe);
        expectedSortedList = TestUtil.createList(ann, davidGrant, johnDoe, samDoe);
    }



    @Test
    public void execute(){

        //sort empty list
        assertCommandBehavior(emptyAddressBook, emptyList, emptyList);

        //sort list
        assertCommandBehavior(addressBook, personList, expectedSortedList);


    }


    public void assertCommandBehavior(AddressBook addressBook, List<ReadOnlyPerson> unsortedList,
                                       List<ReadOnlyPerson> expectedList){

        CommandResult result = getCommandResult(addressBook,unsortedList);
        assertEquals(Command.getMessageForPersonListShownSummary(expectedList),result.feedbackToUser);
        Optional<List<? extends ReadOnlyPerson>> expected = Optional.of(expectedList);
        assertEquals(expected, result.getRelevantPersons());


    }

    private CommandResult getCommandResult(AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) {

        SortCommand command = new SortCommand();
        command.setData(addressBook,displayList);
        CommandResult result = command.execute();

        return result;
    }


}
