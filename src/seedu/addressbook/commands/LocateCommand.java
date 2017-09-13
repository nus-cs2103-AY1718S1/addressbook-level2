package seedu.addressbook.commands;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class LocateCommand extends Command{

    public static final String COMMAND_WORD = "locate";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Locates a person to the address book by his address. The argument is just the name. ";

    public static final String MESSAGE_SUCCESS = "Openning Browser...";

    public static final String MESSAGE_FAILURE = "Sorry, the browser cannot be opened";

    private final String MESSAGE_CANNOT_FIND = "Sorry we couldn't find anyone with that name";
    private final Desktop desk = Desktop.getDesktop();

    
    private String name;
    private String address;
    private boolean canFindName = false;


    public LocateCommand(String name) throws IllegalValueException {
        this.name = name;
    }

    @Override
    public CommandResult execute() {
        //try searching through the addressbook for the name
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (person.getName().toString().contains(this.name)){
                this.address = person.getAddress().toString();
                this.canFindName = true;
                break;
            }

        }
        //browse only if the name can be found in the addres book
        if (this.canFindName) {
            try {
                desk.browse(new URI("http://www.google.com/maps/search/" + this.address));
                return new CommandResult(MESSAGE_SUCCESS);
            } catch (IOException e) {
                e.printStackTrace();
                return new CommandResult(MESSAGE_FAILURE);
            } catch (URISyntaxException e) {
                e.printStackTrace();
                return new CommandResult(MESSAGE_FAILURE);
            }
        } else {
            return new CommandResult(MESSAGE_CANNOT_FIND);
        }

    }




}
