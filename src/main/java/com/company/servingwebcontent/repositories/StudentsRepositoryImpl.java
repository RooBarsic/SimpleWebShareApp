package com.company.servingwebcontent.repositories;

import com.company.servingwebcontent.models.config.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentsRepositoryImpl implements StudentsRepository {
    private ConcurrentHashMap<Long, StudentDto> studentById = new ConcurrentHashMap<>();
    private AtomicLong atomicLong = new AtomicLong(0);

    @Override
    public List<StudentDto> findAll() {
        return new ArrayList<>(studentById.values());
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        studentDto.id = atomicLong.incrementAndGet();
        studentById.put(studentDto.id, studentDto);
        return studentDto;
    }

    @Override
    public boolean removeById(Long studentId) {
        StudentDto studentDto = studentById.remove(studentId);
        return studentDto != null;
    }
}
