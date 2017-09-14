package seedu.addressbook.state;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

public class ApplicationState {
    
    private AddressBook addressbook;
    private List<ReadOnlyPerson> lastShownList;
    
    public ApplicationState(AddressBook addressBook, List<? extends ReadOnlyPerson> lastShownList) {
        this.addressbook = addressBook.clone();
        this.lastShownList = new ArrayList<>(lastShownList);
    }
    
    /**
     * Constructs a feedback message for a successful undo or redo command execution.
     *
     * @param previousState the address book of the previous state
     * @return difference between the two states.
     */
    public String getDifferencesMessage(ApplicationState previousState) {
        StringBuilder successfulMessageBuilder = new StringBuilder();

        // show added Persons not existing in previous
        for (Person person : addressbook.getAllPersons()) {
            if (!previousState.getAddressBookInState().containsPerson(person)) {
                successfulMessageBuilder.append("\n");
                successfulMessageBuilder.append(String.format(MESSAGE_ADDED, person.getAsTextHidePrivate()));
            }
        }
        
        // show Persons in previous not existing in current
        for (Person person : previousState.getAddressBookInState().getAllPersons()) {
            if (!addressbook.containsPerson(person)) {
                successfulMessageBuilder.append("\n");
                successfulMessageBuilder.append(String.format(MESSAGE_DELETED, person.getAsTextHidePrivate()));
            }
        }
        
        return successfulMessageBuilder.toString();
    }

    public AddressBook getAddressBookInState() {
        return addressbook;
    }

    public List<ReadOnlyPerson> getListingInState() {
        return lastShownList;
    }
}