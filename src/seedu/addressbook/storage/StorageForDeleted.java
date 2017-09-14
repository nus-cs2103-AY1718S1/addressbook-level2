package seedu.addressbook.storage;

import seedu.addressbook.commands.AddCommand;
import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.storage.jaxb.AdaptedAddressBook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

import static seedu.addressbook.commands.AddCommand.MESSAGE_DUPLICATE_PERSON;

public class StorageForDeleted {
    private static Stack<ReadOnlyPerson> storageForDeleted;

    public StorageForDeleted() {
        this.storageForDeleted = new Stack<ReadOnlyPerson>();
    }

    public void storeTheDeleted(ReadOnlyPerson personBeingDeleted) throws UniquePersonList.DuplicatePersonException {
        // System.out.println("i m at storeTheDeleted");
        storageForDeleted.add(0, personBeingDeleted);
        // System.out.println(storageForDeleted.peek().toString());
    }

    public Person getPersonToBeRestored() {
        try {
            ReadOnlyPerson personBeingRestored = storageForDeleted.remove(0);
            Person toAdd = (Person) personBeingRestored;
            // System.out.println("i m done with casting");
            return toAdd;
        } catch (Exception e) {
            return null;
        }
    }

    public ReadOnlyPerson peek() {
        return storageForDeleted.get(0);
    }
}
