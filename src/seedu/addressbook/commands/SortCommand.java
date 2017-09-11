package seedu.addressbook.commands;

/**
 * Created by Philemon1 on 11/9/2017.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all people by alphabetical order" +
            "No parameter needed.";

    public static final String MESSAGE_SUCCESS = "All people sorted";
    public static final String MESSAGE_ALREADY_SORTED = "Already sorted";


    @Override
    public CommandResult execute(){
        return null;
    }


}
