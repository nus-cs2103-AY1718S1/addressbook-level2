package seedu.addressbook.storage.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * JAXB-friendly adapted person data holder class.
 */
public class AdaptedPerson {

    private static class AdaptedContactDetail {
        @XmlValue
        public String value;
        @XmlAttribute(required = true)
        public boolean isPrivate;
    }

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private AdaptedContactDetail phone;
    @XmlElement(required = true)
    private AdaptedContactDetail email;
    @XmlElement(required = true)
    private AdaptedContactDetail block;
    @XmlElement(required = true)
    private AdaptedContactDetail street;
    @XmlElement(required = true)
    private AdaptedContactDetail unit;
    @XmlElement(required = true)
    private AdaptedContactDetail postalCode;

    @XmlElement
    private List<AdaptedTag> tagged = new ArrayList<>();

    /**
     * No-arg constructor for JAXB use.
     */
    public AdaptedPerson() {}


    /**
     * Converts a given Person into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created AdaptedPerson
     */
    public AdaptedPerson(ReadOnlyPerson source) {
        name = source.getName().fullName;

        phone = new AdaptedContactDetail();
        phone.isPrivate = source.getPhone().isPrivate();
        phone.value = source.getPhone().value;

        email = new AdaptedContactDetail();
        email.isPrivate = source.getEmail().isPrivate();
        email.value = source.getEmail().value;

        block = new AdaptedContactDetail();
        block.isPrivate = source.getBlock().isPrivate();
        block.value = source.getBlock().value;

        street = new AdaptedContactDetail();
        street.isPrivate = source.getStreet().isPrivate();
        street.value = source.getStreet().value;

        unit = new AdaptedContactDetail();
        unit.isPrivate = source.getUnit().isPrivate();
        unit.value = source.getUnit().value;

        postalCode = new AdaptedContactDetail();
        postalCode.isPrivate = source.getPostalCode().isPrivate();
        postalCode.value = source.getPostalCode().value;

        tagged = new ArrayList<>();
        for (Tag tag : source.getTags()) {
            tagged.add(new AdaptedTag(tag));
        }
    }

    /**
     * Returns true if any required field is missing.
     *
     * JAXB does not enforce (required = true) without a given XML schema.
     * Since we do most of our validation using the data class constructors, the only extra logic we need
     * is to ensure that every xml element in the document is present. JAXB sets missing elements as null,
     * so we check for that.
     */
    public boolean isAnyRequiredFieldMissing() {
        for (AdaptedTag tag : tagged) {
            if (tag.isAnyRequiredFieldMissing()) {
                return true;
            }
        }
        // second call only happens if phone/email/address are all not null
        return Utils.isAnyNull(name, phone, email, block, street, unit, postalCode)
                || Utils.isAnyNull(phone.value, email.value, block.value, street.value, unit.value, postalCode.value);
    }

    /**
     * Converts this jaxb-friendly adapted person object into the Person object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (AdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }
        final Name name = new Name(this.name);
        final Phone phone = new Phone(this.phone.value, this.phone.isPrivate);
        final Email email = new Email(this.email.value, this.email.isPrivate);
        final Address block = new Address(this.block.value, this.block.isPrivate);
        final Address street = new Address(this.street.value, this.street.isPrivate);
        final Address unit = new Address(this.unit  .value, this.unit.isPrivate);
        final Address postalCode = new Address(this.postalCode.value, this.postalCode.isPrivate);
        final UniqueTagList tags = new UniqueTagList(personTags);
        return new Person(name, phone, email, block, street, unit, postalCode, tags);
    }
}
