/**
 * NUS School of Computing | Computer Science
 * - - - - - - - - - - - - - - - -
 * Name		 	: Ong Yong Siang
 * Matric No.	: A0156051N
 * - - - - - - - - - - - - - - - -
 */
package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCommand extends Command {
	
    public static final String COMMAND_WORD = "sort";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted (A~Z in ascending order) list with index numbers.\n"
            + "Example: " + COMMAND_WORD;
    
	class NameComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2) {
			// Compares its two arguments for order by name
			return p1.getName().toString().compareTo(p2.getName().toString());
		}

		public boolean equals(Object obj) {
			// Simply checks to see if we have the same object
			return this == obj;
		}
	}
    
    @Override
    public CommandResult execute() {
    	List<Person> allPersons = addressBook.getAllPersons().mutableListView();
    	NameComparator nameComp = new NameComparator();
    	Collections.sort(allPersons, nameComp);
    	return new CommandResult(getMessageForPersonSortedListShownSummary(allPersons), allPersons);
    }
}
