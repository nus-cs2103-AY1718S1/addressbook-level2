package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

public class UtilsTest {

    Person person1;
    Person person2;
    AddressBook initialAddressBook;
    List<ReadOnlyPerson> initialList;

    @Before
    public void setUp() throws IllegalValueException{

        person1 = new Person(new Name("person one"), new Phone("12341234", false),
                new Email("1@1.com", false),
                new Block(123), new Street("Kent Ridge 1"),
                new Unit("#12-34"), new Postal(118430),
                new UniqueTagList(new HashSet<Tag>()));

        person2 = new Person(new Name("person two"), new Phone("23452345", false),
                new Email("2@2.com", false),
                new Block(234), new Street("Kent Ridge 2"),
                new Unit("#23-45"), new Postal(118430),
                new UniqueTagList(new HashSet<Tag>()));

        initialAddressBook = new AddressBook();
        initialAddressBook.addPerson(person1);
        initialAddressBook.addPerson(person2);

        List<ReadOnlyPerson> initialList = new ArrayList<ReadOnlyPerson>();
        initialList.add(person1);
        initialList.add(person2);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_create_newAddressBook () {
        AddressBook newAddressBook = TestUtil.createAddressBook(person1, person2);
        Assert.assertEquals(initialAddressBook, newAddressBook);
    }

    @Test
    public void test_createListOfPeople () {
        List<ReadOnlyPerson> newList= TestUtil.createList(person1, person2);
        Assert.assertNotNull(newList);
        Assert.assertEquals(2, TestUtil.getSize(newList));
    }

    @Test
    public void test_generateTestPerson () {
        Person newPersonGenerated = TestUtil.generateTestPerson();
        Assert.assertNotNull(newPersonGenerated);
    }

    @Test
    public void test_clone_addressBook () {
        AddressBook newAddressBook = TestUtil.clone(initialAddressBook);
        Assert.assertEquals(initialAddressBook, newAddressBook);
    }

    @Test
    public void isAnyNull() {
        // empty list
        assertFalse(Utils.isAnyNull());

        // Any non-empty list
        assertFalse(Utils.isAnyNull(new Object(), new Object()));
        assertFalse(Utils.isAnyNull("test"));
        assertFalse(Utils.isAnyNull(""));

        // non empty list with just one null at the beginning
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull(null, "", new Object()));
        assertTrue(Utils.isAnyNull(null, new Object(), new Object()));

        // non empty list with nulls in the middle
        assertTrue(Utils.isAnyNull(new Object(), null, null, "test"));
        assertTrue(Utils.isAnyNull("", null, new Object()));

        // non empty list with one null as the last element
        assertTrue(Utils.isAnyNull("", new Object(), null));
        assertTrue(Utils.isAnyNull(new Object(), new Object(), null));

        // confirms nulls inside the list are not considered
        List<Object> nullList = Arrays.asList((Object) null);
        assertFalse(Utils.isAnyNull(nullList));
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
