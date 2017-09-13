package seedu.addressbook.data.person;

public class Contact {
    protected Name name;
    protected Phone phone;
    protected Email email;
    protected Address address;

    public Contact(Name name, Phone phone, Email email, Address address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
