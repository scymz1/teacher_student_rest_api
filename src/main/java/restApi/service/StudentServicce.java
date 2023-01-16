package restApi.service;

import restApi.pojo.entity.Student;

public interface StudentServicce {

    public Student getStudentById(String id);

    public String updateStudent(String id, String name);

    public String removeStudent (String id, String name);

    public String insertStudent (String id, String name);
}
