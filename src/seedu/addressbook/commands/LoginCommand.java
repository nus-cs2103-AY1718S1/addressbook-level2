package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;

import java.util.List;

/**
 * User logins into the program.
 */

public class LoginCommand extends Command {

    public static final String COMMAND_WORD = "login";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Log into program using your username and password. "
            + "Parameters: u/USERNAME p/PASSWORD ...\n"
            + "Example: " + COMMAND_WORD
            + " u/John p/123456";

    public static final String MESSAGE_SUCCESS = "You logged in as: %1$s";
    public static final String MESSAGE_FAIL = "Incorrect username or password";

    private final User toAdd;


    public LoginCommand(String username,
                        String password) {

            this.toAdd = new User(
                    new Username(username),
                    new Password(password)
            );

    }

    @Override
    public CommandResult execute() {
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }


}
