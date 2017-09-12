package seedu.addressbook.data.person;

public class Username {

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
}
