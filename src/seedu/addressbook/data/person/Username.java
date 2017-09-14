package seedu.addressbook.data.person;

import java.io.Serializable;

public class Username implements Serializable {

    public final String username;

    /**
     * Validates given name.
     *
     * */
    public Username(String username){

        String trimmedName = username.trim();
        this.username = trimmedName;

    }

    @Override
    public String toString() {
        return this.username;
    }

    public String hasValue(){
        return this.username;
    }
}
