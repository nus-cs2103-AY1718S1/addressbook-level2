package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.Password.PasswordStorage;
import seedu.addressbook.data.person.ReadOnlyPerson;



/**
 * Shows all details of the person identified using the last displayed index.
 * Private contact details are shown.
 */
public class ViewAllCommand extends Command {

    public static final String COMMAND_WORD = "viewall";
    public String userInputPassword;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Views the non-private details of the person "
            + "identified by the index number in the last shown person listing.\n"
            + "Parameters: INDEX PASSWORD\n"
            + "Example: " + COMMAND_WORD + " 1 " + PasswordStorage.getExamplePassword();//Might have a problem.

    public static final String MESSAGE_VIEW_PERSON_DETAILS = "Viewing person: %1$s";


    public ViewAllCommand(int targetVisibleIndex, String userInputPassword) {
        this.setTargetIndex(targetVisibleIndex);
        this.userInputPassword = userInputPassword;
    }


    @Override
    public CommandResult execute() {
        try {
            System.out.println('0');
            final ReadOnlyPerson target = getTargetPerson();
            if (!addressBook.containsPerson(target)) {
                System.out.println('1');
                return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
            }
            if(!userInputPassword.equals(PasswordStorage.getActualPassword())){
                System.out.println('2');
                return new CommandResult(Messages.MESSAGE_WRONG_PASSWORD);
            }
            System.out.println('3');
            return new CommandResult(String.format(MESSAGE_VIEW_PERSON_DETAILS, target.getAsTextShowAll()));
        } catch (IndexOutOfBoundsException ie) {
            System.out.println("Is the bug here?");
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
       }
    }
}
