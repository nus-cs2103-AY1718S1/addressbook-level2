package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Set;

public class EditCommand extends Command {

	public static final String COMMAND_WORD = "edit";

	public EditCommand(int index,
					   String name,
					   String phone, boolean isPhonePrivate,
					   String email, boolean isEmailPrivate,
					   String address, boolean isAddressPrivate,
					   Set<String> tags) throws IllegalValueException {

	}
}

