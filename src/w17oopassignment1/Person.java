package w17oopassignment1;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Riya Patel
 */
public class Person 
{
    private String FirstName;
    private String LastName;
    private String StreetAddress;
    private String city;
    private String province;
    private String PostalCode;
    private LocalDate birthday;
    
    /**
     *
     * @param FirstName
     * @param LastName
     * @param StreetAddress
     * @param city
     * @param province
     * @param PostalCode
     * @param birthdate
     */
    public Person(String FirstName,String LastName,String StreetAddress,String city,String province,String PostalCode,LocalDate birthdate) 
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StreetAddress = StreetAddress;
        this.city = city;
        this.province = province;
        if(PostalCode.length()==6)
            this.PostalCode = PostalCode.toUpperCase();
        else
            throw new IllegalArgumentException("Postal code must contains 6 characters!");
        this.birthday = birthdate;
    }
    
    /**
     *
     * @return The age
     */
    public int getAge()
    {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
    
    /**
     *
     * @param street
     * @param city
     * @param province
     * @param postal
     */
    public void changeAddress(String street,String city,String province,String postal)
    {
        this.StreetAddress = street;
        this.city = city;
        this.province = province;
        if(postal.length() == 6)
        {
            this.PostalCode = postal.toUpperCase();
        }
        else
            throw new IllegalArgumentException("Postal code must contains 6 characters!");
    }
    
    /**
     *
     * @return A string with the street address, the city and the postal code of the person.
     */
    public String getFullAddress()
    {
        String FullAddress = this.StreetAddress + ", " + this.city + ", " + this.province + ", " + this.PostalCode;
        return FullAddress;
    }
    
    @Override
    public String toString()
    {
        return this.FirstName + " " + this.LastName;
    }
    
    /**
     *
     * @return The year of birth
     */
    public int getYearBorn()
    {
        return this.birthday.getYear();
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return the LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName the LastName to set
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return the StreetAddress
     */
    public String getStreetAddress() {
        return StreetAddress;
    }

    /**
     * @param StreetAddress the StreetAddress to set
     */
    public void setStreetAddress(String StreetAddress) {
        this.StreetAddress = StreetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the PostalCode
     */
    public String getPostalCode() {
        return PostalCode;
    }

    /**
     * @param Postal the PostalCode to set
     */
    public void setPostalCode(String Postal) {
        if (Postal.length() > 6 || Postal.length() < 6) 
        {
            throw new IllegalArgumentException("Must be 6 characters");
        }
        else
            this.PostalCode = Postal.toUpperCase();
    }

    /**
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}