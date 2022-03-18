package Helper;

public class UserCredentials {
    private String emri, mbiemri, company, birthdate, birthmonth, birthyear, email, password;

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public String getCompany() {
        return company;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getBirthmonth() {
        return birthmonth;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserCredentials(){
        emri = "Dori";
        mbiemri = "Agalliu";
        company = "LHINDS";
        birthdate = "23";
        birthmonth = "March";
        birthyear = "2000";
        email = "dori@gmail.com";
        password = "1234567";
    }
}
