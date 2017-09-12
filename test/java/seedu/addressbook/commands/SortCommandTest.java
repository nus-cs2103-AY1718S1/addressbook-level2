package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.*;

public class SortCommandTest {

    private AddressBook addressBook;
    private List<ReadOnlyPerson> unsortedList;
    private List<ReadOnlyPerson> alphabeticalList;
    private List<ReadOnlyPerson> lengthList;
    private SortCommand alphabeticalSort;
    private SortCommand lengthSort;

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

        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        unsortedList = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        alphabeticalList = TestUtil.createList(davidGrant, janeDoe, johnDoe, samDoe);
        lengthList = TestUtil.createList(samDoe, johnDoe, janeDoe, davidGrant);

        alphabeticalSort = createSortCommand(0, addressBook, unsortedList);
        lengthSort = createSortCommand(1, addressBook, unsortedList);
    }

    /**
     * Creates a new sort command.
     *
     * @param sortingOption of choice
     */
    private SortCommand createSortCommand(int sortingOption, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) {

        SortCommand command = new SortCommand(sortingOption);
        command.setData(addressBook, displayList);

        return command;
    }

    private void assertCommandBehaviour(SortCommand sortCommand,
                                            List<ReadOnlyPerson> actualList, boolean supposedToBeTrue) {
        final CommandResult result = sortCommand.execute();
        if(supposedToBeTrue)
            assertEquals(result.getRelevantPersons().orElse(null), actualList);
        else
            assertNotEquals(result.getRelevantPersons().orElse(null), actualList);
    }

    @Test
    public void assertInAlphabeticalOrder() { assertCommandBehaviour(alphabeticalSort, alphabeticalList, true); }

    @Test
    public void assertInLengthOrder() {
        assertCommandBehaviour(lengthSort, lengthList, true);
    }

    @Test
    public void assetNotInAlphabeticalOrder() { assertCommandBehaviour(lengthSort, alphabeticalList, false); }
}