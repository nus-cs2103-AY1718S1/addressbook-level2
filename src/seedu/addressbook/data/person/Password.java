package seedu.addressbook.data.person;


public class Password {

    public final String password;

    /**
     * Validates password.
     *
     */
    public Password(String password) {

        String trimmedPwd = password.trim();
        this.password = trimmedPwd;

    }

    @Override
    public String toString() {
        return this.password;
    }


}
