package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.*;

import static seedu.addressbook.commands.Command.getMessageForPersonListShownSummary;

public class FindtagCommand extends Command{

    public static final String COMMAND_WORD = "findtag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose tag contain any of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: TAGKEYWORD\n"
            + "Example: " + COMMAND_WORD + " friends";

    private final String keyword;

    public FindtagCommand(String keyword) {
        keyword = keyword.trim();
        this.keyword = keyword;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public String getKeywords() {
        return keyword;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingTag(keyword);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param tag for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingTag(String tag) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
           Iterator<Tag> iterator = person.getTags().iterator();
           while(iterator.hasNext()){
               if(iterator.next().tagName.equals(tag)){
                   matchedPersons.add(person);
                   break;
               }
           }

        }
        return matchedPersons;
    }

}
