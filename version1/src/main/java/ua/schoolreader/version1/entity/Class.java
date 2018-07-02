package ua.schoolreader.version1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "public", catalog = "SchoolReader v. 1.1")
public class Class {
    @Id
    @Column(name = "class_id")
    private int classId;

    public Class() {
    }

    public Class(int classId,  String title) {
        this.classId = classId;

        this.title = title;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    private String title;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
