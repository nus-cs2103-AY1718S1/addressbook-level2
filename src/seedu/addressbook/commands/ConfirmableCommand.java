package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.parser.Parser;
import seedu.addressbook.ui.TextUi;

/**
 * Requests confirmation from user. Invalid responses are also
 * considered rejection.
 */
public abstract class ConfirmableCommand extends Command {
    private static final String CONFRIMATION_MESSAGE_FORMAT = "%s [Y/N]: ";
    private final String confirmationMsg;

    /**
     * The confirmation message will be formatted with
     * {@code CONFRIMATION_MESSAGE_FORMAT}
     *
     * @param confirmation_msg message to show the user
     */
    public ConfirmableCommand(String confirmation_msg) {
        this.confirmationMsg = String.format(CONFRIMATION_MESSAGE_FORMAT,
                confirmation_msg);
    }

    /**
     * Requests user confirmation and returns the result.
     * <p>
     * {@code final} keyword added to prevent subclasses from removing
     * the prompt by overriding this method.
     */
    @Override
    public final  CommandResult execute() {
        onExecute();
        final String userConfirmation = TextUi.getInstance()
                .getUserConfirmation(confirmationMsg);
        try {
            if (new Parser().parseConfirmation(userConfirmation)) {
                return confirmed();
            } else {
                return rejected();
            }
        } catch (IllegalValueException e) {
            return new CommandResult(e.getMessage());
        }
    }

    /**
     * This method will run if the user confirms the command.
     */
    protected abstract CommandResult confirmed();

    /**
     * This method will run if the user rejects the command.Invalid
     * responses are also considered rejection.
     */
    protected abstract CommandResult rejected();

    /**
     * Override this to execute code before the confirmation prompt.
     */
    protected void onExecute() {
        //Do nothing.
    }
}
