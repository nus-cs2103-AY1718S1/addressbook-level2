package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Set;

public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Updates the contact details of one existing person in the AddressBook.\n"
            + "The person is identified by the index number in the last shown person listing.\n"
            + "One or multiple contact details of that person can be updated at one time.\n"
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: INDEX [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 p/86492434 e/someguy@gmail.com";

    public static final String MESSAGE_SUCCESS = "Person updated: %1$s";

    private final String phone;
    private final boolean isPhonePrivate;
    private final String email;
    private final boolean isEmailPrivate;
    private final String address;
    private final boolean isAddressPrivate;

    public UpdateCommand(int targetVisibleIndex, String name,
                         String phone, boolean isPhonePrivate,
                         String email, boolean isEmailPrivate,
                         String address, boolean isAddressPrivate,
                         Set<String> tags) throws IllegalValueException {
        super(targetVisibleIndex);
        this.phone = phone;
        this.isPhonePrivate = isPhonePrivate;
        this.email = email;
        this.isEmailPrivate = isEmailPrivate;
        this.address = address;
        this.isAddressPrivate = isAddressPrivate;
    }

    @Override
    public CommandResult execute() {
        final ReadOnlyPerson target;

        try {
            target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            return new CommandResult(String.format(MESSAGE_SUCCESS, target));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }
}
