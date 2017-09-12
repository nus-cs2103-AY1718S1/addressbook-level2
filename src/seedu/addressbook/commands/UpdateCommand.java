package seedu.addressbook.commands;

public class UpdateCommand extends Command {


	public static final String COMMAND_WORD = "update";

	private static final String MESSAGE_UPDATE_SUCCESS = "Person's information was updated";

	public static final String MESSAGE_USAGE = COMMAND_WORD
			+ ": Updates persons information based on the given parameter. "
			+ "Parameters: NAME PREFIX/NEW_VALUE\n"
			+ "Example: " + COMMAND_WORD
			+ " John Doe p/98765432";

}
