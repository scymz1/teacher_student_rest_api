package restApi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restApi.pojo.entity.Student;
import restApi.repository.TeacherStudentRepoImpl;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentServicce {
    private TeacherStudentRepoImpl teacherStudentRepo;

    @Override
    public Student getStudentById(String id) {
        return teacherStudentRepo.findById(id);
    }

    @Override
    public String updateStudent(String id, String name) {
        return teacherStudentRepo.UpdateStudent(id, name);
    }

    @Override
    public String removeStudent (String id, String name) {
        return teacherStudentRepo.RemoveToStudent(id);
    }

    @Override
    public String insertStudent (String id, String name) {
        return teacherStudentRepo.insertToStudent(id, name);
    }

}
