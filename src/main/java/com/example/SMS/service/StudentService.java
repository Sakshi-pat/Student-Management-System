package com.example.SMS.service;

import com.example.SMS.entity.Student;
import com.example.SMS.exception.ResourceNotFoundException;
import com.example.SMS.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public String add(Student student) {

        studentRepo.save(student);
        return "Student Successfully Added";
    }
    public List<Student> getAll()
    {
        return studentRepo.findAll();
    }
    public Student getById(long id)
    {
        return studentRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found with this id: "+ id));
    }
    public String deleteById(long id)
    {
        if (!studentRepo.existsById(id))
        {
            throw new ResourceNotFoundException("Student not found with this id: "+ id);
        }
        studentRepo.deleteById(id);
        return "Student successfully delete with this id  : "+ id;
    }
    public String updateById(long id, Student updateStudent)
    {
        if (!studentRepo.existsById(id))
        {  throw new ResourceNotFoundException("Student not found with this id: "+ id);
            // return "Student not found with this id: "+ id;
        }
        Student existingStudent = getById(id);
        existingStudent.setName(updateStudent.getName());
        existingStudent.setMarks(updateStudent.getMarks());
        studentRepo.save(existingStudent);

        return "Successfully Update";
    }
}
