package seedu.addressbook.commands;

public class EditCommand extends Command {
    public static final CharSequence PHONE_PREFIX = "p/";
    public static final CharSequence EMAIL_PREFIX = "e/";
    public static final CharSequence ADDRESS_PREFIX = "a/";

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person's particulars in the address book. "
            + "Can edit any particulars from a contact by prefixing p/ or e/ or a/ in front of the particulars\n"
            + "Parameters: index p/PHONE e/EMAIL a/ADDRESS (ALL DETAILS CAN BE EDITED AT ONCE OR SEPARATELY\n"
            + "Example: " + COMMAND_WORD
            + " 1 p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25";
    public static final String MESSAGE_SUCCESS = "SUCCESSFULLY EDITED ";
    private String phone = null;
    private String email = null;
    private String address = null;
    private int Target_Index;

    public EditCommand(String args) {
        String Truncated_String;
        Truncated_String = args.substring(0, args.indexOf(" "));
        args = args.substring(args.indexOf(" ") + 1);
        this.Target_Index = Integer.parseInt(Truncated_String.trim()) - 1;

        if (args.contains(PHONE_PREFIX)) {
            this.phone = args.substring(args.indexOf(PHONE_PREFIX.toString()) + 2, indexDeterminant(args));
            args = args.substring(indexDeterminant(args)).trim();
        }
        if (args.contains(EMAIL_PREFIX)) {
            this.email = args.substring(args.indexOf(EMAIL_PREFIX.toString()) + 2, indexDeterminant(args));
            args = args.substring(indexDeterminant(args)).trim();
        }
        if (args.contains(ADDRESS_PREFIX)) {
            this.address = args.substring(args.indexOf(ADDRESS_PREFIX.toString()) + 2, args.length());
        }
    }

    public int indexDeterminant(String args) {
        int index = args.indexOf(" ");
        if (index > 0) {
            return index;
        } else {
            return args.length();
        }
    }

    @Override
    public CommandResult execute() {
        String MESSAGE = MESSAGE_SUCCESS;
        if(this.phone != null){
            addressBook.editPhoneBook(Target_Index, phone);
            MESSAGE = MESSAGE + "PHONE ";
        }
        if (this.email != null) {
            addressBook.editEmailBook(Target_Index, email);
            MESSAGE = MESSAGE + "EMAIL ";
        }
        if (this.address != null) {
            addressBook.editAddressBook(Target_Index, address);
            MESSAGE = MESSAGE + "ADDRESS ";
        }
        return new CommandResult(MESSAGE);
    }
}