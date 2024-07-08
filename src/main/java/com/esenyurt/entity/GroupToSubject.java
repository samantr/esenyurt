package com.esenyurt.entity;



import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "edu_group_subject")
public class GroupToSubject extends Auditable<String> {

    @Id
    @Column(name = "group_subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id", updatable = false, insertable = false)
    private Group group;

    @Column(name = "group_id")
    private Long groupId;

    @ManyToOne
    @JoinColumn(name = "subject_id", updatable = false, insertable = false)
    private Subject subject;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "code")
    private String code;

    @Column(name = "theoretical_unit_qnt")
    private Short theoreticalUnitQnt;

    @Column(name = "practical_unit_qnt")
    private Short practicalUnitQnt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getTheoreticalUnitQnt() {
        return theoreticalUnitQnt;
    }

    public void setTheoreticalUnitQnt(Short theoreticalUnitQnt) {
        this.theoreticalUnitQnt = theoreticalUnitQnt;
    }

    public Short getPracticalUnitQnt() {
        return practicalUnitQnt;
    }

    public void setPracticalUnitQnt(Short practicalUnitQnt) {
        this.practicalUnitQnt = practicalUnitQnt;
    }
}
