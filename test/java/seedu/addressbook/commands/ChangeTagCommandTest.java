package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ChangeTagCommandTest {

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
    public void execute_validIndex_personTagIsChanged() throws PersonNotFoundException, IllegalValueException {
        String[] tags = {"Tag1", "Tag2"};
        assertChangeTagSuccessful(1, addressBook, listWithSurnameDoe, new HashSet<String>(Arrays.asList(tags)));

    }

    /**
     * Asserts that the person at the specified index can be successfully modified.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws PersonNotFoundException if the selected person is not in the address book
     */
    private void assertChangeTagSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList, Set<String> newTags) throws PersonNotFoundException, IllegalValueException {

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);

        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : newTags) {
            tagSet.add(new Tag(tagName));
        }
        Person toAdd = new Person(
                new Name(targetPerson.getName().toString()),
                new Phone(targetPerson.getPhone().toString(), targetPerson.isPhonePrivate()),
                new Email(targetPerson.getEmail().toString(), targetPerson.isEmailPrivate()),
                new Address(targetPerson.getAddress().toString(), targetPerson.isAddressPrivate()),
                new UniqueTagList(tagSet)
        );

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        expectedAddressBook.removePerson(targetPerson);
        expectedAddressBook.addPerson(toAdd);

        String expectedMessage = String.format(ChangeTagCommand.MESSAGE_SUCCESS, toAdd.getAsTextHidePrivate());

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        ChangeTagCommand command = createChangeTagCommand(targetVisibleIndex, actualAddressBook, displayList, newTags);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(ChangeTagCommand changeTagCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) throws IllegalValueException {

        CommandResult result = changeTagCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Creates a changeTag command.
     *
     * @param targetVisibleIndex of the person that we want to delete
     */
    private ChangeTagCommand createChangeTagCommand(int targetVisibleIndex, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList, Set<String> newTags) {

        ChangeTagCommand command = new ChangeTagCommand(targetVisibleIndex, newTags);
        command.setData(addressBook, displayList);

        return command;
    }
}
