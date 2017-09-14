package seedu.addressbook.data;

import org.junit.Test;
import seedu.addressbook.data.person.EmploymentInfo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmploymentInfoTest {

    @Test
    public void testEmptyInputs() throws Exception{
        EmploymentInfo emptyInfo = new EmploymentInfo();

        assertTrue(emptyInfo.getName().equals(""));
        assertTrue(emptyInfo.getEmploymentStatus().equals(""));
        assertTrue(emptyInfo.getJobTitle().equals(""));
        assertTrue(emptyInfo.getWorkingExperience()==0);
        assertFalse(emptyInfo.getName().equals("Jeremy"));
        assertFalse(emptyInfo.getEmploymentStatus().equals("Employed"));
        assertFalse(emptyInfo.getJobTitle().equals("Student"));
        assertFalse(emptyInfo.getWorkingExperience()==2);
    }

    @Test
    public void testFilledInputs() throws Exception{
        EmploymentInfo filledInfo = new EmploymentInfo("Jeremy","Unemployed","Student",2);

        assertTrue(filledInfo.getName().equals("Jeremy"));
        assertTrue(filledInfo.getEmploymentStatus().equals("Unemployed"));
        assertTrue(filledInfo.getJobTitle().equals("Student"));
        assertTrue(filledInfo.getWorkingExperience()==2);
        assertFalse(filledInfo.getName().equals(""));
        assertFalse(filledInfo.getEmploymentStatus().equals(""));
        assertFalse(filledInfo.getJobTitle().equals(""));
        assertFalse(filledInfo.getWorkingExperience()==0);
    }

    @Test
    public void testSetters() throws Exception{
        EmploymentInfo emptyInfo = new EmploymentInfo();
        emptyInfo.setName("Jeremy");
        emptyInfo.setEmploymentStatus("Unemployed");
        emptyInfo.setJobTitle("Student");
        emptyInfo.setWorkingExperience(2);

        assertTrue(emptyInfo.getName().equals("Jeremy"));
        assertTrue(emptyInfo.getEmploymentStatus().equals("Unemployed"));
        assertTrue(emptyInfo.getJobTitle().equals("Student"));
        assertTrue(emptyInfo.getWorkingExperience()==2);
        assertFalse(emptyInfo.getName().equals(""));
        assertFalse(emptyInfo.getEmploymentStatus().equals(""));
        assertFalse(emptyInfo.getJobTitle().equals(""));
        assertFalse(emptyInfo.getWorkingExperience()==0);

    }
}
