package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;
import java.util.ArrayList;



/**
 * User login command
 */

public class LoginCommand extends Command {

    public static final String COMMAND_WORD = "login";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Log into program using your username and password. "
            + "Parameters: u/USERNAME p/PASSWORD ...\n"
            + "Example: " + COMMAND_WORD
            + " u/John p/123456";

    public static final String MESSAGE_SUCCESS = "You logged in as: %1$s";
    public static final String MESSAGE_LOGIN_B4_USE = "You have to log in before using this program. \n"
            + "Type exit to exit this program.";
    public static final String MESSAGE_FAIL = "Incorrect username or password";
    private final User toAdd;

    public LoginCommand(String username, String password) {

            this.toAdd = new User(username, password);

    }

    @Override
    public CommandResult execute() {

        boolean foundMatch = false;

        /* Opens storage files to get all users object */
        FileHandling file = new FileHandling();

        ArrayList<User> users2 = file.readFile();

        /* Find the matched user in the storage file */
        for (User u: users2){
            /* Check if username and password match */
            if(this.toAdd.getUsername().toString().equals(u.getUsername().toString()) &&
                    this.toAdd.getPassword().toString().equals(u.getPassword().toString())){
                foundMatch = true;
            }

        }
        if(foundMatch){
            return new CommandResult(String.format(MESSAGE_SUCCESS, this.toAdd), foundMatch);
        }

        return new CommandResult(String.format(MESSAGE_FAIL));

    }

}
