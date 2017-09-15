package seedu.addressbook.commands;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXIT_ACKNOWEDGEMENT = "Exiting Address Book as requested ...";

    public static final String MESSAGE_EXIT_EDITORIAL = "Exiting editorial mode as requested";

    private boolean isEditorial;

    public ExitCommand(boolean isEditorial){this.isEditorial = isEditorial;}

    @Override
    public CommandResult execute() {
        if (!isEditorial){
            return new CommandResult(MESSAGE_EXIT_ACKNOWEDGEMENT);
        } else{
            return new CommandResult(MESSAGE_EXIT_EDITORIAL);
        }

    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
