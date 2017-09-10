package seedu.addressbook.parser;

import seedu.addressbook.commands.HelpCommand;
import seedu.addressbook.commands.IncorrectCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.addressbook.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

public class parseCommandMethod {

    public static final int NUMBER_ONE = 1;
    public static final int NUMBER_ZERO = 0;
    String userInput;
    String commandWord;
    String commandArg;
    public static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    public parseCommandMethod (String userInput) {
        this.userInput = userInput;
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            commandWord = "-1";
            commandArg = "-1";
        }
        else {
            commandWord = matcher.group("commandWord");
            commandArg = matcher.group("arguments");
        }

    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getCommandArg() {
        return commandArg;
    }


}
