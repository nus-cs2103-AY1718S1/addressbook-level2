package seedu.addressbook.util;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;

import java.util.*;

import static seedu.addressbook.util.TestUtil.createEmptyApplicationHistory;

public class TypicalHistory {
    public ApplicationHistory typicalHistory = createEmptyApplicationHistory();
    AddressBook sampleAddressbook = new AddressBook();
    TypicalPersons samplePersons = new TypicalPersons();
    List<? extends ReadOnlyPerson> lastShownList = Collections.emptyList();
    List<Person> personsToTest = new ArrayList<>(Arrays.asList(samplePersons.amy,
                                                                samplePersons.bill,
                                                                samplePersons.candy,
                                                                samplePersons.dan));
    
    public TypicalHistory() {
        try {
            
            // simulate add all persons in typical
            for (Person p : personsToTest) {
                typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
                sampleAddressbook.addPerson(p);
                typicalHistory.updateStateAfterSuccessfulOperation();
            }
            
            // simulate list command
            typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
            lastShownList = sampleAddressbook.getAllPersons().immutableListView();
            typicalHistory.updateStateAfterSuccessfulOperation();
            
            // simulate find command
            typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
            Set<String> findWords = new HashSet<>();
            findWords.add(samplePersons.amy.getName().fullName);
            findWords.add(samplePersons.candy.getName().fullName);
            lastShownList = getPersonsWithNameContainingAnyKeyword(findWords);
            typicalHistory.updateStateAfterSuccessfulOperation();
            
            // simulate delete all persons in typical
            for (Person p : personsToTest) {
                typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
                sampleAddressbook.removePerson(p);
                typicalHistory.updateStateAfterSuccessfulOperation();
            }

            // simulate list command
            typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
            lastShownList = sampleAddressbook.getAllPersons().immutableListView();
            typicalHistory.updateStateAfterSuccessfulOperation();
            
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "failed to create new typical history";
        }
    }

    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : sampleAddressbook.getAllPersons()) {
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }
}
