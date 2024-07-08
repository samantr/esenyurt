package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "edu_exam_schedule")
public class ExamSchedule extends Auditable<String> {

    @Id
    @Column(name = "exam_schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_subject_semester_id", updatable = false, insertable = false)
    private GroupSubjectToSemester groupSubjectToSemester;

    @Column(name = "group_subject_semester_id")
    private Long groupSubjectToSemesterId;

    @Column(name = "date_exam")
    private Date dateExam;

    @Column(name = "time_begin")
    private Time timeBegin;

    @Column(name = "time_end")
    private Time timeEnd;

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

    public Date getDateExam() {
        return dateExam;
    }

    public void setDateExam(Date dateExam) {
        this.dateExam = dateExam;
    }

    public Time getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Time timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Time getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
