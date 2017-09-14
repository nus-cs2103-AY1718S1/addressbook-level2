package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.*;

public class FindTagCommand extends Command {

    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose tags contain any of "
            + "the specified tags (not case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: TAG [MORE_TAGS]...\n"
            + "Example: " + COMMAND_WORD + " friends family";

    private final Set<String> keywords;

    public FindTagCommand(Set<String> keywords) { this.keywords = keywords; }

    public Set<String> getKeywords() { return new HashSet<>(keywords); }

    private Set<Tag> getMatchedTags() {
        Iterator<Tag> tagIterator = addressBook.getAllTags().iterator();
        List<Tag> matchedTags = new ArrayList<Tag>();

        while (tagIterator.hasNext()) {
            Tag checkingTag = tagIterator.next();
            for (String keyword: keywords) {
                if (checkingTag.tagName.toLowerCase().equals(keyword.toLowerCase())) {
                    matchedTags.add(checkingTag);
                }
            }
        }
        return new HashSet<Tag>(matchedTags);
    }

    @Override
    public CommandResult execute() {
        final Set<Tag> matchedTags = getMatchedTags();
        final List<ReadOnlyPerson> personsFound = getPersonWithTag(matchedTags);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    private List<ReadOnlyPerson> getPersonWithTag(Set<Tag> matchedTags) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person: addressBook.getAllPersons()) {
            final Set<Tag> personTags = person.getTags().toSet();
            if (!Collections.disjoint(personTags, matchedTags)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
