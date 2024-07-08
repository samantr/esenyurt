package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;


@Entity
@Table(name = "edu_teacher")
public class Teacher extends Auditable<String> {


    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    private Person person;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "code")
    private String code;


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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
