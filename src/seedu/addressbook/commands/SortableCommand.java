package seedu.addressbook.commands;


import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Sortable superclass for implementing sort functionality for commands of listable type.
 */
public class SortableCommand extends Command {

    public static final String SORT_ASCENDING_POSTFIX_WORD = "asc";
    public static final String SORT_DESCENDING_POSTFIX_WORD = "desc";
    
    public static final int PRIVATE_COMPARATOR_VALUE = -1;
    
    /** The set of all possible sort arguments */
    public static final HashSet<String> POSSIBLE_SORT_ARGUMENTS = 
            new HashSet<>(Arrays.asList(Name.PREFIX,
                                        Phone.PREFIX,
                                        Email.PREFIX,
                                        Address.PREFIX,
                                        Name.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD),
                                        Phone.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD),
                                        Email.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD),
                                        Address.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD),
                                        Name.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD),
                                        Phone.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD),
                                        Email.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD),
                                        Address.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD)));
    
    /** Helptext for commands implementing sort functionality */
    public static final String SORT_USAGE = "[" + Name.PREFIX + "] " +
                                            "[" + Phone.PREFIX + "] " +
                                            "[" + Email.PREFIX + "] " + 
                                            "[" + Address.PREFIX + "] " +
                                            "[" + Name.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Phone.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Email.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Address.PREFIX.concat(SORT_DESCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Name.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Phone.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Email.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD) + "] " +
                                            "[" + Address.PREFIX.concat(SORT_ASCENDING_POSTFIX_WORD) + "]";
    
    private final List<String> sortArguments;
    
    public SortableCommand(List<String> sortArguments) {
        this.sortArguments = sortArguments;
    }
    
    public static boolean isValidSortArgument(String sortArgument) {
        return POSSIBLE_SORT_ARGUMENTS.contains(sortArgument);
    }

    private boolean hasSortArguments() {
        return sortArguments != null
                && !sortArguments.isEmpty();
    }
    
    /**
     * Returns a sorted list of ReadOnlyPerson using the declared String array of sort arguments
     * 
     * @param unsortedPersons an unordered or pre-ordered ArrayList of ReadOnlyPersons
     * @return a sorted list of ReadOnlyPersons
     */
    protected List<ReadOnlyPerson> getSortedPersons(List<ReadOnlyPerson> unsortedPersons) {
        if (!hasSortArguments()) {
            return unsortedPersons;
        }
        
        ArrayList<ReadOnlyPerson> sortedPersons = new ArrayList<>(unsortedPersons);

        // Using a multi-argument comparator, we implement sort by x then by y then by z... efficiently.
        sortedPersons.sort((person1, person2) -> {
            int c = 0;
            for (String sortArgument : sortArguments) {
                if (c != 0) {
                    return c;
                } else {
                    c = sortArgumentCompareValue(sortArgument, person1, person2);
                }
            }
            return c;
        });

        return sortedPersons;
    }

    /**
     * Returns an extended compareTo for two Person objects given a particular sort argument string.
     *
     * @param sortArgument string of sort argument prefix.
     * @param person1 first person to be compared to.
     * @param person2 other person to be compared to.
     * @return object.compareTo(other) value for the two persons or 0 if sort argument is invalid.
     */
    private static int sortArgumentCompareValue(String sortArgument, ReadOnlyPerson person1, ReadOnlyPerson person2) {
        switch (sortArgument) {
            case Name.PREFIX:
                return person1.getName().compareTo(person2.getName());
                
            case Phone.PREFIX:
                return person1.getPhone().compareTo(person2.getPhone());
                
            case Email.PREFIX:
                return person1.getEmail().compareTo(person2.getEmail());
                
            case Address.PREFIX:
                return person1.getAddress().compareTo(person2.getAddress());
                
            case Name.PREFIX + SORT_DESCENDING_POSTFIX_WORD:
                return person2.getName().compareTo(person1.getName());
                
            case Phone.PREFIX + SORT_DESCENDING_POSTFIX_WORD:
                return person2.getPhone().compareTo(person1.getPhone());
                
            case Email.PREFIX + SORT_DESCENDING_POSTFIX_WORD:
                return person2.getEmail().compareTo(person1.getEmail());
                
            case Address.PREFIX + SORT_DESCENDING_POSTFIX_WORD:
                return person2.getAddress().compareTo(person1.getAddress());
                
            case Name.PREFIX + SORT_ASCENDING_POSTFIX_WORD:
                return person1.getName().compareTo(person2.getName());
                
            case Phone.PREFIX + SORT_ASCENDING_POSTFIX_WORD:
                return person1.getPhone().compareTo(person2.getPhone());
                
            case Email.PREFIX + SORT_ASCENDING_POSTFIX_WORD:
                return person1.getEmail().compareTo(person2.getEmail());
                
            case Address.PREFIX + SORT_ASCENDING_POSTFIX_WORD:
                return person1.getAddress().compareTo(person2.getAddress());
                
            default:
                return 0;
        }
    }
}
