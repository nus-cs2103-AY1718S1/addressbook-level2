package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.group.Group;
import seedu.addressbook.data.group.UniqueGroupList;

public class AddGroupCommand extends Command {
    public static final String COMMAND_WORD = "addgroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a group to the address book."
            + "\nParameters: NAME \n"
            + "Example: " + COMMAND_WORD
            + " NUS";

    public static final String MESSAGE_SUCCESS = "New group added: %1$s";
    public static final String MESSAGE_DUPLICATE_GROUP = "This group already exists in the address book";


    private final Group toAdd;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddGroupCommand(String name) throws IllegalValueException {
        this.toAdd = new Group(name);
    }

    public AddGroupCommand(Group toAdd) {
        this.toAdd = toAdd;
    }

    public Group getGroup() {
        return toAdd;
    }

    @Override
    public CommandResult execute() {
        try {
            addressBook.addGroup(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniqueGroupList.DuplicateGroupException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_GROUP);
        }
    }

}
