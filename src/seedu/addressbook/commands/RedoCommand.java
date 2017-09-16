package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;
import seedu.addressbook.state.exception.EmptyHistoryException;
import seedu.addressbook.state.exception.LoadStateException;

import java.util.List;

/**
 * Redoes a previous undo command on the application.
 */
public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Redoes the previous undo operation. "
            + "Redo history will be cleared on a new normal command and application exit.\n"
            + "Example: " + COMMAND_WORD;
    private static final String MESSAGE_SUCCESS = "%1$s\n\nSuccessfully completed redo operation. "
            + "Changes to Address Book:\n%2$s";
    
    private ApplicationHistory applicationHistory;

    public RedoCommand(ApplicationHistory applicationHistory) {
        this.applicationHistory = applicationHistory;
    }

    @Override
    public CommandResult execute() {
        ApplicationState loadState = null;
        try {
            ApplicationState saveState = getCurrentApplicationState();
            loadState = applicationHistory.popRedoHistory();
            final List<ReadOnlyPerson> loadPersonListing = loadState.getListingInState();
            applicationHistory.loadNewApplicationState(loadState, addressBook);
            applicationHistory.addStateAfterSuccessfulOperation();
            return new CommandResult(getMessageForSuccessfulUndoRedo(MESSAGE_SUCCESS, loadPersonListing, loadState, saveState), loadPersonListing);
            
        } catch (EmptyHistoryException ehe) {
            return new CommandResult(String.format(ehe.getMessage(), COMMAND_WORD));
            
        } catch (LoadStateException lse) {
            applicationHistory.pushRedoHistory(loadState);
            return new CommandResult(String.format(lse.getMessage(), COMMAND_WORD));
            
        }
    }
}
