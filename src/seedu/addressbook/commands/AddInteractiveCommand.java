package seedu.addressbook.commands;

/**
 * Adds a person to the address book.
 */
public class AddInteractiveCommand extends Command {

    public static final String COMMAND_WORD = "add-interactive";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    /**
     * Constructor for AddInteractive
     *
     */
    public AddInteractiveCommand() {
    }

    @Override
    public CommandResult execute() {
        /*
        try {
            addressBook.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }
        */
        // Testing with a generic response
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
