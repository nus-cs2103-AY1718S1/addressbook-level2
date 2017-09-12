package seedu.addressbook.commands;

public class ReminderCommand extends Command {

    public static final String COMMAND_WORD = "reminder";

    public static final String REMINDER_SUCCESS = "New reminder added: ";

    public String reminderToAdd;


    public ReminderCommand(String reminderToAdd) {
        this.reminderToAdd = reminderToAdd;
    }

    @Override
    public CommandResult execute() {
        addressBook.setReminderMessage(reminderToAdd);
        return new CommandResult(REMINDER_SUCCESS);
    }

}
