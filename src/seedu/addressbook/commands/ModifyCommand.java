package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

public class ModifyCommand extends Command{
    public static final String COMMAND_WORD="change";
    private String args;
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Change the PHONE, EMAIL OR ADDRESS of the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX and any of p/PHONE e/EMAIL a/ADDRESS\n"
            + "Example: " + COMMAND_WORD + " 1"+ " e/EMAIL \n"
            + "Only one change available each time";


    public ModifyCommand(int TargetVisibleIndex, String args){
        super(TargetVisibleIndex);
        this.args=args;
    }

    @Override
    public CommandResult execute()  {
        try{
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.removePerson(target);
            String ops=args.substring(0,2);
            String info=args.substring(2);

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
        } catch (UniquePersonList.PersonNotFoundException e) {
            return new CommandResult("Person not found!");
        } catch(IllegalValueException e){
            return new CommandResult("Illegal value!");
        }catch (IndexOutOfBoundsException e){
            return new CommandResult("Invalid index, please enter valid index number!");
        }
        return new CommandResult("the information has been successfully changed!");
    }
}
