package seedu.addressbook.commands;
import seedu.addressbook.data.exception.IllegalValueException;

import java.util.concurrent.ThreadLocalRandom;


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
    public static final String MESSAGE_WHY_3 = "Because CS2103/T is cool";
    public static final String MESSAGE_WHY_4 = "Because we are cool potatoes";
    public static final String MESSAGE_WHY_5 = "Because the world is round";
    public static final String MESSAGE_WHY_6 = "Because the tall software engineer told you so";
    public static final String MESSAGE_WHY_7 = "Because 911 was in inside job";
    public static final String MESSAGE_WHY_8 = "idk";
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
        }
        /*int min = 1;
        int max = 8;

        int r = ThreadLocalRandom.current().nextInt(min, max);
        switch (r) {
            case 1:
                MESSAGE_WHY = MESSAGE_WHY_1;
                break;
            case 2:
                MESSAGE_WHY = MESSAGE_WHY_2;
                break;
            case 3:
                MESSAGE_WHY = MESSAGE_WHY_3;
                break;
            case 4:
                MESSAGE_WHY = MESSAGE_WHY_4;
                break;
            case 5:
                MESSAGE_WHY = MESSAGE_WHY_5;
                break;
            case 6:
                MESSAGE_WHY = MESSAGE_WHY_6;
                break;
            case 7:
                MESSAGE_WHY = MESSAGE_WHY_7;
                break;
            case 8:
                MESSAGE_WHY = MESSAGE_WHY_8;
                break;
            default:
                MESSAGE_WHY = "Exception handling";
                break;

        }*/
        return new CommandResult(MESSAGE_WHY);
    }

}