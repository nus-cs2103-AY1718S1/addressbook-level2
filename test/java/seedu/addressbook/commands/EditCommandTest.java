package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.*;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class EditCommandTest {
	private static final Set<String> EMPTY_STRING_LIST = Collections.emptySet();

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

		addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

		emptyDisplayList = TestUtil.createList();

		listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
		listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
	}

	@Test
	public void execute_invalidIndex_returnsInvalidIndexMessage() {
		assertEditFailsDueToInvalidIndex(0, Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, listWithEveryone);
		assertEditFailsDueToInvalidIndex(-1, Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, listWithEveryone);
		assertEditFailsDueToInvalidIndex(listWithEveryone.size() + 1, Name.EXAMPLE,
				Phone.EXAMPLE, true, Email.EXAMPLE, false, Address.EXAMPLE,
				true, EMPTY_STRING_LIST, addressBook, listWithEveryone);
		assertEditFailsDueToInvalidIndex(1, Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, emptyDisplayList);
	}

	@Test
	public void editCommand_invalidName_throwsException() {
		final String[] invalidNames = { "", " ", "[]\\[;]" };
		for (String name : invalidNames) {
			assertConstructingInvalidEditCmdThrowsException(1, name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
					Address.EXAMPLE, true, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidPhone_throwsException() {
		final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
		for (String number : invalidNumbers) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, number, false, Email.EXAMPLE, true,
					Address.EXAMPLE, false, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidEmail_throwsException() {
		final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
				"@invalid@email", "invalid@email!", "!invalid@email" };
		for (String email : invalidEmails) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
					Address.EXAMPLE, false, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidAddress_throwsException() {
		final String[] invalidAddresses = { "", " " };
		for (String address : invalidAddresses) {
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
					true, address, true, EMPTY_STRING_LIST);
		}
	}

	@Test
	public void addCommand_invalidTags_throwsException() {
		final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
				{ "", " " } };
		for (String[] tags : invalidTags) {
			Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
			assertConstructingInvalidEditCmdThrowsException(1, Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
					true, Address.EXAMPLE, false, tagsToAdd);
		}
	}

	@Test
	public void execute_validInput_personIsEdited() throws IllegalValueException {
		assertEditSuccessful(1, Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, listWithSurnameDoe);
		assertEditSuccessful(listWithSurnameDoe.size(), Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, listWithSurnameDoe);
		int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
		assertEditSuccessful(middleIndex, Name.EXAMPLE, Phone.EXAMPLE, true,
				Email.EXAMPLE, false, Address.EXAMPLE, true, EMPTY_STRING_LIST,
				addressBook, listWithSurnameDoe);
	}

	/**
	 * Asserts that the index is not valid for the given display list.
	 */
	private void assertEditFailsDueToInvalidIndex(int targetVisibleIndex,
												  String name,
												  String phone, boolean isPhonePrivate,
												  String email, boolean isEmailPrivate,
												  String address, boolean isAddressPrivate,
												  Set<String> tags, AddressBook addressBook,
												  List<ReadOnlyPerson> displayList) {

		String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

		try {
			EditCommand command = createEditCommand(targetVisibleIndex, name, phone, isPhonePrivate, email,
					isEmailPrivate, address, isAddressPrivate, tags, addressBook, displayList);
			assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
		} catch (Exception e) {
			return;
		}
	}

	/**
	 * Creates new edit command
	 *
	 * @param targetVisibleIndex index of person to be edited
	 * @param name new name value
	 * @param phone new phone value
	 * @param isPhonePrivate privacy settings of new phone value
	 * @param email new email value
	 * @param isEmailPrivate privacy settings of new email value
	 * @param address new address value
	 * @param isAddressPrivate privacy settings of new address value
	 * @param tags new set of tags
	 * @param addressBook Addressbook instance for this edit command
	 * @param displayList list to find person to be edited from.
	 * @return returns the newly created command
	 * @throws IllegalValueException when there is invalid data
	 */
	private EditCommand createEditCommand(int targetVisibleIndex,
										  String name,
										  String phone, boolean isPhonePrivate,
										  String email, boolean isEmailPrivate,
										  String address, boolean isAddressPrivate,
										  Set<String> tags, AddressBook addressBook,
										  List<ReadOnlyPerson> displayList) throws IllegalValueException {
		try {
			EditCommand command = new EditCommand(targetVisibleIndex, name, phone, isPhonePrivate, email,
					isEmailPrivate, address, isAddressPrivate, tags);
			command.setData(addressBook, displayList);
			return command;
		} catch (IllegalValueException ive) {
			throw ive;
		}
	}

	/**
	 * Executes the command, and checks that the execution was what we had expected.
	 */
	private void assertCommandBehaviour(EditCommand editCommand, String expectedMessage,
										AddressBook expectedAddressBook, AddressBook actualAddressBook) {

		CommandResult result = editCommand.execute();

		assertEquals(expectedMessage, result.feedbackToUser);
		assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
	}

	/**
	 * Asserts that attempting to construct an edit command with the supplied
	 * invalid data throws an IllegalValueException
	 */
	private void assertConstructingInvalidEditCmdThrowsException(int index, String name, String phone,
																 boolean isPhonePrivate, String email,
																 boolean isEmailPrivate, String address,
																 boolean isAddressPrivate, Set<String> tags) {
		try {
			new EditCommand(index, name, phone, isPhonePrivate, email, isEmailPrivate,
					address, isAddressPrivate, tags);
		} catch (IllegalValueException e) {
			return;
		}

		String error = String.format(
				"An edit command was successfully constructed with invalid input: %d %s %s %s %s %s %s %s %s",
				index, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
		fail(error);
	}

	/**
	 * Asserts that the person at the specified index can be successfully deleted.
	 *
	 * The addressBook passed in will not be modified (no side effects).
	 *
	 * @throws IllegalValueException when there is invalid data.
	 */
	private void assertEditSuccessful(int targetVisibleIndex, String name,
									  String phone, boolean isPhonePrivate,
									  String email, boolean isEmailPrivate,
									  String address, boolean isAddressPrivate,
									  Set<String> tags,
									  AddressBook addressBook,
									  List<ReadOnlyPerson> displayList) throws IllegalValueException {

		Person targetPerson = (Person) displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);

		final Set<Tag> tagSet = new HashSet<>();
		for (String tagName : tags) {
			tagSet.add(new Tag(tagName));
		}

		Person newDetails = new Person(new Name(name), new Phone(phone, isPhonePrivate),
				new Email(email, isEmailPrivate), new Address(address, isAddressPrivate),
				new UniqueTagList(tagSet));

		AddressBook expectedAddressBook = TestUtil.clone(addressBook);
		expectedAddressBook.editPerson(targetPerson, newDetails);
		String expectedMessage = String.format(EditCommand.MESSAGE_EDIT_PERSON_SUCCESS, targetPerson);

		AddressBook actualAddressBook = TestUtil.clone(addressBook);
		EditCommand command = createEditCommand(targetVisibleIndex, name, phone, isPhonePrivate, email,
					isEmailPrivate, address, isAddressPrivate, tags, addressBook, displayList);

		assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
	}
}