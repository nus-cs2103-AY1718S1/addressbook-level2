package seedu.addressbook.state;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class ApplicationState {
    
    private AddressBook addressbook;
    private List<ReadOnlyPerson> lastShownList;
    
    public ApplicationState(AddressBook addressBook, List<? extends ReadOnlyPerson> lastShownList) {
        this.addressbook = addressBook.clone();
        this.lastShownList = new ArrayList<>(lastShownList);
    }
    
    public AddressBook getAddressBookInState() {
        return addressbook;
    }

    public List<ReadOnlyPerson> getListingInState() {
        return lastShownList;
    }
}