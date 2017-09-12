package seedu.addressbook.commands;

public class ViewEmploymentStatusCommand extends Command {

    public static final String COMMAND_WORD = "viewes";
    String name;

    public ViewEmploymentStatusCommand(String name){this.name=name;}

    public CommandResult execute(){
        super.viewEmploymentInfo(name);
        return new CommandResult("Please enter next command");
    };
}
