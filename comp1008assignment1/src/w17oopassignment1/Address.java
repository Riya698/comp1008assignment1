package w17oopassignment1;

public class Address {
    String stAdd;
    String Postal;
    String City;
    String province;

    public Address(String stAdd, String Postal, String City, String province) {
        City = this.setCity(City);
        Postal = this.setPostal(Postal);
        stAdd = this.setstAdd(stAdd);
        province = this.setprovince(province);
    }

    public String setCity(String City) {
        this.City = City;
        return null;
    }

    public String setPostal(String Postal) {
        this.Postal = Postal;
        return null;
    }

    public String setstAdd(String stAdd) {
        this.stAdd = stAdd;
        return null;
    }

    public String setprovince(String province) {
        return province;
    }

    public String getstAdd(String stAdd) {
        return null;
    }

    public String getpostal(String Postal) {
        if (Postal.length() > 6 || Postal.length() < 6) {
            throw new IllegalArgumentException("Must be 6 characters");
        }
        return Postal;
    }

    public String getCity(String City) {
        return City;
    }

    public String getprovince(String province) {
        return null;
    }
}