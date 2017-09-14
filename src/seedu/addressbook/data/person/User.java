package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private Username username;
    private Password password;
    private Date loginDate;

    public User(){}

    public User(String username, String password){
        this.username = new Username(username);
        this.password = new Password(password);
        this.loginDate = new Date();
    }

    public User(Username username, UniquePersonList personLists){
        this.username = username;
    }

    public User(Username username, Date loginDate){

        this.username = username;
        /* Instantiate a Date object */
        this.loginDate = loginDate;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(username);
    }

    public Username getUsername() {
        return this.username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public Password getPassword(){return this.password;}

    /* Return login date */
    public String getloginDate(){ return this.loginDate.toString(); }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getUsername());
        builder.append(". Login Date: ");
        builder.append(getloginDate());
        return builder.toString();
    }

}
