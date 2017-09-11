package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

public class ModifyCommand extends Command {
    public static final String COMMAND_WORD="change";
    private String[] args;
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Change the PHONE, EMAIL OR ADDRESS of the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX and any of p/PHONE e/EMAIL a/ADDRESS\n"
            + "Example: " + COMMAND_WORD + " 1"+ "e/EMAIL \n"
            + "Only one change available each time";

    public static final String MESSAGE_CHANGE_SUCCESSFUL= "change successful";

    public ModifyCommand(int TargetVisibleIndex, String[] args){
        super(TargetVisibleIndex);
        this.args=args;
    }

    @Override
    public CommandResult execute() throws UniquePersonList.PersonNotFoundException {
        final ReadOnlyPerson target = getTargetPerson();
        addressBook.removePerson(target);
        String ops=args[2].substring(0,2);
        String info=args[2].substring(2);
        try {
            switch (ops) {
                case "p/":
                    Phone newPhone = new Phone(info, target.getPhone().isPrivate());
                    addressBook.addPerson(new Person(target.getName(),newPhone,target.getEmail(),target.getAddress(),target.getTags()));
                    break;
                case "e/":
                    Email newEmail = new Email(info, target.getEmail().isPrivate());
                    addressBook.addPerson(new Person(target.getName(),target.getPhone(),newEmail,target.getAddress(),target.getTags()));
                    break;
                case "a/":
                    Address newAddress=new Address(info,target.getEmail().isPrivate());
                    addressBook.addPerson(new Person(target.getName(),target.getPhone(),target.getEmail(),newAddress,target.getTags()));
                    break;
                default:
                    return new CommandResult("Invalid input message, cannot change the desired person's information");
            }
        }catch(IllegalValueException e){
            e.printStackTrace();
        }
        return new CommandResult("the information has been successfully changed!");
    }
}
