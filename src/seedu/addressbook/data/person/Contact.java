package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {


    public final String value;
    private boolean isPrivate;


    public Contact(String value, boolean isPrivate, String regex, String constraint) throws IllegalValueException{
        if(!isValid(value,regex)){
            throw new IllegalValueException(constraint);
        }
        this.value = value;
        this.isPrivate = isPrivate;
    }


    public String toString(){
        return value;
    }

    public boolean isPrivate(){
        return isPrivate;
    }

    public int hashCode(){
        return value.hashCode();
    }

    public static boolean isValid(String value, String regex){
        return value.matches(regex);
    }
}
