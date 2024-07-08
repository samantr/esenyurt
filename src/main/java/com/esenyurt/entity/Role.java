package com.esenyurt.entity;


import com.esenyurt.audit.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "gen_role")
public class Role  extends Auditable<String> {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "role_name")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
