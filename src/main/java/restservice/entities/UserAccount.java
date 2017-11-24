package restservice.entities;

import java.time.LocalDate;

public class UserAccount {

    private String visibleName;
    private String login;
    private String password;
    private LocalDate birthDate;
    private Gender gender;

    public UserAccount() {}

    public UserAccount(String visibleName, String login, String password, LocalDate birthDate, Gender gender) {
        this.visibleName = visibleName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getVisibleName() {
        return visibleName;
    }

    public void setVisibleName(String visibleName) {
        this.visibleName = visibleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
