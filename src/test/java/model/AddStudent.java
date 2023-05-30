package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Date;
import java.util.Calendar;;
/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to add a new student to a programme are met.
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with initialise method.
 */
public class AddStudent {

    private Programme newProgramme;
    private Student newStudent;
    private Football team;
	
	@BeforeEach
    void initialise()
    {   
        // Create new instance of all objects
        newProgramme = new Programme();
        team = new Football();
        newStudent = new Student("Adam", 300);

        // set start date of course
        Calendar startdate = Calendar.getInstance();
        startdate.set(2023,Calendar.JULY,18);
        newProgramme.setStartDate(startdate.getTime());

   }

    @Test
    void false_ifOverStartDate()
    {   
        // This method test if the Start Date has already passed

        Calendar startdate = Calendar.getInstance();
        startdate.set(2023,Calendar.JANUARY,17);
        newProgramme.setStartDate(startdate.getTime());

        assertEquals(false,newProgramme.addStudent(newStudent,team));

    }


    @Test
    void exceptionThrown_ifStudentAlreadyEnrolled()
    {
        // This method tests if student is already enrolled and throws exception

        assertThrows(
            IllegalStudentEnrollException.class,
            () -> 
            {
                newProgramme.addStudent(newStudent,team);
                newProgramme.addStudent(newStudent,team);
            }

        );
    }


    @Test
    void false_IfMoreThan250Students()
    {
        // This method tests if the limit of students has been reached

        for(int i = 0; i<250; i++)
        {
            Student student = new Student("name", i);
            newProgramme.addStudent(student,team);
        }

        assertEquals(false,newProgramme.addStudent(newStudent,team));
    }


    @Test
    void true_ifallConditionsSasisfied()
    {
        // This method tests if all conditions of new student are correct
        assertEquals(true,newProgramme.addStudent(newStudent, team));
    }


    @Test void false_ifStudentIsNull()
    {
        assertEquals(false,newProgramme.addStudent(null,team));
    }


}