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
public class ExamScheduleServiceImpl implements ExamScheduleService {
    @Autowired
    private ExamScheduleRepository examScheduleRepository;
    @Override
    public ExamSchedule saveExamSchedule(ExamSchedule examSchedule) {
        ExamSchedule es = null;
        try
        {
            es = examScheduleRepository.save(examSchedule);
        } catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
        return es;
    }
    @Override
    public List<ExamSchedule> fetchExamSchedules() {
        try {
            return examScheduleRepository.findAll();
        }catch (Exception e)
        {
            throw new ApplicationException(ErrorMessages.TRANSACTION_FAILED.getValue(), e.getMessage().toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ExamSchedule updateExamSchedule(ExamSchedule examSchedule) {

        Optional<ExamSchedule> es = examScheduleRepository.findById(examSchedule.getId());

        if(examSchedule.getId() == null || !es.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);

        return examScheduleRepository.save(examSchedule);
    }
    @Override
    public void deleteExamScheduleById(Long id) {
        Optional<ExamSchedule> es = examScheduleRepository.findById(id);
        if(!es.isPresent())
            throw new ApplicationException(ErrorMessages.RECORD_NOT_FOUND.getValue(), ErrorMessages.RECORD_NOT_FOUND.getTitle(), HttpStatus.BAD_REQUEST);
        examScheduleRepository.deleteById(id);
    }
}
