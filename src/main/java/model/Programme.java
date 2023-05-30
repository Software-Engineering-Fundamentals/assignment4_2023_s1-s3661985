package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Programmes offered by a university
 */
public class Programme {
    /**
     * Name and id of the programme
     */
    private String name;
    private int pID;

    /**
     * Start date of the programme
     */
    private Date startDate;

    /**
     * End date of the programme
     */
    private Date dueDate;

    /**
     * Estimated duration of the course in months
     */
    private int estimatedDuration;

    /**
     * Students allocated to the programme
     */
    private List<Student> enrolled = new ArrayList<Student>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return pID;
    }

    public void setID(int ID) {
        this.pID = ID;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public List<Student> getEnrollments() {
        return enrolled;
    }

    
    public boolean removeEnrolledStudent(Student student) {
    
    	return false;
    	   
    }



    /**
     * Add a new student to the programme
     * @param Student: to enroll  to student in a programme 
     * @return true if the student is successfully enrolled, false otherwise
     */

    public boolean addStudent(Student student,Football team) throws IllegalStudentEnrollException
    {
        if(student == null)
        {
            return false;
        }

        
        // get current date
        Date currentDate = new Date();

        // check if date has passed
        if(currentDate.compareTo(this.getStartDate()) > 0)
        {
            return false;
        }

        
        // check if student alreay enrolled
        for(int i = 0; i<enrolled.size(); ++i)
        {
            if(enrolled.get(i).getId() == student.getId())
            {
                throw new IllegalStudentEnrollException("Student already Enrolled in this programme");
            }
        }
        

        // check program size
        if(enrolled.size() >= 250)
        {
            return false;
        }

        //All checks pass add student to programme and football team
        
        enrolled.add(student);
        team.addAvailStudent(student);
        return true;

    }




}
