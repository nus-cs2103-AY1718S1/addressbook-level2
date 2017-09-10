package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

public class EditCommand extends Command {

	public static final String COMMAND_WORD = "edit";
	private Person newDetails;

	public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person in the address book. "
			+ "New contact details can be marked private by prepending 'p' to the prefix.\n"
			+ "Parameters: INDEX NEW_NAME [p]p/NEW_PHONE [p]e/NEW_EMAIL [p]a/NEW_ADDRESS  [t/NEW_TAG]...\n"
			+ "Example: " + COMMAND_WORD
			+ " 1 John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

	public EditCommand(int targetVisibleIndex,
					   String name,
					   String phone, boolean isPhonePrivate,
					   String email, boolean isEmailPrivate,
					   String address, boolean isAddressPrivate,
					   Set<String> tags) throws IllegalValueException {
		super(targetVisibleIndex);

		final Set<Tag> tagSet = new HashSet<>();
		for (String tagName : tags) {
			tagSet.add(new Tag(tagName));
		}

		newDetails = new Person(new Name(name), new Phone(phone, isPhonePrivate),
				new Email(email, isEmailPrivate), new Address(address, isAddressPrivate), new UniqueTagList(tagSet));
	}
}

