/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17oopassignment1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Instructor extends Person
{
    private int EmployeeNumber;
    private LocalDate DateHired;
    private ArrayList<String> TeachableCourseCodes;
    
    public Instructor(String FirstName, String LastName, String StreetAddress, String city
                    , String province, String PostalCode, LocalDate birthdate, int EmployeeNumber
                    , LocalDate DateHired) 
    {
        super(FirstName, LastName, StreetAddress, city, province, PostalCode, birthdate);
        if(EmployeeNumber>0)
        {
            this.EmployeeNumber = EmployeeNumber;
        }
        else
            throw new IllegalArgumentException("The employee number should be greater than 0.");
        this.DateHired = DateHired;
        this.TeachableCourseCodes = new ArrayList<>();
    }
    
    public void addTeachableCourse(String CourseCode)
    {
        getTeachableCourses().add(CourseCode.toUpperCase());
    }
    
    public boolean canTeach(String CourseCode)
    {
        boolean res = false;
        
        for(int i = 0;i<TeachableCourseCodes.size();i++)
        {
            if(TeachableCourseCodes.get(i).equalsIgnoreCase(CourseCode))
            {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * @return the EmployeeNumber
     */
    public int getEmployeeNum() {
        return EmployeeNumber;
    }

    /**
     * @return the DateHired
     */
    public LocalDate getHireDate() {
        return DateHired;
    }

    /**
     * @return the TeachableCourseCodes
     */
    public ArrayList<String> getTeachableCourses() {
        return TeachableCourseCodes;
    }
    
    public int getYearsAtCollege()
    {
        return Period.between(this.DateHired, LocalDate.now()).getYears();
    }
    
    public String listOfSubjectsCertifiedToTeach()
    {
        String res = TeachableCourseCodes.get(0);
        
        for(int i = 1;i<TeachableCourseCodes.size();i++)
        {
            res += ", " + TeachableCourseCodes.get(i);
        }
        
        return res;
    }
    
    public void addCourseToAbilities(String CourseCode)
    {
        
    }
    
    public void setBirthday(LocalDate birthday)
    {
        int age = Period.between(birthday, LocalDate.now()).getYears();
        if(age>=18 && age<=100)
        {
            this.setBirthdate(birthday);
        }
        else
            throw new IllegalArgumentException("the birthday should fall in the range of 18-100 years of age");
    }
    
    public void setHireDate(LocalDate date)
    {
        int nb = Period.between(date, LocalDate.now()).getYears();
        if(nb < 80 && nb >= 0 && date.isBefore(LocalDate.now()))
        {
            this.DateHired = date;
        }
        else
            throw new IllegalArgumentException("The hire date should be in the last 80 years");
    }
    
    @Override
    public String toString()
    {
        return this.getFirstName() + " " + this.getLastName() + ", employee number is " + this.EmployeeNumber;
    }
}