package com.esenyurt.repository;

import com.esenyurt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String roleName);

    @Query(value = "select r.* from gen_role r inner join user_role ur on r.role_id = ur.role_id "
            + " inner join gen_user u on ur.user_id = u.user_id "
            + "where u.user_id = ?1 ",nativeQuery = true)
    List<Role> findByUser(Long userId);
}