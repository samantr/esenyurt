package com.esenyurt.service;

import com.esenyurt.entity.Classroom;
import com.esenyurt.enums.ErrorMessages;
import com.esenyurt.exception.ApplicationException;
import com.esenyurt.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom(Classroom classroom) {

        if (classroomRepository.findById(classroom.getId()).isPresent())
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), ErrorMessages.OBJECT_ALREADY_EXISTS.getTitle(), HttpStatus.BAD_REQUEST);

        try
        {
            return classroomRepository.save(classroom);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }

    }


    public List<Classroom> readClassrooms() {

        try {
            return classroomRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }


    public Classroom updateClassroom(Classroom classroom) {

        Optional<Classroom> classroomOptional = classroomRepository.findById(classroom.getId());

        if(classroom.getId() == null || !classroomOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);


        return classroomRepository.save(classroom);
    }


    public void deleteClassroomById(Long id) {

        Optional<Classroom> classroomOptional = classroomRepository.findById(id);

        if(!classroomOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        classroomRepository.deleteById(id);
    }

}
