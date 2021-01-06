package tech.automationqa.api.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    private Integer id;
    @NotNull
    @Size(min = 2, message = "Name should have at least one character")
    private String name;
    @NotNull
    @Size(min = 2)
    private String surname;
    @NotNull
    @Size(min = 2)
    private String username;
    @NotNull
    private String dateOfBirth;
    @NotNull
    @Size(min = 2)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Integer id, String name, String surname, String username, String dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
