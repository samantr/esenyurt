package com.esenyurt.service;

import com.esenyurt.entity.ExamSchedule;
import com.esenyurt.enums.ErrorMessages;
import com.esenyurt.exception.ApplicationException;
import com.esenyurt.repository.ExamScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamScheduleService {
    @Autowired
    private ExamScheduleRepository examScheduleRepository;

    public ExamSchedule createExamSchedule(ExamSchedule examSchedule) {

        if(examSchedule.getId() != null)
            if (examScheduleRepository.findById(examSchedule.getId()).isPresent())
                throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), ErrorMessages.OBJECT_ALREADY_EXISTS.getTitle(), HttpStatus.BAD_REQUEST);

        try
        {
            return examScheduleRepository.save(examSchedule);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<ExamSchedule> readExamSchedules() {
        try {
            return examScheduleRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }


    public ExamSchedule updateExamSchedule(ExamSchedule examSchedule) {

        Optional<ExamSchedule> examScheduleOptional = examScheduleRepository.findById(examSchedule.getId());

        if(examSchedule.getId() == null || !examScheduleOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        return examScheduleRepository.save(examSchedule);
    }

    public void deleteExamScheduleById(Long id) {
        Optional<ExamSchedule> examScheduleOptional = examScheduleRepository.findById(id);
        if(!examScheduleOptional.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);
        examScheduleRepository.deleteById(id);
    }
}
