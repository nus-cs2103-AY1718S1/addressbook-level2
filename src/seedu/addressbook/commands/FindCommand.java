package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.Tag;

/**
 * Finds and lists all persons in address book whose name or tag contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-sensitive) or contains tag(s) specified and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS] t/TAG_NAME \n"
            + "Example: " + COMMAND_WORD + " alice bob charlie t/tag";

    private final Set<String> nameKeywords;
    private final Set<String> tagKeywords;

    public FindCommand(Set<String> nameKeywords, Set<String> tagKeywords) {
        this.nameKeywords = nameKeywords;
        this.tagKeywords = tagKeywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(nameKeywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(nameKeywords, tagKeywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param nameKeywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> nameKeywords, Set<String> tagKeywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();

        for (ReadOnlyPerson person : addressBook.getAllPersons()) {

            boolean isPersonAdded = false;
            final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());
            final UniqueTagList personTags = person.getTags();
            //check for matching name keyword
            for (String s : nameKeywords) {
                for (String w : wordsInName) {
                    if (w.startsWith(s)) {
                        if (!isPersonAdded) {
                            matchedPersons.add(person);
                            isPersonAdded = true;
                        }
                    }
                }
            }

            //check for tag if person has not been added
            if (!isPersonAdded) {
                for (String tag : tagKeywords) {
                    for (Tag personTag : personTags) {
                        if (personTag.tagName.equals(tag)) {
                            if (!isPersonAdded) {
                                matchedPersons.add(person);
                                isPersonAdded = true;
                            }
                        }
                    }
                }
            }

        }

        return matchedPersons;
    }

}
