package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;


/**
         Updates a person's entry identified by using it's last displayed index from the address book.

*/
public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";
    public static String COMMAND_ACTION = "0";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Updates an existing entry by the index number used in the last find/list call.\n"
            + "Enter 1 to update name , 2 to update phone no and 3 to update email"
            +  "parameters :  INDEX"
            + "Example: " + COMMAND_WORD + " 1" + "2";

    public static final String MESSAGE_UPDATE_SUCCESS = "Person after update: %1$s";

    public UpdateCommand(int targetVisibleIndex) {
        super(targetVisibleIndex / 10);
        COMMAND_ACTION = Integer.toString(targetVisibleIndex % 10);
    }
    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.UpdatePerson(target , COMMAND_ACTION );
            return new CommandResult(String.format(MESSAGE_UPDATE_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }
}

