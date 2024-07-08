package com.esenyurt.entity;


import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "edu_classroom")
public class Classroom extends Auditable<String> {

    @Id
    @Column(name = "classroom_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classroom_no")
    private String classroomNo;

    @Column(name = "classroom_type")
    private Integer classroomType;

    @Column(name = "dsc")
    private String dsc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroomNo() {
        return classroomNo;
    }

    public void setClassroomNo(String classroomNo) {
        this.classroomNo = classroomNo;
    }

    public Integer getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(Integer classroomType) {
        this.classroomType = classroomType;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
