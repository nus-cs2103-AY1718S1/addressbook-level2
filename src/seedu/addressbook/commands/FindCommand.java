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

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names start with "
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
     * Retrieves all persons in the address book whose names start with specified keywords or who contain specified tag.
     *
     * @param nameKeywords for searching names
     * @param tagKeywords  for searching tags
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> nameKeywords, Set<String> tagKeywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();

        for (ReadOnlyPerson person : addressBook.getAllPersons()) {

            if (doesPersonNameContainKeywords(person, nameKeywords)) {
                matchedPersons.add(person);
            } else if (doesPersonContainTags(person, tagKeywords)) {
                matchedPersons.add(person);
            }

        }

        return matchedPersons;
    }

    /**
     * Returns true if a person's name contains any keyword as a prefix
     *
     * @param person
     * @param nameKeywords set of keywords
     * @return whether a person's name contains any keyword as a prefix
     */

    private boolean doesPersonNameContainKeywords(ReadOnlyPerson person, Set<String> nameKeywords) {
        final Set<String> wordsInName = new HashSet<>(person.getName().getWordsInName());

        for (String s : nameKeywords) {
            for (String w : wordsInName) {
                if (w.startsWith(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if a person contains any tag
     *
     * @param person
     * @param tagKeywords set of tags
     * @return whether a person contains any tag
     */

    private boolean doesPersonContainTags(ReadOnlyPerson person, Set<String> tagKeywords) {

        final UniqueTagList personTags = person.getTags();

        for (String tag : tagKeywords) {
            for (Tag personTag : personTags) {
                if (personTag.tagName.equals(tag)) {
                    return true;
                }
            }
        }

        return false;
    }

}
