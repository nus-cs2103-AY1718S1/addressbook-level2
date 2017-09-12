package seedu.addressbook.data.person;

public class EmploymentInfo {

    private String name;
    private String employmentStatus ;
    private String jobTitle;
    private int workingExperience;

    public EmploymentInfo(){
        this.name="";
        this.employmentStatus="";
        this.jobTitle="";
        this.workingExperience=0;
    }
    public EmploymentInfo(String myName,String hire,String position,int experience){
        this.name=myName;
        this.employmentStatus=hire;
        this.jobTitle=position;
        this.workingExperience=experience;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkingExperience(int workingExperience) {
        this.workingExperience = workingExperience;
    }

    public int getWorkingExperience() {
        return workingExperience;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getName() {
        return name;
    }
}
