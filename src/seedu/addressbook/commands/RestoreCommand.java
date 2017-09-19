package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

import static seedu.addressbook.commands.AddCommand.MESSAGE_SUCCESS;

/**
 * Revoke the most recent deletion
 */
public class RestoreCommand extends Command {

    public static final String COMMAND_WORD = "restore";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Revoke the most recent deletion\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        // System.out.println("I m seeing if the storage works: " + storageForDeleted.peek().toString());
        try {
            Person toAdd = storageForDeleted.getPersonToBeRestored();
            if (toAdd == null) {
                throw new UnsupportedOperationException("The person to be added is null");
            } else {
                addressBook.addPerson(toAdd);
                return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
            }
        } catch (Exception e) {
            // System.out.println("I m seeing if the storage works: " + storageForDeleted.peek().toString());
            return new CommandResult(Messages.MESSAGE_NO_ONE_IN_STORAGE_FOR_DELETED);
        }

    }
}