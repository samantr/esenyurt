package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;
import java.sql.Time;


@Entity
@Table(name = "edu_grp_sbj_smstr_tchr_class")
public class GroupSubjectSemesterTeacherToClass extends Auditable<String> {


    @Id
    @Column(name = "grp_sbj_smstr_tchr_to_class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id", updatable = false, insertable = false)
    private Classroom classroom;

    @Column(name = "class_id")
    private Long classId;

    @ManyToOne
    @JoinColumn(name = "grp_sbj_smstr_tchr_id", updatable = false, insertable = false)
    private GroupSubjectSemesterToTeacher groupSubjectSemesterToTeacher;

    @Column(name = "grp_sbj_smstr_tchr_id")
    private Long groupSubjectSemesterTeacherId;

    @Column(name = "time_from")
    private Time timeFrom;

    @Column(name = "time_to")
    private Time timeTo;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "dsc")
    private String dsc;



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getGroupSubjectSemesterTeacherId() {
        return groupSubjectSemesterTeacherId;
    }

    public void setGroupSubjectSemesterTeacherId(Long groupSubjectSemesterTeacherId) {
        this.groupSubjectSemesterTeacherId = groupSubjectSemesterTeacherId;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Time timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Time timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Classroom getEduClass() {
        return classroom;
    }

    public void setEduClass(Classroom classroom) {
        this.classroom = classroom;
    }

    public GroupSubjectSemesterToTeacher getGroupSubjectSemesterToTeacher() {
        return groupSubjectSemesterToTeacher;
    }

    public void setGroupSubjectSemesterToTeacher(GroupSubjectSemesterToTeacher groupSubjectSemesterToTeacher) {
        this.groupSubjectSemesterToTeacher = groupSubjectSemesterToTeacher;
    }
}
