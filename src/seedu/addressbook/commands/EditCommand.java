package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.*;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.HashSet;
import java.util.Set;

import static seedu.addressbook.commands.DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS;

public class EditCommand extends Command {

	public static final String COMMAND_WORD = "edit";
	public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Edited Person: %1$s";

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

	@Override
	public CommandResult execute() {
		try {
			final Person target = (Person) getTargetPerson();
			addressBook.editPerson(target, newDetails);
			return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, target));

		} catch (IndexOutOfBoundsException ie) {
			return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
		} //catch (UniquePersonList.PersonNotFoundException pnfe) {
			//return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
		//}
	}
}

