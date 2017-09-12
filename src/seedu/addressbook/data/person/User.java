package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.Date;
import java.util.Objects;

public class User{

    private Username username;
    private Password password;
    private Date loginDate;

    public User(UniqueTagList tags){
        super();
    }

    public User(Username username, Password password){

        this.username = username;
        this.password = password;
        // Instantiate a Date object
        this.loginDate = new Date();

    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(username, password);
    }

    public Username getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    /* Return login date */
    public String getloginDate(){ return this.loginDate.toString(); }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getUsername())
                .append(" Password: ");
        builder.append(getPassword())
                .append(" Login Date: ");
        builder.append(getloginDate());

        return builder.toString();
    }
}
