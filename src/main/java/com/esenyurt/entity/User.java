package com.esenyurt.entity;

import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "gen_user")
public class User  extends Auditable<String> {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @OneToOne
    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    private Person person;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
