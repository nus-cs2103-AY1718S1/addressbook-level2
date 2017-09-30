package seedu.addressbook.ui;


import static seedu.addressbook.common.Messages.*;
import java.util.List;
/**
 * Text UI of the application.
 */
public class Formatter {


    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";



    public static String promptCommand() {
        return LINE_PREFIX + "Enter command" ;

    }
    public static String promptCommandFeedback (String inputLine) {
        return "[Command entered:" + inputLine + "]";

    }


    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    public static boolean  isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }


    public static String  displayWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return String.join("\n",DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER );
    }

    public static String  displayGoodbyeMessage () {
        return  String.join("\n",MESSAGE_GOODBYE,DIVIDER,DIVIDER) ;
    }


    public static String  displayInitFailedMessage () {
        return  String.join("\n",MESSAGE_INIT_FAILED,DIVIDER,DIVIDER) ;
    }
    //#####


    /** Shows message(s) to the user */
    public static String showMessage (String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX) ;
    }

    /** Shows Result message(s) to the user */
    public static String showResultMessage (String result) {
        return String.join("\n",result,DIVIDER);
    }

    public  static String getIndexedListForViewingFomatter(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(String.format(MESSAGE_INDEXED_LIST_ITEM,displayIndex,listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
}

