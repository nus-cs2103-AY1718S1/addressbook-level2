package seedu.addressbook.commands;

public class ReminderCommand extends Command {

    public static final String COMMAND_WORD = "reminder";

    public static final String REMINDER_SUCCESS = "New reminder added:";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a reminder that pops up during launch.\n"
            + "Example: " + COMMAND_WORD + " remember to do your tutorial!";

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
