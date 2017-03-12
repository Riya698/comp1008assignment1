/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Riya Patel
 */
public class Student extends Person
{
    private String major;
    private int StudentNumber;
    private LocalDate EnrollmentDate;
    private boolean GoodStanding;
    
    /**
     *
     * @param FirstName
     * @param LastName
     * @param StreetAddress
     * @param city
     * @param province
     * @param PostalCode
     * @param birthdate
     * @param major
     * @param StudentNumber
     * @param EnrollmentDate
     */
    public Student(String FirstName, String LastName, String StreetAddress, String city, String province
                    , String PostalCode, LocalDate birthdate,String major,int StudentNumber, LocalDate EnrollmentDate) 
    {
        super(FirstName, LastName, StreetAddress, city, province, PostalCode, birthdate);
        this.major = major;
        this.EnrollmentDate = EnrollmentDate;
        if(this.getAge()>=14 && this.getAge()<=90)
        {
            this.GoodStanding = true;
        }
        else
        {
            this.GoodStanding = false;
            throw new IllegalArgumentException("the birthday should fall in the range of 14-90 years of age");
        }
        
        if(StudentNumber > 0)
        {
            this.StudentNumber = StudentNumber;
        }
        else
            throw new IllegalArgumentException("The student number should be greater than 0!");
    }
    
    /**
     *
     * @return The student's enrollment year
     */
    public int getYearEnrolled()
    {
        return this.EnrollmentDate.getYear();
    }
    
    /**
     *
     * @return The amount of whole years a Student has been enrolled.
     */
    public int getYearsAtCollege()
    {
        return Period.between(this.EnrollmentDate, LocalDate.now()).getYears();
    }
    
    /**
     *
     * @return A boolean saying if the student is in good standing or not.
     */
    public boolean inGoodStanding()
    {
        return this.GoodStanding;
    }
    
    /**
     * Updates the instance variable holding whether or not the student is in good standing to be true.
     */
    public void reinstateStudent()
    {
        this.GoodStanding = true;
    }
    
    public void setBirthday(LocalDate birthdate)
    {
        int age = Period.between(birthdate, LocalDate.now()).getYears();
        if(age>=14 && age<=90)
        {
            this.setBirthday(birthdate);
        }
        else
            throw new IllegalArgumentException("the birthday should fall in the range of 14-90 years of age");
    }
    
    /**
     *
     * @param StudentNumber
     */
    public void setStudentNumber(int StudentNumber)
    {
        if(StudentNumber > 0)
        {
            this.StudentNumber = StudentNumber;
        }
        else
            throw new IllegalArgumentException("The student number should be positive.");
    }
    
    /**
     *
     */
    public void suspendStudent()
    {
        this.GoodStanding = false;
    }
    
    @Override
    public String toString()
    {
        return this.getFirstName() + " " + this.getLastName() + ", student number is " + this.StudentNumber;
    }
}
