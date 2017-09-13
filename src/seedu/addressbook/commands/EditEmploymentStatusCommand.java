package seedu.addressbook.commands;

public class EditEmploymentStatusCommand extends Command{

    public static final String COMMAND_WORD = "edites";


    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person's employment status \n"
            + "Parameters: NAME\n"
            + "Example: " + COMMAND_WORD + " jeremy";

    String name;

    public EditEmploymentStatusCommand(String name){
        this.name=name;
    }

    public CommandResult execute(){
        super.editEmploymentInfo(name);
        return new CommandResult("Please enter next command");
    }

}
