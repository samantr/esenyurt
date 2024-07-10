package com.esenyurt.controller;

import com.esenyurt.entity.Classroom;
import com.esenyurt.service.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomService;
    @PostMapping("/classroom")
    public ResponseEntity<?> createClassroom(@RequestBody Classroom classroom)
    {
        return new ResponseEntity<>(classroomService.createClassroom(classroom),HttpStatus.OK);
    }
    @GetMapping("/classroom")
    public ResponseEntity<List> readClassrooms()
    {
        List<Classroom> classroomList = new ArrayList<>();
        classroomList = classroomService.readClassrooms();
        ResponseEntity<List> listResponseEntity;
        listResponseEntity = new ResponseEntity<List>(classroomList,HttpStatus.OK);

        return listResponseEntity;
    }

    @PutMapping("/classroom")
    public Classroom updateClassroom(@RequestBody Classroom Classroom)
    {
        return classroomService.updateClassroom(Classroom);
    }

    @DeleteMapping("/classroom/{id}")
    public void deleteClassroom(@PathVariable Long id)
    {
        classroomService.deleteClassroomById(id);
    }

}
