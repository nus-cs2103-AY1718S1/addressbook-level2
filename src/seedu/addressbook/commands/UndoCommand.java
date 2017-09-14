package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;

import java.util.List;


public class UndoCommand extends Command {

    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Undoes the previous operation. "
            + "Undo history will be cleared on application exit.";
    private static final String MESSAGE_SUCCESS = "%1$s\n\nSuccessfully completed undo operation. "
            + "Changes to Address Book:\n%2$s";
    
    private ApplicationHistory applicationHistory;

    public UndoCommand(ApplicationHistory applicationHistory) {
        this.applicationHistory = applicationHistory;
    }

    @Override
    public CommandResult execute() {
        ApplicationState saveState = getCurrentApplicationState();
        ApplicationState loadState = applicationHistory.popHistory();
        final List<ReadOnlyPerson> loadPersonListing = loadState.getListingInState();
        try {
            applicationHistory.loadNewApplicationState(loadState, addressBook);
            applicationHistory.addRedoStateAfterSuccessfulUndo();
            return new CommandResult(getMessageForSuccessfulUndoRedo(MESSAGE_SUCCESS, loadPersonListing, loadState, saveState), loadPersonListing);
            
        } catch (ApplicationHistory.EmptyHistoryException ehe) {
            return new CommandResult(String.format(ehe.getMessage(), COMMAND_WORD));
            
        } catch (ApplicationHistory.LoadStateException lse) {
            applicationHistory.pushHistory(loadState);
            return new CommandResult(String.format(lse.getMessage(), COMMAND_WORD));
            
        }
    }
}
