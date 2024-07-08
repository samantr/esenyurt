package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "edu_grp_sbj_smstr_tchr")
public class GroupSubjectSemesterToTeacher extends Auditable<String> {

    @Id
    @Column(name = "grp_sbj_smstr_tchr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_subject_semester_id", updatable = false, insertable = false)
    private GroupSubjectToSemester groupSubjectToSemester;

    @Column(name = "group_subject_semester_id")
    private Long groupSubjectToSemesterId;


    @ManyToOne
    @JoinColumn(name = "teacher_id", updatable = false, insertable = false)
    private Teacher teacher;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "dsc")
    private String dsc;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public GroupSubjectToSemester getGroupSubjectToSemester() {
        return groupSubjectToSemester;
    }

    public void setGroupSubjectToSemester(GroupSubjectToSemester groupSubjectToSemester) {
        this.groupSubjectToSemester = groupSubjectToSemester;
    }

    public Long getGroupSubjectToSemesterId() {
        return groupSubjectToSemesterId;
    }

    public void setGroupSubjectToSemesterId(Long groupSubjectToSemesterId) {
        this.groupSubjectToSemesterId = groupSubjectToSemesterId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
