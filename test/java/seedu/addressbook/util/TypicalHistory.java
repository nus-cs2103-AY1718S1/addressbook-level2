package seedu.addressbook.util;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.state.ApplicationHistory;
import seedu.addressbook.state.ApplicationState;

import java.lang.reflect.Field;
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
    private int forwardOperations = 0;

    public TypicalHistory() {
        try {
            
            // simulate add all persons in typical : 4 commands total
            for (Person p : personsToTest) {
                addPersonToAddressBook(p);
            }
            
            // simulate list command : 5 now
            listAddressBook();
            
            // simulate find command : 6 now
            findPersonsInAddressBook(samplePersons.amy, samplePersons.candy);
            
            // simulate delete all persons in typical : 10 now
            for (Person p : personsToTest) {
                deletePersonInAddressBook(p);
            }

            // simulate list command : 11 now
            listAddressBook();

            // simulate add back all persons in typical : 15 now
            for (Person p : personsToTest) {
                addPersonToAddressBook(p);
            }

            // validate history size or throw exception - i.e. we have to rewrite tests
            Field maxSizeField = typicalHistory.getClass().getDeclaredField("MAX_HISTORY_SIZE");
            maxSizeField.setAccessible(true);
            int maxSize = (int) maxSizeField.get(typicalHistory);
            if (forwardOperations > maxSize) {
                assert false : "Number of operations in creating a new TypicalHistory exceed the specified amount in MAX_HISTORY_SIZE";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "failed to create new typical history";
        }
    }

    private void addPersonToAddressBook(Person p) throws UniquePersonList.DuplicatePersonException {
        typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
        sampleAddressbook.addPerson(p);
        typicalHistory.updateStateAfterSuccessfulOperation();
        forwardOperations++;
    }

    private void deletePersonInAddressBook(Person p) throws UniquePersonList.PersonNotFoundException {
        typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
        sampleAddressbook.removePerson(p);
        typicalHistory.updateStateAfterSuccessfulOperation();
        forwardOperations++;
    }

    private void findPersonsInAddressBook(Person... people) {
        typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
        Set<String> findWords = new HashSet<>();
        for (Person p : people) {
            findWords.add(p.getName().fullName);
        }
        lastShownList = getPersonsWithNameContainingAnyKeyword(findWords);
        typicalHistory.updateStateAfterSuccessfulOperation();
        forwardOperations++;
    }

    private void listAddressBook() {
        typicalHistory.saveStateBeforeOperation(new ApplicationState(sampleAddressbook, lastShownList));
        lastShownList = sampleAddressbook.getAllPersons().immutableListView();
        typicalHistory.updateStateAfterSuccessfulOperation();
        forwardOperations++;
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
