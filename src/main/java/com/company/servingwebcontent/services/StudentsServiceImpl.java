//package com.company.servingwebcontent.services;
//
//import com.company.servingwebcontent.models.config.StudentDto;
//import com.company.servingwebcontent.repositories.StudentsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentsServiceImpl implements StudentsService {
//    private final StudentsRepository repository;
//
//    @Autowired
//    StudentsServiceImpl(StudentsRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public StudentDto addStudent(StudentDto student) {
//        return repository.save(student);
//    }
//
//    @Override
//    public List<StudentDto> getAllStudents() {
//        return repository.findAll();
//    }
//}
