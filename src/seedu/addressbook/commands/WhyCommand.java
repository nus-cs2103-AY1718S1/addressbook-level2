package seedu.addressbook.commands;


/**
 * Tells you why.
 */
public class WhyCommand extends Command {

    public static final String COMMAND_WORD = "why";

    public static String question;

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Tells you why not, why though...etc.\n"
            + "Example: " + COMMAND_WORD +" not";
    public static final String MESSAGE_WHY_NOT = "Because you can do it :)";
    public static final String MESSAGE_WHY_THOUGH = "Because you should not give up :)";
    public static final String MESSAGE_WHY_THIS = "Because CS2103/T is cool";
    public static final String MESSAGE_WHY_THAT = "Because we are cool potatoes";
    public static final String MESSAGE_WHY_MAN = "Because the world is round";
    public static final String MESSAGE_WHY_LEH = "Because the tall software engineer told you so";
    public static final String MESSAGE_WHY_ASK = "Because 911 was in inside job";
    public static final String MESSAGE_WHY_DEFAULT = "I'm sorry, my responses are limited, you must ask the right questions";
    public static String MESSAGE_WHY = "";


    public WhyCommand(String question) {this.question = question;}

    @Override
    public CommandResult execute() {
        switch (question) {
            case "not":
                MESSAGE_WHY = MESSAGE_WHY_NOT;
                break;
            case "though":
                MESSAGE_WHY = MESSAGE_WHY_THOUGH;
                break;
            case "this":
                MESSAGE_WHY = MESSAGE_WHY_THIS;
            case "that":
                MESSAGE_WHY = MESSAGE_WHY_THAT;
            case "man":
                MESSAGE_WHY = MESSAGE_WHY_MAN;
            case "leh":
                MESSAGE_WHY = MESSAGE_WHY_LEH;
            case "ask":
                MESSAGE_WHY = MESSAGE_WHY_ASK;
            default:
                MESSAGE_WHY = MESSAGE_WHY_DEFAULT;
        }

        return new CommandResult(MESSAGE_WHY);
    }

}