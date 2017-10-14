package seedu.addressbook.data.person;


import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.Tagging;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;
import seedu.addressbook.data.tag.UniqueTagList.NoSuchTagException;

import java.util.Objects;

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
    private Tagging addedTags;
    private Tagging removedTags;
    /**
     * Assumption: Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, UniqueTagList tags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags = new UniqueTagList(tags); // protect internal tags from changes in the arg list
        this.addedTags = new Tagging(this.name, "+");
        this.removedTags = new Tagging(this.name, "-");
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

    @Override
    public Phone getPhone() {
        return phone;
    }

    @Override
    public Email getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Adds a tag to this person.
     *
     * @throws DuplicateTagException if an equivalent tag in the given person already exists.
     */
    public void addTag(Tag toAdd) throws DuplicateTagException {
        UniqueTagList currentTags = this.getTags();
        currentTags.add(toAdd);
        this.setTags(currentTags);
        this.addedTags.addTagToList(toAdd);
    }

    /**
     * Remove a tag from this person.
     *
     * @throws NoSuchTagException if there is no such tag in the given person.
     */
    public void removeTag(Tag toRemove) throws NoSuchTagException{
        UniqueTagList currentTags = this.getTags();
        currentTags.remove(toRemove);
        this.setTags(currentTags);
        this.removedTags.addTagToList(toRemove);
    }

    public Tagging getTaggings(String addOrRemove) {
        if (addOrRemove.equals("+")) {
            return this.addedTags;
        } else  {
            return this.removedTags;
        }
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
