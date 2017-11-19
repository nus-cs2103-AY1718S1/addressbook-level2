package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindEmailCommand extends Command 
{
	
	 public static final String COMMAND_WORD = "findemail";

	    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose email contain any of "
	            + "the specified keywords (non case-sensitive) and displays them as a list with index numbers.\n"
	            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
	            + "Example: " + COMMAND_WORD + " alice@mail";

	    protected final String keywords;

	    public FindEmailCommand(String keywords) 
	    {
	    	int indexOfAt = keywords.indexOf("@");
	        this.keywords = keywords.substring(0, indexOfAt);
	    }

	    /**
	     * Returns a copy of keywords in this command.
	     */
	    public String getKeywords() {
	        return this.keywords;
	    }

	    @Override
	    public CommandResult execute() {
	        final List<ReadOnlyPerson> personsFound = getPersonsWithEmail(keywords);
	        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
	    }

	    
	    private List<ReadOnlyPerson> getPersonsWithEmail(String keywords) 
	    {
	    	boolean match = false;
	    	 final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
	         for (ReadOnlyPerson person : addressBook.getAllPersons()) {
	        	 final Set<String> emailsInName = new HashSet<>(person.getEmail().getEmailInSearch());
	        	 
	        	 for (String emailInFull : emailsInName)
	             	if (emailInFull.contains(keywords)) 
	             	{
	             		match = true;
	             		break;
	             	}
	        	 
	        	 if (match)
	             	matchedPersons.add(person);
	        	 
	        
	     }
	         return matchedPersons;
	    }
}
