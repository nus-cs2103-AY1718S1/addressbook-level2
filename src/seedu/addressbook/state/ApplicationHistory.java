package seedu.addressbook.state;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.state.exception.EmptyHistoryException;
import seedu.addressbook.state.exception.LoadStateException;

import java.util.Stack;

import static seedu.addressbook.common.Messages.MESSAGE_ERROR_APPLICATION;
import static seedu.addressbook.common.Messages.MESSAGE_ERROR_EMPTY_HISTORY_STACK;
import static seedu.addressbook.common.Messages.MESSAGE_ERROR_EMPTY_REDO_STACK;

public class ApplicationHistory {
    

    /** Maximum size of the history state before getting deleted. Minimum value 1. */
    private static final int MAX_HISTORY_SIZE = 15;
    
    /** Stack of all history states in the current session. */
    private Stack<ApplicationState> historyStack = new Stack<>();

    /** Stack of all undo history states in the current undo sequence. */
    private Stack<ApplicationState> redoStack = new Stack<>();
    
    /** A temporary saveState before Application runs an operation */
    private ApplicationState saveState;

    /**
     * Replaces the current state with a new ApplicationState
     * 
     * @param newState the new state that contains the new data to be loaded.
     * @param currentAddressBook the current (old) Address Book where data is to be overwritten.
     */
    public void loadNewApplicationState(ApplicationState newState,
                                        AddressBook currentAddressBook) throws LoadStateException {
        if (!currentAddressBook.loadNewAddressBook(newState.getAddressBookInState())) {
            throw new LoadStateException(MESSAGE_ERROR_APPLICATION);
            
        }
    }
    
    public void saveStateBeforeOperation(ApplicationState applicationState) {
        saveState = applicationState;
    }

    /**
     * Adds the latest saveState to the undo stack after a successful operation, up to the maximum history size.
     * Needs to be called after successful execution of a normal operation.
     */
    public void addStateAfterSuccessfulOperation() {
        while (historyStack.size() >= MAX_HISTORY_SIZE) {
            historyStack.removeElementAt(0);
        }
        historyStack.push(saveState);
    }

    /**
     * Adds the latest saveState to the redo stack after a successful undo operation.
     * This will automatically match the maximum history size so no additional check is necessary.
     * Needs to be called after successful execution of an undo operation.
     */
    public void addRedoStateAfterSuccessfulUndo() {
        redoStack.push(saveState);
    }

    /**
     * Clears the redo stack after successful operation.
     * New branch of edits will override previous redo stack.
     */
    public void clearRedoStackAfterSuccessfulOperation() {
        redoStack.clear();
    }
    
    /**
     * Adds the latest saveState to the undo stack after a successful editor operation then clears the redo stack.
     * Not to be used with redo operations.
     */
    public void updateStateAfterSuccessfulOperation() {
        addStateAfterSuccessfulOperation();
        clearRedoStackAfterSuccessfulOperation();
    }

    public boolean isEmptyHistory() {
        return historyStack.isEmpty();
    }
    
    public boolean isEmptyRedoHistory() {
        return redoStack.isEmpty();
    }
    
    public ApplicationState popHistory() throws EmptyHistoryException {
        if (isEmptyHistory()) {
            throw new EmptyHistoryException(MESSAGE_ERROR_EMPTY_HISTORY_STACK);
        }
        return historyStack.pop();
    }
    
    public void pushHistory(ApplicationState applicationState) { historyStack.push(applicationState); }
    
    public ApplicationState popRedoHistory() throws EmptyHistoryException {
        if (isEmptyRedoHistory()) {
            throw new EmptyHistoryException(MESSAGE_ERROR_EMPTY_REDO_STACK);
        }
        return redoStack.pop();
    }

    public void pushRedoHistory(ApplicationState applicationState) { historyStack.push(applicationState); }
}
