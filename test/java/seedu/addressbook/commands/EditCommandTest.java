package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EditCommandTest {
    private TypicalPersons td = new TypicalPersons();

    private AddressBook typicalAddressBook = td.getTypicalAddressBook();
    private AddressBook emptyAddressBook = TestUtil.createAddressBook();
    private List<ReadOnlyPerson> emptyPersonList = Collections.emptyList();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());
    private List<ReadOnlyPerson> listWithSomeTypicalPersons = Arrays.asList(td.amy, td.candy, td.dan);
    private String MESSAGE_PRIVATE_ERROR = "Only non-private information can be edited.";
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();
    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = "Edit details of a person.\n"
            + "Example: " + COMMAND_WORD + " INDEX p/[Value to change]";
    public static final String MESSAGE_SUCCESS = "Edited Person: %1$s";

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() throws IllegalValueException{
        // empty addressbook
        assertEditErrorInvalidIndex(emptyAddressBook, emptyPersonList, 1);

        // non-empty addressbook
        assertEditErrorInvalidIndex(typicalAddressBook, listWithAllTypicalPersons, -1);
        assertEditErrorInvalidIndex(typicalAddressBook, listWithAllTypicalPersons, 0);
        assertEditErrorInvalidIndex(typicalAddressBook, listWithAllTypicalPersons,
                listWithAllTypicalPersons.size() + 1);
    }

    @Test
    public void execute_personNotInAddressBook_returnsPersonNotInAddressBookMessage() throws Exception {
        // generate list with person not in addressbook, add to list
        ReadOnlyPerson stranger = new Person(new Name("me"),
                new Phone("123", true),
                new Email("some@hey.go", true),
                new Address("nus", false),
                new UniqueTagList(Collections.emptySet()));
        List<ReadOnlyPerson> listWithExtraPerson
                = new ArrayList<ReadOnlyPerson>(listWithAllTypicalPersons);
        listWithExtraPerson.add(stranger);

        // empty addressbook
        assertEditErrorPersonNotInAddressBook(emptyAddressBook, listWithExtraPerson, 1);

        // non-empty addressbook
        assertEditErrorPersonNotInAddressBook(typicalAddressBook, listWithExtraPerson,
                listWithExtraPerson.size());
    }

    @Test
    public void execute_validIndex_editPersonDetails() throws IllegalValueException{ //edit is only allowed for non-private details
        // person with no private information
        assertEditSuccess(typicalAddressBook, listWithAllTypicalPersons, 1);

//        // person with some private information
//        assertEditError(typicalAddressBook, listWithAllTypicalPersons, 2, MESSAGE_PRIVATE_ERROR);
//
//        // person with all private information
//        assertEditError(typicalAddressBook, listWithAllTypicalPersons, 4, MESSAGE_PRIVATE_ERROR);

        // Addressbook has more people than the list.
        // This can happen when a command causes the list to show only a sub-set of persons(e.g. FindCommand).
        assertEditSuccess(typicalAddressBook, listWithSomeTypicalPersons, 1);
    }


    /**
     * Asserts that the details of person at specific index cannot be retrieved due to
     * invalid index.
     */
    private void assertEditErrorInvalidIndex(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                             int targetVisibleIndex) throws IllegalValueException {
        assertEditError(addressBook, relevantPersons, targetVisibleIndex,
                Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    /**
     * Asserts that the details of person at specific index cannot be retrieved due to
     * person not existing in the addressbook.
     */
    private void assertEditErrorPersonNotInAddressBook(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                                       int targetVisibleIndex) throws IllegalValueException {
        assertEditError(addressBook, relevantPersons, targetVisibleIndex,
                Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    /**
     * Asserts that EditCommand can retrieve from
     * the {@code addressBook} details of the person at the given {@code targetVisibleIndex}
     * in the given {@code relevantPersons} list after editing.
     *
     * @param targetVisibleIndex one-indexed position of the target person in the list
     */
    private void assertEditSuccess(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                   int targetVisibleIndex) throws IllegalValueException  {
        // get person to be viewed (targetVisibleIndex - 1 because index is one-indexed)
        ReadOnlyPerson personToBeViewed = relevantPersons.get(targetVisibleIndex - 1);


        String expectedMessage = String.format(EditCommand.MESSAGE_SUCCESS,
                personToBeViewed.getAsTextHidePrivate());
        assertEditSuccessBehavior(new EditCommand(targetVisibleIndex, "1 n/John Doe"), addressBook, relevantPersons, expectedMessage);

//        expectedMessage = String.format(ViewAllCommand.MESSAGE_VIEW_PERSON_DETAILS,
//                personToBeViewed.getAsTextShowAll());
//        assertEditBehavior(new EditCommand(targetVisibleIndex), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Asserts that the EditCommand reports the given error for the given input.
     */
    private static void assertEditError(AddressBook addressBook, List<ReadOnlyPerson> relevantPersons,
                                        int targetVisibleIndex, String expectedMessage) throws IllegalValueException {
        assertEditBehavior(new EditCommand(targetVisibleIndex, "n/"), addressBook, relevantPersons, expectedMessage);
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that EditCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult it returns matches expectedMessage.
     * 2. The CommandResult it returns has no relevant persons.
     */
    private static void assertEditBehavior(Command editCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {

        editCommand.setData(addressBook, relevantPersons);
        CommandResult result = editCommand.execute();

        // feedback message is as expected and there are no relevant persons returned.
        assertEquals(expectedMessage, result.feedbackToUser);
    //    assertEquals(Optional.empty(), result.getRelevantPersons());
    }

    /**
     * Executes the test command for the given addressbook data.
     * Checks that EditCommand exhibits the correct command behavior, namely:
     * 1. The feedback message of the CommandResult does not match expectedMessage to see if it is edited.
     * 2. The CommandResult it returns has no relevant persons.
     */
    private static void assertEditSuccessBehavior(Command editCommand, AddressBook addressBook,
                                           List<ReadOnlyPerson> relevantPersons, String expectedMessage) {

        editCommand.setData(addressBook, relevantPersons);
        CommandResult result = editCommand.execute();

        // feedback message is as expected and there are no relevant persons returned.
        assertNotEquals(expectedMessage, result.feedbackToUser);
        //    assertEquals(Optional.empty(), result.getRelevantPersons());
    }
}
