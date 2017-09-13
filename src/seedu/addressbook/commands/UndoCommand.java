package seedu.addressbook.commands;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.List;

/*
 *  Undo deletion or addition based on the previous command
 */
public class UndoCommand extends Command{
    public static final String COMMAND_WORD = "undo";
    public static final String MESSAGE_SUCCESS_UNDOADD = "Undo Addition successfully";
    public static final String MESSAGE_SUCCESS_UNDODELETE = "Undo Deletion successfully";
    public static final String MESSAGE_NOTHING_TO_UNDO = "Nothing to Undo";
    public static final String MESSAGE_DUPLICATE_PERSON = "Duplicated Person Added";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Undo deletion or addition\n"
            + "Example: " + COMMAND_WORD;

    public void setLastDeleted(Person _lastDeleted){
        lastDeleted = _lastDeleted;
    }

    @Override
    public CommandResult execute() {
        if (lastAdded == null && lastDeleted == null){
            return new CommandResult(MESSAGE_NOTHING_TO_UNDO);
        } else if(lastAdded != null){
            //System.out.println(addressBook.getAllPersons().immutableListView().size());
            // DeleteCommand undoAdd = new DeleteCommand(addressBook.getAllPersons().immutableListView().size());
            final ReadOnlyPerson target = relevantPersons.get(addressBook.getAllPersons().immutableListView().size()-1);
            try {addressBook.removePerson(target);} catch (UniquePersonList.PersonNotFoundException pnfe) {
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            lastAdded = null;
            return new CommandResult(MESSAGE_SUCCESS_UNDOADD);
        } else {
            //AddCommand undoDelete = new AddCommand(lastDeleted);
            //undoDelete.execute();
            try {
                addressBook.addPerson(lastDeleted);
                lastDeleted = null;
            } catch (UniquePersonList.DuplicatePersonException dpe) {
                return new CommandResult(MESSAGE_DUPLICATE_PERSON);
            }
            return new CommandResult(MESSAGE_SUCCESS_UNDODELETE);
        }
    }
}
