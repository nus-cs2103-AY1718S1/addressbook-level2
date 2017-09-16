package seedu.addressbook.data.person;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.tag.UniqueTagList;

import java.util.Objects;

import static seedu.addressbook.data.person.Name.MESSAGE_NAME_CONSTRAINTS;
import static seedu.addressbook.data.person.Name.isValidName;
import static seedu.addressbook.data.person.Phone.MESSAGE_PHONE_CONSTRAINTS;
import static seedu.addressbook.data.person.Email.MESSAGE_EMAIL_CONSTRAINTS;
import static seedu.addressbook.data.person.Address.MESSAGE_ADDRESS_CONSTRAINTS;


/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Person implements ReadOnlyPerson {

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;

    private final UniqueTagList tags;
    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, UniqueTagList tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
    }

    /**
     * Copy constructor.
     */
    public Person(ReadOnlyPerson source) {
        this(source.getName(), source.getPhone(), source.getEmail(), source.getAddress(), source.getTags());
    }

    @Override
    public Name getName() {
        return name;
    }

    public Boolean setName(String name) {
        /*try{
            this.name = new Name(name);
        } catch (IllegalValueException ive){
            System.out.println(MESSAGE_NAME_CONSTRAINTS);
        }*/
        try{
            this.name = new Name(name);
            return true;
        } catch (IllegalValueException ive){
            System.out.println("|| " + MESSAGE_NAME_CONSTRAINTS);
            return false;
        }
    }

    @Override
    public Phone getPhone() {
        return phone;
    }

    public Boolean setPhone(String phone) {
        try {
            this.phone = new Phone(phone, false);
            return true;
        } catch (IllegalValueException ive){
            System.out.println("|| " + MESSAGE_PHONE_CONSTRAINTS);
            return false;
        }
    }

    @Override
    public Email getEmail() {
        return email;
    }

    public Boolean setEmail(String email) {
        try {
            this.email = new Email(email, false);
            return true;
        } catch (IllegalValueException ive){
            System.out.println("|| " + MESSAGE_EMAIL_CONSTRAINTS);
            return false;
        }
    }

    @Override
    public Address getAddress() {
        return address;
    }

    public Boolean setAddress(String value) {
        try {
            this.address = new Address(value, false);
            return true;
        } catch (IllegalValueException ive) {
            System.out.println("|| " + MESSAGE_ADDRESS_CONSTRAINTS);
            return false;
        }
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyPerson // instanceof handles nulls
                && this.hasSameData((ReadOnlyPerson) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, tags);
    }

    @Override
    public String toString() {
        return getAsTextShowAll();
    }

}
