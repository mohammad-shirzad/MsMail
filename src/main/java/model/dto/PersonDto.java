package model.dto;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Account")
public class PersonDto implements Serializable{

    @Id
    @Column(name = "Id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Password",length = 20)
    private String password;

    @Column(name = "FirstName",length = 20)
    private String firstName;

    @Column(name = "LastName",length = 20)
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonDto(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonDto() {

    }
}
