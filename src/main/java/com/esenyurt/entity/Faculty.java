package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "gen_faculty")
public class Faculty extends Auditable<String> {

    @Id
    @Column(name = "faculty_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
