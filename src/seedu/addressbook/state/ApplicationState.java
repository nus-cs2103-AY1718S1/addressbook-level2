package seedu.addressbook.state;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class ApplicationState {
    AddressBook addressbook;
    List<? extends ReadOnlyPerson> lastShownList;
    String commandResult;
    ApplicationState(AddressBook addressBook, List<? extends ReadOnlyPerson> lastShownList, String commandResult) {
        this.addressbook = addressBook;
        this.lastShownList = lastShownList;
        this.commandResult = commandResult;
    }

    String getDifferences(ApplicationHistory.ApplicationState other) {
        return null;
    }
}
