package seedu.addressbook.commands;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    private boolean isSaveFileSuccess = true;
    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXIT_ACKNOWEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_EXIT_ACKNOWEDGEMENT);
    }

    public static boolean isSuccessfulExit(Command command) {
        return (command instanceof ExitCommand  // instanceof returns false if it is null
                && ((ExitCommand) command).isSuccessfulSave()); // isSuccessfulSave() returns true if file saved - pass
    }

    /**
     * @return true if file is successfully saved without errors.
     */
    private boolean isSuccessfulSave() {
        return isSaveFileSuccess;
    }
    
    /**
     * Switches the command instance state to a failure.
     */
    public void setSaveFailureState() {
        isSaveFileSuccess = false;
    }
}
