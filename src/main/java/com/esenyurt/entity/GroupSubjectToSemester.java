package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;


@Entity
@Table(name = "edu_group_subject_semester")
public class GroupSubjectToSemester extends Auditable<String> {

    @Id
    @Column(name = "group_subject_semester_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_subject_id", updatable = false, insertable = false)
    private GroupToSubject groupToSubject;

    @Column(name = "group_subject_id")
    private Long groupToSubjectId;

    @ManyToOne
    @JoinColumn(name = "semester_id", updatable = false, insertable = false)
    private Semester semester;

    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "dsc")
    private String dsc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupToSubject getGroupToSubject() {
        return groupToSubject;
    }

    public void setGroupToSubject(GroupToSubject groupToSubject) {
        this.groupToSubject = groupToSubject;
    }

    public Long getGroupToSubjectId() {
        return groupToSubjectId;
    }

    public void setGroupToSubjectId(Long groupToSubjectId) {
        this.groupToSubjectId = groupToSubjectId;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
}
