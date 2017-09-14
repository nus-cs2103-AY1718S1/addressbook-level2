package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;


/**
 * Shows details of the person identified using the last displayed index.
 * Private contact details are not shown.
 */
public class AddressCommand extends Command {

    public static final String COMMAND_WORD = "address";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Views the non-private address details of the person "
            + "identified by the index number in the last shown person listing.\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_VIEW_PERSON_ADDRESS_DETAILS = "Viewing person address details: %1$s";


    public AddressCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
    }


    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            return new CommandResult(String.format(MESSAGE_VIEW_PERSON_ADDRESS_DETAILS, target.getAddressAsTextHidePrivate()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

}
