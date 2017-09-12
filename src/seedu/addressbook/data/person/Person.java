package seedu.addressbook.data.person;

import seedu.addressbook.data.tag.UniqueTagList;
import java.util.Scanner;
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
    private EmploymentInfo employmentInfo;
    private boolean hasEditedEmploymentInfo;

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
        this.employmentInfo= new EmploymentInfo();
        this.hasEditedEmploymentInfo=false;
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

    public String editEmploymentInfo(){
        printUserFound();
        String[] processedInput = obtainAndProcessInput();
        String employmentStatus=processedInput[0];
        String jobTitle=processedInput[1];
        int workExperience=Integer.valueOf(processedInput[2]);
        updateEmploymentInfo(this.name.toString(),employmentStatus,jobTitle,workExperience);
        hasEditedEmploymentInfo=true;
        return "Employment Information Updated";
    }

    public String getEmploymentInfo(){
        if(!hasEditedEmploymentInfo){ return hasYetToEditEmploymentStatus(); }
        else if(hasEditedEmploymentInfo){ return printEmploymentStatus();}
        else { return invalidEmploymentBoolean(); }
    }

    private String printEmploymentStatus(){
        String printName= "Name: " + this.employmentInfo.getName();
        String printES= "Employment Status: " + this.employmentInfo.getEmploymentStatus();
        String printJT= "Job Title: "+ this.employmentInfo.getJobTitle();
        String printWE= "Working Experience: " + Integer.toString(this.employmentInfo.getWorkingExperience());
        return printName + "\n" + printES + "\n" + printJT + "\n" + printWE;
    }
    private String hasYetToEditEmploymentStatus(){return "Employment Info has not been updated. " +
            "Please edit before viewing";}
    private String invalidEmploymentBoolean(){ return "Something weird happened! Please contact us so that " +
            "we can fix the issue!";}

    private void printUserFound(){
        System.out.println("Contact Found! Please enter the person's \n");
        System.out.println("1. Employment Status (Employed/Unemployed)");
        System.out.println("2. Job Title");
        System.out.println("3. Working Experience (Expressed as an Integer)");
        System.out.println("Seperate them with a comma");
        System.out.println("Example: Unemployed,Student,0");
    }

    private String[] obtainAndProcessInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] processedInput = input.split(",");
        return processedInput;
    }

    private void updateEmploymentInfo(String name,String employmentStatus,
                                      String jobTitle,int workExperience){
        employmentInfo.setName(name);
        employmentInfo.setEmploymentStatus(employmentStatus);
        employmentInfo.setJobTitle(jobTitle);
        employmentInfo.setWorkingExperience(workExperience);
    }
}
