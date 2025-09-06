package com.zaid.patel.REST_APIs.services;

import com.zaid.patel.REST_APIs.DTO.AddStudentDto;
import com.zaid.patel.REST_APIs.DTO.StudentDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudetsById(int id);

    StudentDTO createNewStudent(AddStudentDto addStudentDTO);

    void deleteStudent(int id);

    StudentDTO updateStudent(int id, AddStudentDto addStudentDto);

    StudentDTO updatePartialStudent(int id, Map<String, Object> updates);
}
