package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Print list of people who have the tage.
 */


public class TagCommand extends Command {
    public static final String COMMAND_WORD = "tag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays all persons in address book with tag.\n"
            +  "Parameters: TAG NAME\n"
            + "Example: " + COMMAND_WORD + " friends";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_FAIL = "Nobody with such tag";
    private final Set<String> tags;

    public TagCommand(Set<String> tags) {
        this.tags = tags;
    }
    /**
     * Returns a copy of tags in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(tags);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTags(tags);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }
    /**
     * Retrieves all persons in the address book who has these tags.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTags(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for(String tag: keywords){
            for (ReadOnlyPerson person : addressBook.getAllPersons()) {
                UniqueTagList tagList = person.getTags();
                for (Tag s : tagList) {
                    if ((s.getTagName()).equals(tag) && !matchedPersons.contains(person)) {
                        matchedPersons.add(person);
                        break;
                    }
                }
            }
        }
        return matchedPersons;
    }

}
