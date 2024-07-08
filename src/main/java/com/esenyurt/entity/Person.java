package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;
import java.sql.Date;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "gen_person")
@EntityListeners(AuditingEntityListener.class)
public class Person  extends Auditable<String> {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person_code")
    private String code;
    @Column(name = "person_name")
    private String name;

    @Column(name = "person_last_name")
    private String lastName;

    @Column(name = "id_number")
    private Long idNumber;

    @Column(name = "date_birthday")
    private Date dateBirthday;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
