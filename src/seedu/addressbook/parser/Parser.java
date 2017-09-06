package seedu.addressbook.parser;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.addressbook.common.Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.commands.AddCommand;
import seedu.addressbook.commands.ClearCommand;
import seedu.addressbook.commands.Command;
import seedu.addressbook.commands.DeleteCommand;
import seedu.addressbook.commands.EditCommand;
import seedu.addressbook.commands.ExitCommand;
import seedu.addressbook.commands.FindCommand;
import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.commands.IncorrectCommand;
import seedu.addressbook.commands.ListCommand;
import seedu.addressbook.commands.ViewAllCommand;
import seedu.addressbook.commands.ViewCommand;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Parses user input.
 */
public class Parser {

    public static final Pattern PERSON_INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>.+)");

    public static final Pattern KEYWORDS_ARGS_FORMAT =
            Pattern.compile("(?<keywords>\\S+(?:\\s+\\S+)*)"); // one or more keywords separated by whitespace

    public static final Pattern PERSON_DATA_ARGS_FORMAT = // '/' forward slashes are reserved for delimiter prefixes
            Pattern.compile("(?<name>[^/]+)"
                    + " (?<isPhonePrivate>p?)p/(?<phone>[^/]+)"
                    + " (?<isEmailPrivate>p?)e/(?<email>[^/]+)"
                    + " (?<isAddressPrivate>p?)a/(?<address>[^/]+)"
                    + "(?<tagArguments>(?: t/[^/]+)*)"); // variable number of tags


    /**
     * Signals that the user input could not be parsed.
     */
    public static class ParseException extends Exception {
        ParseException(String message) {
            super(message);
        }
    }

    /**
     * Used for initial separation of command word and args.
     */
    public static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    public Parser() {}

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    public static Command parseCommand(String userInput) {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return prepareAdd(arguments);

        case DeleteCommand.COMMAND_WORD:
            return prepareDelete(arguments);

        case EditCommand.COMMAND_WORD:
            return prepareEdit(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return prepareFind(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ViewCommand.COMMAND_WORD:
            return prepareView(arguments);

        case ViewAllCommand.COMMAND_WORD:
            return prepareViewAll(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD: // Fallthrough
        default:
            return new HelpCommand();
        }
    }

    /**
     * Parses arguments in the context of the add person command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareAdd(String args) {
        final Matcher matcher = PERSON_DATA_ARGS_FORMAT.matcher(args.trim());
        // Validate arg string format
        if (!matcher.matches()) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }
        try {
            return new AddCommand(
                    matcher.group("name"),

                    matcher.group("phone"),
                    isPrivatePrefixPresent(matcher.group("isPhonePrivate")),

                    matcher.group("email"),
                    isPrivatePrefixPresent(matcher.group("isEmailPrivate")),

                    matcher.group("address"),
                    isPrivatePrefixPresent(matcher.group("isAddressPrivate")),

                    getTagsFromArgs(matcher.group("tagArguments"))
            );
        } catch (IllegalValueException ive) {
            return new IncorrectCommand(ive.getMessage());
        }
    }

    /**
     * Returns true if the private prefix is present for a contact detail in the add command's arguments string.
     */
    private static boolean isPrivatePrefixPresent(String matchedPrefix) {
        return matchedPrefix.equals("p");
    }

    /**
     * Extracts the new person's tags from the add command's tag arguments string.
     * Merges duplicate tag strings.
     */
    private static Set<String> getTagsFromArgs(String tagArguments) throws IllegalValueException {
        // no tags
        if (tagArguments.isEmpty()) {
            return Collections.emptySet();
        }
        // replace first delimiter prefix, then split
        final Collection<String> tagStrings = Arrays.asList(tagArguments.replaceFirst(" t/", "").split(" t/"));
        return new HashSet<>(tagStrings);
    }


    /**
     * Parses arguments in the context of the delete person command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareDelete(String args) {
        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args);
            return new DeleteCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        } catch (NumberFormatException nfe) {
            return new IncorrectCommand(MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

    /**
     * Parses arguments in the context of the edit person command.
     * Parses the index out the parses the rest out as a hash map using the parseEditArgumentsAsHashMap function
     * @param args - a String to be parsed
     * @return the correct arguments to be passed to the edit command
     */
    private static Command prepareEdit(String args) {
        // First step: trim the input String
        args = args.trim();
        try {
            // Second step: get the index and sliced the rest as a String args whole
            int indexConcerned = Integer.parseInt(args.substring(0, 1));
            String nextParsedArgs = args.substring(2);
            HashMap<String, String> nextParsedHashMap = parseEditArgumentsAsHashMap(nextParsedArgs);

            // Third step: return to the EditCommand mechanism operations
            return new EditCommand(indexConcerned, nextParsedHashMap);
        } catch (StringIndexOutOfBoundsException e){
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        } catch (NumberFormatException f){
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
        }
    }

    /**
     * This function use the String args passed in and try to find the hashing between keys
     * defined and the values the users want to update
     * Definition for keys and values:
     * "n/" the key for updating name, value of which will be used to construct Name object
     * "e/" the key for updating email, value of which will be used to construct Email object
     * "p/" the key for updating phone number, value of which will be used to construct Phone object
     * "a/" the key for updating address, value of which will be again parsed by address class (to four components)
     * "t/" the key for adding tags
     * "T/" the key for deleting tags
     * @param args, the string input argument to be fragmented
     * @return the hashMap of key value pair
     */
    private static HashMap<String, String> parseEditArgumentsAsHashMap (String args) {
        //First Step: trim the string, initialization
        args = args.trim();
        HashMap<String, String> resultParsedHashMap = new HashMap<>();

        //Second Step: split the string and use loop to record relevant updating information
        String[] splitBySlashArray = args.split("/");
        int i = 1;
        String keyInConcern = splitBySlashArray[0];
        while ( i < splitBySlashArray.length) {
            if (i != splitBySlashArray.length - 1) {
                String valueForKey = splitBySlashArray[i].substring(0, splitBySlashArray[i].length() - 1).trim();

                // Take special care for tags - to edit the valueForKey with previous record
                if (keyInConcern.equals("t") || keyInConcern.equals("T")) {
                    if (resultParsedHashMap.get(keyInConcern) != null) {
                        valueForKey = resultParsedHashMap.get(keyInConcern)+","+valueForKey;
                    }
                }

                String keyUpdate = splitBySlashArray[i].substring(splitBySlashArray[i].length()-1);
                resultParsedHashMap.put(keyInConcern, valueForKey);
                keyInConcern = keyUpdate;

                i++; //updating to the next i

            } else {
                String valueForKey = splitBySlashArray[i].trim();

                // Take special care for tags - to edit the valueForKey with previous record
                if (keyInConcern.equals("t") || keyInConcern.equals("T")) {
                    if (resultParsedHashMap.get(keyInConcern) != null) {
                        valueForKey = resultParsedHashMap.get(keyInConcern)+","+valueForKey;
                    }
                }
                resultParsedHashMap.put(keyInConcern, valueForKey);
                break;
            }

        }

        return resultParsedHashMap;
    }


    /**
     * Parses arguments in the context of the view command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareView(String args) {

        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args);
            return new ViewCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewCommand.MESSAGE_USAGE));
        } catch (NumberFormatException nfe) {
            return new IncorrectCommand(MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

    /**
     * Parses arguments in the context of the view all command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareViewAll(String args) {

        try {
            final int targetIndex = parseArgsAsDisplayedIndex(args);
            return new ViewAllCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewAllCommand.MESSAGE_USAGE));
        } catch (NumberFormatException nfe) {
            return new IncorrectCommand(MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

    /**
     * Parses the given arguments string as a single index number.
     *
     * @param args arguments string to parse as index number
     * @return the parsed index number
     * @throws ParseException if no region of the args string could be found for the index
     * @throws NumberFormatException the args string region is not a valid number
     */
    private static int parseArgsAsDisplayedIndex(String args) throws ParseException, NumberFormatException {
        final Matcher matcher = PERSON_INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException("Could not find index number to parse");
        }
        return Integer.parseInt(matcher.group("targetIndex"));
    }


    /**
     * Parses arguments in the context of the find person command.
     *
     * @param args full command args string
     * @return the prepared command
     */
    private static Command prepareFind(String args) {
        final Matcher matcher = KEYWORDS_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    FindCommand.MESSAGE_USAGE));
        }

        // keywords delimited by whitespace
        final String[] keywords = matcher.group("keywords").split("\\s+");
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        return new FindCommand(keywordSet);
    }


}
