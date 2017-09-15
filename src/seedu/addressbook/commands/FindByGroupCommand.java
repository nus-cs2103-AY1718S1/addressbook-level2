package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Finds and lists the names of all persons in address book who belong to a particular social group.
 * Group searching is case sensitive.
 */
public class FindByGroupCommand extends Command{

    public static final String COMMAND_WORD = "findByGroup";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons who belong to the same group "
            + "using the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: GROUP [MORE_GROUPS]...\n"
            + "Example: " + COMMAND_WORD + " work friends";

    private final Set<String> groupKeywords;

    public FindByGroupCommand(Set<String> keywords) {
        this.groupKeywords = keywords;
    }

    /**
     * Returns a copy of group types in this command.
     */
    public Set<String> getGroupKeywords() {
        return new HashSet<>(groupKeywords);
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithGroupContainingAnyKeyword(groupKeywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names correspond to the those in the social groups specified.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithGroupContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            if (keywords.contains(person.getGroup().getGroupName())) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
