
package com.juba.springtest.model.snowflake;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "CLASS_ID")
    private String classId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
    
    

}