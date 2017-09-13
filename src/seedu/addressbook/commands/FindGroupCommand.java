package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class FindGroupCommand extends Command{
    public static final String COMMAND_WORD = "findgroup";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Find all persons who are in the group with "
            + "the specified group name (case-sensitive) and display them as a list with index numbers. \n"
            + "Parameters: [Group Name] \n"
            + "Example: " + COMMAND_WORD + " family";
    private final Set<String> groupname;
    public FindGroupCommand (Set<String> groupname) { this.groupname = groupname; }

    public Set<String> getGroupname () { return new HashSet<>(groupname); }

    @Override
    public CommandResult execute () {
        final List<ReadOnlyPerson> personsFound = getPersonsInGroup(groupname);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    private List<ReadOnlyPerson> getPersonsInGroup (Set<String> groupname) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for(ReadOnlyPerson person : addressBook.getAllPersons()){
            final Set<String> GroupName = new HashSet<>(person.getGroup().getGroupName());
            if(!Collections.disjoint(GroupName, groupname)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
