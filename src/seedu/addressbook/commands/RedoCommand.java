package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;

import java.util.List;


public class RedoCommand extends Command {

    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Redoes the previous undo operation. "
            + "Redo history will be cleared on application exit.";
    private static final String MESSAGE_SUCCESS = "%1$s\n\nSuccessfully completed redo operation. "
            + "Changes to Address Book:\n%2$s";
    
    private ApplicationHistory applicationHistory;

    public RedoCommand(ApplicationHistory applicationHistory) {
        this.applicationHistory = applicationHistory;
    }

    @Override
    public CommandResult execute() {
        ApplicationState saveState = getCurrentApplicationState();
        ApplicationState loadState = applicationHistory.popRedoHistory();
        final List<ReadOnlyPerson> loadPersonListing = loadState.getListingInState();
        try {
            applicationHistory.loadNewApplicationState(loadState, addressBook);
            applicationHistory.addStateAfterSuccessfulOperation();
            return new CommandResult(getMessageForSuccessfulUndoRedo(MESSAGE_SUCCESS, loadPersonListing, loadState, saveState), loadPersonListing);
            
        } catch (ApplicationHistory.EmptyRedoHistoryException erhe) {
            return new CommandResult(String.format(erhe.getMessage(), COMMAND_WORD));
            
        } catch (ApplicationHistory.LoadStateException lse) {
            applicationHistory.pushRedoHistory(loadState);
            return new CommandResult(String.format(lse.getMessage(), COMMAND_WORD));
            
        }
    }
}
