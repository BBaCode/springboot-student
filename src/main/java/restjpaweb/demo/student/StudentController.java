package restjpaweb.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long id) throws IllegalStateException {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@RequestBody Student student, @PathVariable("studentID") Long id) throws IllegalStateException {
        studentService.updateStudent(id, student.getName(), student.getEmail());
    }
}
