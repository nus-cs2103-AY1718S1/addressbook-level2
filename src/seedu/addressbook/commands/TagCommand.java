package seedu.addressbook.commands;

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

    private final Set<String> keywords;

    public TagCommand (Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }

    @Override
    public CommandResult execute() {
        //final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        //return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
        return new CommandResult(MESSAGE_USAGE);
    }
}