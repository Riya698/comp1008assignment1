/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Riya Patel
 */
public class Course 
{
    private Instructor prof;
    private String CourseCode;
    private String CourseName;
    private String description;
    private String room;
    private DayOfWeek DayOfClass;
    private LocalTime StartTime;
    private int duration;
    private int MaxStudents;
    private ArrayList<Student> ListOfStudents;
    
    /**
     *
     * @param code
     * @param name
     * @param description
     * @param room
     * @param prof
     * @param day
     * @param start
     * @param duration
     * @param max
     */
    public Course(String code,String name,String description,String room,Instructor prof,DayOfWeek day
                    ,LocalTime start,int duration,int max)
    {
        this.CourseCode = code;
        this.CourseName = name;
        this.description = description;
        this.room = room;
        if(prof.canTeach(this.CourseCode))
        {
            this.prof = prof;
        }
        else
            throw new IllegalArgumentException("This instructor is not able to teach this course!");
        
        this.DayOfClass = day;
        if(start.isAfter(LocalTime.of(7, 59, 59)) && start.isBefore(LocalTime.of(18, 01)))
        {
            this.StartTime = start;
        }
        else
            throw new IllegalArgumentException("The start time should be between 06:00 and 18:00");
        
        this.duration = duration;
        if(max >= 10 && max <= 50)
        {
            this.MaxStudents = max;
        }
        else
            throw new IllegalArgumentException("The max number of students should be in the range of 10-50.");
        
        this.ListOfStudents = new ArrayList<>();
    }
    
    /**
     *
     * @param student
     */
    public void addStudent(Student student)
    {
        if(student.inGoodStanding() && this.ListOfStudents.size() < this.MaxStudents)
        {
            this.ListOfStudents.add(student);
        }
        else
            throw new IllegalArgumentException();
    }
    
    /**
     *
     * @return The average number of years students registered in the class have been at the college.
     */
    public double averageStudentTimeAtCollege()
    {
        double sum = 0;
        double avg = 0;
        if(this.ListOfStudents.size()>0)
        {
            for(Student s : ListOfStudents)
            {
                sum += s.getYearsAtCollege();
            }
            avg = sum/ListOfStudents.size();
        }
        
        return avg;
    }
    
    /**
     *
     * @return the course code.
     */
    public String getCourseCode()
    {
        return this.CourseCode;
    }
    
    /**
     *
     * @return the course name.
     */
    public String getCourseName()
    {
        return this.CourseName;
    }
    
    /**
     *
     * @return a DayOfWeek object with the day the class is offered
     */
    public DayOfWeek getDayOfClass()
    {
        return this.DayOfClass;
    }
    
    /**
     *
     * @return the description of the course.
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     *
     * @return the duration of each class as an int.
     */
    public int getDuration()
    {
        return this.duration;
    }
    
    /**
     *
     * @return the maximum number of students that can be registered in the class.
     */
    public int getMaxNumberOfStudents()
    {
        return this.MaxStudents;
    }
    
    /**
     *
     * @return the number of students currently registered in the course.
     */
    public int getNumberOfStudentsEnrolled()
    {
        return this.ListOfStudents.size();
    }
    
    /**
     *
     * @return the Instructor object that will be teaching the course.
     */
    public Instructor getProf()
    {
        return this.prof;
    }
    
    /**
     *
     * @return the room location.
     */
    public String getRoom()
    {
        return this.room;
    }
    
    /**
     *
     * @return a LocalTime object representing the start time of the class.
     */
    public LocalTime getStartTime()
    {
        return this.StartTime;
    }
    
    /**
     *
     * @return an ArrayList of Student’s registered in the course.
     */
    public ArrayList<Student> getStudents()
    {
        return this.ListOfStudents;
    }
    
    /**
     *
     * @param day
     */
    public void setDayOfClass(DayOfWeek day)
    {
        if(day.compareTo(DayOfWeek.MONDAY) >= 0 && day.compareTo(DayOfWeek.FRIDAY) <= 0)
        {
            this.DayOfClass = day;
        }
        else
            throw new IllegalArgumentException("The day of class should be between Monday and Friday.");
    }
    
    /**
     *
     * @param max
     */
    public void setMaxNumberOfStudents(int max)
    {
        if(max>=10 && max<=50)
        {
            this.MaxStudents = max;
        }
        else
            throw new IllegalArgumentException("The maximum number of students should be in the range 10-50.");
        
    }
    
    /**
     *
     * @param prof
     */
    public void setProf(Instructor prof)
    {
        if(prof.canTeach(this.CourseCode))
        {
            this.prof = prof;
        }
        else
            throw new IllegalArgumentException("This instructor is not able to this course.");
    }
    
    /**
     *
     * @param start
     */
    public void setStartTime(LocalTime start)
    {
        if(start.isAfter(LocalTime.of(7, 59, 59)) && start.isBefore(LocalTime.of(18, 01)))
        {
            this.StartTime = start;
        }
        else
           throw new IllegalArgumentException("The start time should be between 06:00 and 18:00"); 
    }
    
    /**
     *
     * @return a String with the Student’s registered in the course.
     */
    public String showClassList()
    {
        String list = "";
        for(Student s : ListOfStudents)
        {
            list += s.toString() + "\n";
        }
        return list;
    }
    
    @Override
    public String toString()
    {
        return this.CourseName + " " + this.CourseCode;
    }
}
