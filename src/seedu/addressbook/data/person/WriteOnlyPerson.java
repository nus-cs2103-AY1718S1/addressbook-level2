package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.UniqueTagList;

/**
 * A write-only immutable interface for a Person in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface WriteOnlyPerson {

    void setName(Name replacement);
    void setPhone(Phone replacement);
    void setEmail(Email replacement);
    void setAddress(Address replacement);
    void setTags(UniqueTagList replacement);

}
