package com.esenyurt.service;

import com.esenyurt.entity.ExamSchedule;

import java.util.List;

public interface ExamScheduleService {
    ExamSchedule saveExamSchedule(ExamSchedule examSchedule);
    List<ExamSchedule> fetchExamSchedules();
    ExamSchedule updateExamSchedule(ExamSchedule examSchedule);
    void deleteExamScheduleById(Long id);



}
