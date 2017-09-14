package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;
import java.util.Arrays;
import java.util.List;

public class Birthday {

    public static final String EXAMPLE = "28/08/1994";
    public static final String BIRTHDAY_CONSTRAINT = "Birthday should be in the format dd/mm/yy";
    public static final String BIRTHDAY_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String birthday;
    public boolean isPrivate;


    public Birthday(String birth, boolean isPrivate) throws IllegalValueException{
        this.isPrivate = isPrivate;
        String trimmedBirthday = birth.trim();
        if(!isValidBirthday(trimmedBirthday)){
            throw new IllegalValueException(BIRTHDAY_VALIDATION_REGEX);
        }

        this.birthday = birth;
    }

    private boolean isValidBirthday(String test) {
        return test.matches(BIRTHDAY_VALIDATION_REGEX);
    }

    public List<String> getBirthdays(){
        return Arrays.asList(birthday.split("\\s+"));
    }

    @Override
    public String toString(){
        return birthday;
    }

    @Override
    public boolean equals(Object obj){

        return obj == this
                || (obj instanceof Birthday
                && this.birthday.equals(((Birthday) obj).birthday));
    }

    @Override
    public int hashCode(){
        return birthday.hashCode();
    }

    public boolean isPrivate(){
        return isPrivate;
    }
}
