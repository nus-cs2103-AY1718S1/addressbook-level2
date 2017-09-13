package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyPerson {

    Name getName();
    Phone getPhone();
    Email getEmail();
    Address getAddress();

    /**
     * Returns a new TagList that is a deep copy of the internal TagList,
     * changes on the returned list will not affect the person's internal tags.
     */
    UniqueTagList getTags();

    /**
     * Returns true if both persons have the same identity fields (name and telephone).
     */
    default boolean isSamePerson(ReadOnlyPerson other) {
        return (other == this)
                || (other != null
                    && other.getName().equals(this.getName())
                    && other.getPhone().equals(this.getPhone()));
    }

    /**
     * Returns true if all data in this object is the same as that in another
     * (Note: interfaces cannot override .equals)
     */
    default boolean hasSameData(ReadOnlyPerson other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                    && this.hasSameName(other) // state checks here onwards
                    && this.hasSamePhone(other)
                    && this.hasSameEmail(other)
                    && this.hasSameAddress(other)
                    && this.hasSameTags(other));
    }

    default boolean hasSameName(ReadOnlyPerson other) {
        return other.getName().equals(this.getName());
    }

    default boolean hasSamePhone(ReadOnlyPerson other) {
        return other.getPhone().equals(this.getPhone());
    }

    default boolean hasSameEmail(ReadOnlyPerson other) {
        return other.getEmail().equals(this.getEmail());
    }

    default boolean hasSameAddress(ReadOnlyPerson other) {
        return other.getAddress().equals(this.getAddress());
    }

    default boolean hasSameTags(ReadOnlyPerson other) {
        return other.getTags().equals(this.getTags());
    }

    /**
     * Formats the person as text, showing all contact details.
     */
    default String getAsTextShowAll() {
        final StringBuilder builder = new StringBuilder();
        final String detailIsPrivate = "(private) ";
        builder.append(getName())
                .append(" Phone: ");
        if (getPhone().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getPhone())
                .append(" Email: ");
        if (getEmail().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getEmail())
                .append(" Address: ");
        if (getAddress().isPrivate()) {
            builder.append(detailIsPrivate);
        }
        builder.append(getAddress())
                .append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }

    /**
     * Formats a person as text, showing only non-private contact details.
     */
    default String getAsTextHidePrivate() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        if (!getPhone().isPrivate()) {
            builder.append(" Phone: ").append(getPhone());
        }
        if (!getEmail().isPrivate()) {
            builder.append(" Email: ").append(getEmail());
        }
        if (!getAddress().isPrivate()) {
            builder.append(" Address: ").append(getAddress());
        }
        builder.append(" Tags: ");
        for (Tag tag : getTags()) {
            builder.append(tag);
        }
        return builder.toString();
    }
}
