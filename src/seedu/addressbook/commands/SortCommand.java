package seedu.addressbook.commands;

/**
 * Sorts all persons in the address book to the user.
 * If address book is empty, list will not be sorted.
 */

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String SORT_SUCCESSFUL = "Sort is successful";
    public static final String LIST_EMPTY = "List is empty, list is not sorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        if(addressBook.isEmptyBook()){
            return new CommandResult(LIST_EMPTY);
        }
        else{
            addressBook.sort();
            return new CommandResult(SORT_SUCCESSFUL);
        }
    }
}

