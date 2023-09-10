package com.juba.springtest.repository.snowflake;
import com.juba.springtest.model.snowflake.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {

}
