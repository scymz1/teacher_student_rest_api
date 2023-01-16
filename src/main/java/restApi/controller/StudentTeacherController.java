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
import restApi.service.StudentServicce;

import java.util.HashMap;

@RestController
@RequestMapping("")
public class StudentTeacherController {

    private final StudentServicce ss;

    @Autowired
    public StudentTeacherController(StudentServicce ss) {
        this.ss = ss;
    }

    @GetMapping("/student?id={id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(ss.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> getEmp(@RequestBody Student student) {
        return new ResponseEntity<>(ss.insertStudent(student.getId(), student.getName()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> deleteEmp(@RequestBody Student student) {
        return new ResponseEntity<>(ss.removeStudent(student.getId(), student.getName()), HttpStatus.OK);
    }


    @PutMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //@RequestBody String id, @RequestBody String name
    public ResponseEntity<String> updateEmp(@RequestBody Student student) {
        return new ResponseEntity<>(ss.updateStudent(student.getId(), student.getName()), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException() {
        return new ResponseEntity<>("xxx not found", HttpStatus.NOT_FOUND);
    }

}
