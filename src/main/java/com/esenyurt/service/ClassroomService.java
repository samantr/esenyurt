package com.esenyurt.service;

import com.esenyurt.entity.Classroom;
import com.esenyurt.entity.Classroom;

import java.util.List;

public interface ClassroomService {
    Classroom saveClassroom(Classroom classroom);
    List<Classroom> fetchClassrooms();
    Classroom updateClassroom(Classroom classroom);
    void deleteClassroomById(Long id);



}
