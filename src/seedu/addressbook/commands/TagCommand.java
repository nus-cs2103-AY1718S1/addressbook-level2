package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.HashSet;
import java.util.Set;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class TagCommand extends Command {

    public static final String COMMAND_WORD = "tag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds the specified keywords as tags to the profile "
            + "of the person with the given index number.\n"
            + "Parameters: INDEX [TAGS]...\n"
            + "Example: " + COMMAND_WORD + " 1 t/best friend";

    public static final String MESSAGE_TAG_PERSON_SUCCESS = "Tagged Person: %1$s (Not yet actually!)";

    private final Set<String> tags;

    public TagCommand (int targetVisibleIndex, Set<String> tags) {
        super(targetVisibleIndex); //set target user index using super constructor
        this.tags = tags;
    }



    /**
     * Returns a copy of tags in this command.
     *
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }
     */

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            return new CommandResult(String.format(MESSAGE_TAG_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }// catch (UniquePersonList.PersonNotFoundException pnfe) {
         //   return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        //}

        //final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        //return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
        //return new CommandResult(MESSAGE_USAGE);
    }
}