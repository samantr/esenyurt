package com.esenyurt.entity;




import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "edu_semester")
public class Semester extends Auditable<String> {


    @Id
    @Column(name = "semester_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semester_year_begin")
    private Integer yearBegin;

    @Column(name = "semester_month_begin")
    private Integer monthBegin;

    @Column(name = "semester_year_end")
    private Integer yearEnd;

    @Column(name = "semester_month_end")
    private Integer monthEnd;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYearBegin() {
        return yearBegin;
    }

    public void setYearBegin(Integer yearBegin) {
        this.yearBegin = yearBegin;
    }

    public Integer getMonthBegin() {
        return monthBegin;
    }

    public void setMonthBegin(Integer monthBegin) {
        this.monthBegin = monthBegin;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }

    public Integer getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(Integer monthEnd) {
        this.monthEnd = monthEnd;
    }
}
