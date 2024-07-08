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
@RequestMapping("/semester")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @PostMapping("/save")
    public ResponseEntity<?> saveSemester(@RequestBody Semester semester)
    {
        return new ResponseEntity<>(semesterService.saveSemester(semester),HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<?> fetchSemester()
    {
        List<Semester> semesterList = new ArrayList<>();
        semesterList = semesterService.fetchSemesters();
        ResponseEntity<?> listResponseEntity;
        listResponseEntity = new ResponseEntity<>(semesterList, HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSemester(@RequestBody Semester semester)
    {
        return new ResponseEntity<>(semesterService.updateSemester(semester),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSemester(@PathVariable Long id)
    {
        semesterService.deleteSemesterById(id);
    }

}
