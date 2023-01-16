package restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import restApi.exception.ResourceNotFoundException;
import restApi.pojo.entity.Student;
import restApi.repository.TeacherStudentRepo;

import java.util.HashMap;

@RestController
@RequestMapping("")
public class StudentTeacherController {

    private final TeacherStudentRepo repo;

    @Autowired
    public StudentTeacherController(TeacherStudentRepo teacherStudentRepo) {
        this.repo = teacherStudentRepo;
    }

    @GetMapping("/student?id={id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(repo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> getEmp(@RequestBody Student student) {
        return new ResponseEntity<>(repo.insertToStudent(student.getId(), student.getName()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> deleteEmp(@RequestBody Student student) {
        return new ResponseEntity<>(repo.RemoveToStudent(student.getId()), HttpStatus.OK);
    }


    @PutMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> updateEmp(@RequestBody Student student) {
        return new ResponseEntity<>(repo.UpdateStudent(student.getId(), student.getName()), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException() {
        return new ResponseEntity<>("xxx not found", HttpStatus.NOT_FOUND);
    }

}
