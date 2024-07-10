package com.esenyurt.controller;

import com.esenyurt.entity.ExamSchedule;
import com.esenyurt.service.ExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExamScheduleController {

    @Autowired
    private ExamScheduleService examScheduleService;
    @PostMapping("/exam-schedule")
    public ResponseEntity<?> createExamSchedule(@RequestBody ExamSchedule examSchedule)
    {
        return new ResponseEntity<>(examScheduleService.createExamSchedule(examSchedule),HttpStatus.OK);
    }
    @GetMapping("/exam-schedule")
    public ResponseEntity<List> readExamSchedules()
    {
        List<ExamSchedule> ExamScheduleList = new ArrayList<>();
        ExamScheduleList = examScheduleService.readExamSchedules();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(ExamScheduleList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/exam-schedule")
    public ExamSchedule updateExamSchedule(@RequestBody ExamSchedule ExamSchedule)
    {
        return examScheduleService.updateExamSchedule(ExamSchedule);
    }

    @DeleteMapping("/exam-schedule/{id}")
    public void deleteExamSchedule(@PathVariable Long id)
    {
        examScheduleService.deleteExamScheduleById(id);
    }

}
