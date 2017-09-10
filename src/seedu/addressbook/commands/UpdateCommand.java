package seedu.addressbook.commands;

public class UpdateCommand extends Command {
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Updates the contact details of one existing person in the AddressBook.\n"
            + "The person is identified by the index number in the last shown person listing.\n"
            + "One or multiple contact details of that person can be updated at one time"
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: INDEX [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 p/86492434 e/someguy@gmail.com";
}
