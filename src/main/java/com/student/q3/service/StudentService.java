package com.student.q3.service;
import java.util.List;
import java.util.Comparator;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.student.q3.model.Student;
import com.student.q3.repository.StudentRepository;
import com.student.q3.dto.PerformanceRequest;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student) {
        if (repository.existsById(student.getStudentId())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Student already exists"
            );
        }
        return repository.save(student);
    }
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Student not found"
            ));
    }
  
    public Student updatePerformance(
            int id, PerformanceRequest request) {

        Student student = getStudentById(id);
        student.setProgrammingScore(
            request.getProgrammingScore()
        );

        student.setMathematicsScore(
            request.getMathematicsScore()
        );

        student.setTechnicalSkills(
            request.getTechnicalSkills()
        );

        return repository.save(student);
    }

    public String deleteStudent(int id) {

        Student student = getStudentById(id);

        repository.delete(student);

        return "Student deleted successfully";
    }

  
    public List<Student> getMeritList() {

        List<Student> students = repository.findAll();

        students.sort(
            Comparator.comparingDouble(
                Student::getAverageScore
            ).reversed()
        );

        return students;
    }
}