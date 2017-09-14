package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 *  Sets a person's details to be private
 */

public class PrivateCommand extends Command {

    public static final String COMMAND_WORD = "private";

    private static final String SECRET_PASSWORD = "UNDO";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sets the indexed person's details to private. If no detail is specified, "
            + "all details will be set private.\n"
            + "Parameters: INDEX [DETAIL]\n"
            + "Details: phone, email, address\n"
            + "Example: " + COMMAND_WORD + " 1 " + "email";

    public static final String MESSAGE_SINGLE_PRIVATE_SUCCESS = "%1$s's %2$s is now private.";
    public static final String MESSAGE_ALL_PRIVATE_SUCCESS = "%1$s's details are now all private";
    public static final String MESSAGE_PUBLIC_SUCCESS = "Password accepted. %1$s's details are now all public.";
    public static final String MESSAGE_COMMAND_FAIL = "Detail word is not accepted, please re-try.";

    private static String targetDetail = "";

    public PrivateCommand(int targetVisibleIndex, String targetDetail) {
        super(targetVisibleIndex);
        this.targetDetail = targetDetail;
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            addressBook.privatise(target,targetDetail);
            if (targetDetail.equals(SECRET_PASSWORD)) {
                return addressBook.publicise(target);
            }
            return addressBook.privatise(target, targetDetail);
        } catch (IndexOutOfBoundsException ie){
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

}
