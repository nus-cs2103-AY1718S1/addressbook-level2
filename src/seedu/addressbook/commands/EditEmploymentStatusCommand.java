package seedu.addressbook.commands;

public class EditEmploymentStatusCommand extends Command{

    public static final String COMMAND_WORD = "edites";
    String name;

    public EditEmploymentStatusCommand(String name){
        this.name=name;
    }

    public CommandResult execute(){
        super.editEmploymentInfo(name);
        return new CommandResult("Person information edited");
    }

}
