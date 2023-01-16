package restApi.repository;

import org.springframework.stereotype.Repository;
import restApi.pojo.entity.Student;

import java.util.Collection;

@Repository
public interface TeacherStudentRepo {
    Student findById(String id);

    String insertToStudent(String id, String name);

    String RemoveToStudent(String id);

    public String UpdateStudent(String id, String name);
}
