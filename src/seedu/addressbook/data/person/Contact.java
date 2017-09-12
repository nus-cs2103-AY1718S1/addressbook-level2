package seedu.addressbook.data.person;

public class Contact {
    public static final String ADDRESS_EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final String PHONE_EXAMPLE = "123456789";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    public static final String EMAIL_EXAMPLE = "valid@e.mail";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";


    private boolean isPrivate;

    public boolean isPrivate() {
        return isPrivate;
    }

    public static boolean isValidContact(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX)||test.matches(PHONE_VALIDATION_REGEX)||test.matches(EMAIL_VALIDATION_REGEX);
    }

}
