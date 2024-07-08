package com.esenyurt.repository;

import com.esenyurt.entity.Classroom;
import com.esenyurt.entity.ExamSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamScheduleRepository extends JpaRepository<ExamSchedule,Long> {
}
