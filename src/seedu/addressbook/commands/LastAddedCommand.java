package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;
/**
 * Shows details of the person last added.
 * Private contact details are not shown.
 */
public class LastAddedCommand extends Command {

    public static final String COMMAND_WORD = "lastadded";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Views the last person added to address book. \n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> lastPerson = getLastPerson();
        return new CommandResult(getMessageForLastAddedSummary(lastPerson), lastPerson);
    }

    /**
     * Retrieves last person in the address book.
     * @return list of last person
     */
    private List<ReadOnlyPerson> getLastPerson() {
        return addressBook.getLastAdded();
    }

}