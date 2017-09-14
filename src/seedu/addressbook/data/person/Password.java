package seedu.addressbook.data.person;


import java.io.Serializable;

public class Password implements Serializable {

    public final String password;

    /**
     * Initialize password
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
