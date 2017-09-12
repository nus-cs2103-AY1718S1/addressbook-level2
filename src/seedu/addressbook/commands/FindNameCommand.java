package seedu.addressbook.commands;

import java.util.*;


import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindNameCommand extends Command{
    public static final String COMMAND_WORD = "findName";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";


    private Set<String> keywords;
    public FindNameCommand(String prekeywords){
        String[] keywordsList = prekeywords.toLowerCase().split(" ");
        this.keywords = new HashSet<>(Arrays.asList(keywordsList));

    }
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeywordIgnoreCase(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeywordIgnoreCase(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            String[] nameSet = person.getName().toString().toLowerCase().split(" ");
            final Set<String> wordsInName = new HashSet<>(Arrays.asList(nameSet));

            if (!Collections.disjoint(wordsInName, keywords)) {
                matchedPersons.add(person);

            }
        }
        return matchedPersons;
    }



}
