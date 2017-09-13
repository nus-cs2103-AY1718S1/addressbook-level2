package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.ui.TextUi;


/**
 * Edit an existing person to the address book.
 */
public class EditCommand extends Command{
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": edit the person identified by index number\n"
            + "Parameters: INDEX FIELD NEWVALUE\n"
            + "Example: " + COMMAND_WORD + " 2 Name yang"
            + " is the instruction to change person 2's name to yang";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: ";

    private Person editingPerson;
    private int targetVisibleIndex;
    private String targetVisibleIndexs;
    private String field;
    private String newValue;
    private String Message;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(String targetVisibleIndex, String field, String newValue){
        this.targetVisibleIndexs = targetVisibleIndex;
        this.targetVisibleIndex = Integer.parseInt(targetVisibleIndex);
        this.field = field;
        this.newValue = newValue;
    }

    @Override
    public CommandResult execute() {

        try{
            editingPerson = addressBook.getAllPersons().getPersonByIndex(targetVisibleIndex);
            Message = EditCommand.MESSAGE_EDIT_PERSON_SUCCESS + "Edited" +  " Person " + targetVisibleIndexs
                                  + " " + field + " to " + newValue;
            switch(field) {
                case "Address":
                    editingPerson.setAddress(new Address(newValue, editingPerson.getAddress().isPrivate()));
                    break;
                case "Email":
                    editingPerson.setEmail(new Email(newValue, editingPerson.getEmail().isPrivate()));
                    break;
                case "Name":
                    editingPerson.setName(new Name(newValue));
                    break;
                case "Phone":
                    editingPerson.setPhone(new Phone(newValue, editingPerson.getEmail().isPrivate()));
                    break;
                default:
                    return new CommandResult("Invalid Field!");
            }
            return new CommandResult(Message);

        } catch (IllegalValueException e) {
            return new CommandResult("Error editing person, please change the value and try again");
        } catch (UniquePersonList.PersonNotFoundException e) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

    }
    
}
