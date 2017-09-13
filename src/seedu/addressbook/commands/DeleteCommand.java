package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.data.stack.CommandPair;

import java.util.List;


/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    private boolean isUndo;

    public DeleteCommand(int targetVisibleIndex) {
        super(targetVisibleIndex);
        isUndo = false;
    }

    public DeleteCommand(int targetVisibleIndex, boolean isUndo) {
        super(targetVisibleIndex);
        this.isUndo = isUndo;
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.removePerson(target);

            if(!isUndo) {
                undoStack.push(new CommandPair((Person) target, 0));
            }

            List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
            return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, target), allPersons);

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }

}
