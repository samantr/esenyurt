package com.esenyurt.service;

import com.esenyurt.entity.Semester;

import java.util.List;

public interface SemesterService {

    Semester saveSemester(Semester semester);
    List<Semester> fetchSemesters();
    Semester updateSemester(Semester semester);
    void deleteSemesterById(Long id);

}
