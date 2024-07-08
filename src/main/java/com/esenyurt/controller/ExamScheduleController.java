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
@RequestMapping("/examSchedule")
public class ExamScheduleController {

    @Autowired
    private ExamScheduleService examScheduleService;
    @PostMapping("/save")
    public ResponseEntity<?> saveExamSchedule(@RequestBody ExamSchedule examSchedule)
    {
        return new ResponseEntity<>(examScheduleService.saveExamSchedule(examSchedule),HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List> fetchExamSchedules()
    {
        List<ExamSchedule> ExamScheduleList = new ArrayList<>();
        ExamScheduleList = examScheduleService.fetchExamSchedules();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(ExamScheduleList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/update")
    public ExamSchedule updateExamSchedule(@RequestBody ExamSchedule ExamSchedule)
    {
        return examScheduleService.updateExamSchedule(ExamSchedule);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExamSchedule(@PathVariable Long id)
    {
        examScheduleService.deleteExamScheduleById(id);
    }

}
