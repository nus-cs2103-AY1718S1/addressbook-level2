package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;
import seedu.addressbook.state.exception.EmptyHistoryException;
import seedu.addressbook.state.exception.LoadStateException;

import java.util.List;

/**
 * Undoes any previous command, except invalid commands or help commands.
 */
public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Undoes the previous operation. "
            + "Undo history will be cleared on application exit.\n"
            + "Example: " + COMMAND_WORD;
    private static final String MESSAGE_SUCCESS = "%1$s\n\nSuccessfully completed undo operation. "
            + "Changes to Address Book:\n%2$s";
    
    private ApplicationHistory applicationHistory;

    public UndoCommand(ApplicationHistory applicationHistory) {
        this.applicationHistory = applicationHistory;
    }

    @Override
    public CommandResult execute() {
        ApplicationState loadState = null;
        try {
            ApplicationState saveState = getCurrentApplicationState();
            loadState = applicationHistory.popHistory();
            final List<ReadOnlyPerson> loadPersonListing = loadState.getListingInState();
            applicationHistory.loadNewApplicationState(loadState, addressBook);
            applicationHistory.addRedoStateAfterSuccessfulUndo();
            return new CommandResult(getMessageForSuccessfulUndoRedo(MESSAGE_SUCCESS, loadPersonListing, loadState, saveState), loadPersonListing);

        } catch (EmptyHistoryException ehe) {
            return new CommandResult(String.format(ehe.getMessage(), COMMAND_WORD));

        } catch (LoadStateException lse) {
            applicationHistory.pushHistory(loadState);
            return new CommandResult(String.format(lse.getMessage(), COMMAND_WORD));
            
        }
    }
}
