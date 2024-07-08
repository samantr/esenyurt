package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "edu_group")
public class Group extends Auditable<String> {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty_id", updatable = false, insertable = false)
    private Faculty faculty;

    @Column(name = "faculty_id")
    private Long facultyId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
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
