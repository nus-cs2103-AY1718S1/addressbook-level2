package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.*;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindTagCommand extends Command {

    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified tags (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " friends family enemy";

    private final Set<String> tags;

    public FindTagCommand(Set<String> tags) {
        this.tags = tags;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getTags() {
        return new HashSet<>(tags);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTheseTags(tags);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param tags for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTheseTags(Set<String> tags) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for(String tag: tags) {
            for (ReadOnlyPerson person : addressBook.getAllPersons()) {
                for (Tag s : person.getTags()) {
                    boolean doesTagMatches = s.getTagName().equals(tag);
                    boolean isDuplicate = matchedPersons.contains(person);
                    if (doesTagMatches && !isDuplicate){
                        matchedPersons.add(person);
                        break;
                    }
                }
            }
        }
        return matchedPersons;
    }

}
