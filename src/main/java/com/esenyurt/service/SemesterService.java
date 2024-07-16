package com.esenyurt.service;

import com.esenyurt.entity.Semester;
import com.esenyurt.enums.ErrorMessages;
import com.esenyurt.exception.ApplicationException;
import com.esenyurt.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public Semester createSemester(Semester semester) {
        if(semester.getId() != null)
            if (semesterRepository.findById(semester.getId()).isPresent())
                throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), ErrorMessages.OBJECT_ALREADY_EXISTS.getTitle(), HttpStatus.BAD_REQUEST);

        try
        {
            return semesterRepository.save(semester);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }


    public List<Semester> readSemesters() {
        return semesterRepository.findAll();
    }


    public Semester updateSemester(Semester semester) {
        Optional<Semester> semesterOptional = semesterRepository.findById(semester.getId());

        if(semester.getId() == null || !semesterOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        return semesterRepository.save(semester);
    }


    public void deleteSemesterById(Long id) {
        Optional<Semester> semesterOptional = semesterRepository.findById(id);
        if(!semesterOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        semesterRepository.deleteById(id);
    }
}
