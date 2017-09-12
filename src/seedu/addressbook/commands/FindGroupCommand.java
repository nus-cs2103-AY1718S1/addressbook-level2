package seedu.addressbook.commands;

public class FindGroupCommand {
    public static final String COMMAND_WORD = "findgroup";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Find all persons who are in the group with "
            + "the specified group name (case-sensitive) and display them as a list with index numbers. \n"
            + "Parameters: [Group Name] \n"
            + "Example: " + COMMAND_WORD + "family";
    private final String groupname;
    public FindGroupCommand (String groupname) { this.groupname = groupname; }

}
