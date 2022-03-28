package com.company.servingwebcontent.controller;

import com.company.servingwebcontent.models.config.StudentDto;
import com.company.servingwebcontent.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/students")
public class StudentsController {
    private StudentsService studentsService;

    @Autowired
    StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) {
        return studentsService.addStudent(studentDto);
    }

    @RequestMapping(value = "/remove/{studentId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public boolean removeStudent(@PathVariable("studentId") long studentId) {
        return studentsService.removeStudent(studentId);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<StudentDto> getAllStudents() {
        return studentsService.getAllStudents();
    }

}
