package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class EditCommand extends Command {
    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the contact information of a person.\n" +
            "Parameters: INDEX FIELD(name, email or phone) NEW_INFORMATION.\n" +
            "Example: " + COMMAND_WORD + " 1 name Jesus";
    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited person: %1$s.\nEdited field: %2$s.";
    public static final int EDIT_COMMAND_INDEX = 0;
    public static final int EDIT_COMMAND_FIELD = 1;
    public static final int EDIT_COMMAND_NEW_INFORMATION = 2;
    private static String field;
    private static String newInformation;

    public EditCommand(int index, String field, String newInformation){
        super(index);
        this.field = field;
        this.newInformation = newInformation;
    }

    @Override
    public CommandResult execute(){
        try {
            final ReadOnlyPerson target = getTargetPerson();
            final Person realTarget = (Person)addressBook.getPerson(target);
            executeEdit(realTarget, field, newInformation);
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, realTarget, field), addressBook.getAllPersons().immutableListView());
        }catch(PersonNotFoundException pnfe){
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }catch(IndexOutOfBoundsException iobe){
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }catch(IllegalValueException ive){
            return new CommandResult(ive.getMessage());
        }
    }


    /**
     * Performs the actual editing of a person's information within the master list.
     *
     * @param person the reference to the target within the master list.
     * @param field the field of the target to be edited.
     * @param newInformation the new value to insert into the field
     * @throws IllegalValueException already handled in prepareEdit.
     */
    private void executeEdit(Person person, String field, String newInformation) throws IllegalValueException{
        if(field.equals(Messages.EDIT_COMMAND_NAME)){
            Name name = new Name(newInformation);
            person.setName(name);
        }else if(field.equals(Messages.EDIT_COMMAND_PHONE)){
            Phone phone = new Phone(newInformation, person.getPhone().isPrivate());
            person.setPhone(phone);
        }else{
            Email email = new Email(newInformation, person.getPhone().isPrivate());
            person.setEmail(email);
        }
    }
}
