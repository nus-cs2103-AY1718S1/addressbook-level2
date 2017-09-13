package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.stack.CommandPair;

import java.util.EmptyStackException;

import static seedu.addressbook.ui.TextUi.DISPLAYED_INDEX_OFFSET;

public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";

    public void setPerson(Person person) {
        this.person = person;
    }
    public void setIsUndoingAdd(int isUndoingAdd) {
        this.isUndoingAdd = isUndoingAdd;
    }

    private Person person;

    private int isUndoingAdd;

    public UndoCommand() {
    }


    @Override
    public boolean isUndoCommand() {
        return true;
    }

    public Command prepareCommand() throws EmptyStackException {
        if(undoStack.isEmpty()) {
            throw new EmptyStackException();
        }

        CommandPair pair = undoStack.pop();
        this.person = pair.getPerson();
        this.isUndoingAdd = pair.isAdd();

        Command toUndo;

        if(isUndoingAdd == 0) {
            toUndo = new AddCommand(person, true);
        } else {
            int targetVisibleIndex = addressBook.findIndexOf(person) + DISPLAYED_INDEX_OFFSET;
            toUndo = new DeleteCommand(targetVisibleIndex, true);
        }
        return toUndo;
    }

    /*
    @Override
    public CommandResult execute() {
        CommandResult result;
        if(isUndoingAdd == 0) {
            AddCommand add = new AddCommand(person);
            result = reExecuteCommand(add);
        } else {
            int index = addressBook.findIndexOf(person);
            DeleteCommand delete = new DeleteCommand(index);
            result = reExecuteCommand(delete);
        }
        return result;
    }
    */
}