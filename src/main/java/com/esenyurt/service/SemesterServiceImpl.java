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
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;
    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public List<Semester> fetchSemesters() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester updateSemester(Semester semester) {
        Optional<Semester> s = semesterRepository.findById(semester.getId());

        if(semester.getId() == null || !s.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        return semesterRepository.save(semester);
    }

    @Override
    public void deleteSemesterById(Long id) {
        Optional<Semester> s = semesterRepository.findById(id);
        if(!s.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        semesterRepository.deleteById(id);
    }
}
