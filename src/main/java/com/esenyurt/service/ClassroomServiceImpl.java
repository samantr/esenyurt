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
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public Classroom saveClassroom(Classroom classroom) {
        Classroom c = null;
        try
        {
            c = classroomRepository.save(classroom);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
        return c;
    }

    @Override
    public List<Classroom> fetchClassrooms() {

        try {
            return classroomRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {

        Optional<Classroom> c = classroomRepository.findById(classroom.getId());

        if(classroom.getId() == null || !c.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);


        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteClassroomById(Long id) {
        Optional<Classroom> c = classroomRepository.findById(id);
        if(!c.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        classroomRepository.deleteById(id);
    }

}
