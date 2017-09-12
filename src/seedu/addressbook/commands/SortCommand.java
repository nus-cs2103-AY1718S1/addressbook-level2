package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_ADDRESS = "address";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted list with index numbers.\n"
            + "Example: " + COMMAND_WORD + "[name/phone/email]";

    public static PersonComparator sortType;
    final List<ReadOnlyPerson> preSortedList = new ArrayList<ReadOnlyPerson>();


    public SortCommand(PersonComparator sortType){
        this.sortType = sortType;
    }

    public void createPreSortedList(){
        preSortedList.clear();
        preSortedList.addAll(addressBook.getAllPersons().immutableListView());
    }


    @Override
    public CommandResult execute() {

        List<ReadOnlyPerson> persons = getSortedList();
        return new CommandResult(getMessageForPersonListShownSummary(persons), persons);
    }

    public List<ReadOnlyPerson> getSortedList(){
        createPreSortedList();
        preSortedList.sort(PersonComparator.getComparator(sortType));
        List<ReadOnlyPerson> sortedPersons = preSortedList;
        return sortedPersons;
    }

    public enum PersonComparator implements Comparator<ReadOnlyPerson> {
        BY_NAME{
            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2){
                String name1 = String.valueOf(p1.getName().toString());
                String name2 = String.valueOf(p2.getName().toString());
                return name1.compareTo(name2);
            }
        },
        BY_PHONE{
            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2){
                Integer phone1 = Integer.parseInt(p1.getPhone().toString());
                Integer phone2 = Integer.parseInt(p2.getPhone().toString());
                return phone1.compareTo(phone2);
            }
        },
        BY_EMAIL{

            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2){
                String email1 = String.valueOf(p1.getEmail().toString());
                String email2 = String.valueOf(p2.getEmail().toString());
                return email1.compareTo(email2);
            }
        },

        BY_ADDRESS{

            public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2){
                String address1 = String.valueOf(p1.getAddress().toString());
                String address2 = String.valueOf(p2.getAddress().toString());
                return address1.compareTo(address2);
            }
        };

        public static Comparator<ReadOnlyPerson> getComparator(final PersonComparator sortType){
            return new Comparator<ReadOnlyPerson>() {
                @Override
                public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
                    return sortType.compare(p1, p2);
                }
            };
        }
    }
}
