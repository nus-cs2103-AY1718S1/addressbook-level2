package seedu.addressbook.ui;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */



    private static final String LINE_PREFIX = "|| ";
    /** A platform independent line separator. */
    private static final String DIVIDER = "===================================================";


    private static final String LS = System.lineSeparator();


    public String getCommand(){
        return LINE_PREFIX + "Enter command: ";
    }

    public String getMessage(String m){
        return LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX);
    }

    public String getCommandEntered(String fullInputLine){
        return "[Command entered:" + fullInputLine + "]";
    }

    public String getDivider(){
        return DIVIDER;
    }
}
