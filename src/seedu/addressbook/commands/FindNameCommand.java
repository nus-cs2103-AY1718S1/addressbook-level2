package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindNameCommand extends Command{
    public static final String COMMAND_WORD = "findName";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";


    private String keywords;
    private String modifiedKeywords;
    public FindNameCommand(Set<String> keywords){
        this.keywords = keywords.toString().toLowerCase();
    }
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeywordIgnoreCase(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeywordIgnoreCase(String keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final String wordsInName = person.getName().getWordsInName().toString().toLowerCase();

            if (wordsInName.substring(1, wordsInName.length()-1).contains(keywords.substring(1, keywords.length()-1))) {
                matchedPersons.add(person);

            }
        }
        return matchedPersons;
    }



}
