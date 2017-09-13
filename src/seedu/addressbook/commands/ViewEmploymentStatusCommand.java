package seedu.addressbook.commands;

public class ViewEmploymentStatusCommand extends Command {

    public static final String COMMAND_WORD = "viewes";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Views the person's employment status \n"
            + "Parameters: NAME\n"
            + "Example: " + COMMAND_WORD + " jeremy";

    String name;

    public ViewEmploymentStatusCommand(String name){this.name=name;}

    public CommandResult execute(){
        super.viewEmploymentInfo(name);
        return new CommandResult("Please enter next command");
    };
}
