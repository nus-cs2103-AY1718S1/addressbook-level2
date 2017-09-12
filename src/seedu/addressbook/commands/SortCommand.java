package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort all persons in the address book in a list by ascesnding or descending order.\n"
            + "Example Ascending Order: " + COMMAND_WORD + "\n"
            + "Example Ascending Order: " + COMMAND_WORD + " asc\n"
            + "Example Descending Order: " + COMMAND_WORD + " dsc";

    private int sortOder; //asc is positive, dsc is negative

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public SortCommand(int sortOder) {
        this.sortOder = sortOder;
    }
}
