package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EditCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;

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

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        emptyDisplayList = TestUtil.createList();
        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);

    }


    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {
        assertEditFailsDueToInvalidIndex(0, "Joe", addressBook, listWithEveryone);
        assertEditFailsDueToInvalidIndex(-1, "Joe", addressBook, listWithEveryone);
        assertEditFailsDueToInvalidIndex(listWithEveryone.size() + 1, "Joe", addressBook, listWithEveryone);
    }

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertEditFailsDueToInvalidIndex(int invalidVisibleIndex, String targetName, AddressBook addressBook,
                                                  List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        EditCommand command = createEditCommand(invalidVisibleIndex, targetName, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    private EditCommand createEditCommand(int targetVisibleIndex, String targetName, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) {

        EditCommand command = new EditCommand(targetVisibleIndex, targetName);
        command.setData(addressBook, displayList);

        return command;
    }

}


