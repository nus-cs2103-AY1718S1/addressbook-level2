package seedu.addressbook.commands;

import seedu.addressbook.data.person.UniquePersonList;

/**
 * Sort records in the AddressBook
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort the people inside the address book by their NAME.\n"
            + "Parameters: asc | dsc \n"
            + "Example: " + COMMAND_WORD
            + " asc";

    public static final String MESSAGE_SUCCESS = "Successfully Sorted";
    public static final String MESSAGE_FAILURE = "Unable to sort.";

    private final String order;

    public SortCommand(String order){
        this.order = order.trim();
    }


    @Override
    public CommandResult execute() {
        try {
            addressBook.sortBook(order);
            return new CommandResult(String.format(MESSAGE_SUCCESS));
        } catch (Exception e) {
            return new CommandResult(MESSAGE_FAILURE);
        }
    }
}
