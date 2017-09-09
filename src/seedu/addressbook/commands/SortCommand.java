package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sorts addressbook people by ascending order or descending order by field name. Field names
 * available for sorting are NAME, PHONE, EMAIL, ADDRESS
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final ArrayList<String> ACCEPTED_FIELD_PARAMETERS = new ArrayList<>(Arrays.asList(
            "name", "phone", "email", "address"));

    public static final ArrayList<String> ACCEPTED_ORDER_PARAMETERS = new ArrayList<>(Arrays.asList(
            "asc", "desc"));


    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all persons by chosen "
            + "field (NAME, PHONE, EMAIL, ADDRESS) and by order (ASC or DESC). Case insensitive\n"
            + "Parameters: OPTION ORDER\n"
            + "Example: " + COMMAND_WORD + " name asc";

    public static final String MESSAGE_SUCCESS = "All persons sorted successfully...";
    public static final String MESSAGE_INVALID_INPUT = "Invalid Input.\n"
            + "Accepted Field Values: NAME, PHONE, EMAIL, ADDRESS \n"
            + "Accepted Order Values: ASC, DESC";

    public final String field;
    public final String order;

    // Constructor will force lower case
    public SortCommand(String field, String order) throws IllegalValueException {
        this.field = field.toLowerCase();
        this.order = order.toLowerCase();
    }

    /**
     * a copy of user input fields and order.
     */
    public String getfield() {
        return this.field;
    }
    public String getorder() { return this.order; }

    @Override
    public CommandResult execute() {

        // Check for inappropriate field parameters. If input is invalid, return invalid input message
        if (!ACCEPTED_FIELD_PARAMETERS.contains(getfield()) || !ACCEPTED_ORDER_PARAMETERS.contains(getorder())) {
            return new CommandResult(MESSAGE_INVALID_INPUT);
        }

        addressBook.sortBy(getfield(), getorder());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
