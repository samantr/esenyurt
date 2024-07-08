package com.esenyurt.controller;

import com.esenyurt.entity.Classroom;
import com.esenyurt.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;
    @PostMapping("/save")
    public ResponseEntity<?> saveClassroom(@RequestBody Classroom classroom)
    {
        return new ResponseEntity<>(classroomService.saveClassroom(classroom),HttpStatus.OK);
    }
    @GetMapping("/fetch")
    public ResponseEntity<List> fetchClassrooms()
    {
        List<Classroom> classroomList = new ArrayList<>();
        classroomList = classroomService.fetchClassrooms();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(classroomList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/update")
    public Classroom updateClassroom(@RequestBody Classroom Classroom)
    {
        return classroomService.updateClassroom(Classroom);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClassroom(@PathVariable Long id)
    {
        classroomService.deleteClassroomById(id);
    }

}
