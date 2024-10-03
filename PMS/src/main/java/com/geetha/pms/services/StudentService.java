package com.geetha.pms.services;


import com.geetha.pms.entities.Student;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Service class for Student entity.
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAll() {
        return repo.findAll();
    }

    public Student get(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
    }

    public Student save(Student student) {
        return repo.save(student);
    }

    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
