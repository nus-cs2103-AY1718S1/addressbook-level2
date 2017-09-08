package seedu.addressbook.commands;

import seedu.addressbook.ui.TextUi;

/**
 * Shows help instructions.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public HelpCommand() {}

    @Override
    public CommandResult execute() {
        return new CommandResult(
                AddCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + DeleteCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + ClearCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + FindCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + ListCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + ViewCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + ViewAllCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + HelpCommand.MESSAGE_USAGE
                + TextUi.LINE_SPACE + ExitCommand.MESSAGE_USAGE
        );
    }
}
