package com.zaid.patel.REST_APIs.services.impl;

import com.zaid.patel.REST_APIs.DTO.AddStudentDto;
import com.zaid.patel.REST_APIs.DTO.StudentDTO;
import com.zaid.patel.REST_APIs.entity.Students;
import com.zaid.patel.REST_APIs.repository.StudentRepository;
import com.zaid.patel.REST_APIs.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        List<Students> st = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Students student : st){
            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getEmail());
            studentDTOList.add(studentDTO);
        }

        return studentDTOList;
    }

    @Override
    public StudentDTO getStudetsById(int id) {
        Students students = studentRepository.findById((long) id).orElseThrow(()-> new IllegalArgumentException("No student with ID"+id));
        return  new StudentDTO(students.getId(), students.getName(), students.getEmail());
    }

    @Override
    public StudentDTO createNewStudent(AddStudentDto addStudentDTO) {
        Students newStudent = new Students();
        newStudent.setName(addStudentDTO.getName());
        newStudent.setEmail(addStudentDTO.getEmail());
        Students students = studentRepository.save(newStudent);
        return new StudentDTO(students.getId(), students.getName(), students.getEmail());
    }

    @Override
    public void deleteStudent(int id) {
        if(!studentRepository.existsById((long)id)){
            throw new IllegalArgumentException("Student does not Exist with ID : "+id);
        }
        studentRepository.deleteById((long)id);
    }

    @Override
    public StudentDTO updateStudent(int id, AddStudentDto addStudentDto) {
        Students students =  studentRepository.findById((long)id).orElseThrow(() -> new IllegalArgumentException("The Exist No Student With ID : "+id));
        students.setName(addStudentDto.getName());
        students.setEmail(addStudentDto.getEmail());

        Students updatedStudent = studentRepository.save(students);

        return new StudentDTO(updatedStudent.getId(), updatedStudent.getName(), updatedStudent.getEmail());
    }

    @Override
    public StudentDTO updatePartialStudent(int id, Map<String, Object> updates) {
        Students students =  studentRepository.findById((long)id).orElseThrow(() -> new IllegalArgumentException("The Exist No Student With ID : "+id));
        updates.forEach((field, value)->{
            if (value == null) {
                throw new IllegalArgumentException("Field '" + field + "' cannot be null");
            }
            switch (field){
                case "name": students.setName(value.toString());
                break;
                case "email": students.setEmail(value.toString());
                break;
                default: throw new IllegalArgumentException("Field '" + field + "' is not supported");
            }
        });
        Students updated = studentRepository.save(students);
        return new StudentDTO(updated.getId(), updated.getName(), updated.getEmail());
    }

}
