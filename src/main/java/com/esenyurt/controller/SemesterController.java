package com.esenyurt.controller;

import com.esenyurt.entity.Semester;
import com.esenyurt.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping("/semester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester)
    {
        return new ResponseEntity<>(semesterService.createSemester(semester),HttpStatus.OK);
    }
    @GetMapping("/semester")
    public ResponseEntity<?> readSemester()
    {
        List<Semester> semesterList = new ArrayList<>();
        semesterList = semesterService.readSemesters();
        ResponseEntity<?> listResponseEntity;
        listResponseEntity = new ResponseEntity<>(semesterList, HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/semester")
    public ResponseEntity<?> updateSemester(@RequestBody Semester semester)
    {
        return new ResponseEntity<>(semesterService.updateSemester(semester),HttpStatus.OK);
    }

    @DeleteMapping("/semester/{id}")
    public void deleteSemester(@PathVariable Long id)
    {
        semesterService.deleteSemesterById(id);
    }

}
