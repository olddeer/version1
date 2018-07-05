package at.bitmedia.schoolreader.version1.entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Table(name ="SR_TEACHER_CLASS",schema = "public" )
public class TeacherClass {
    @Id
    @Column(name = "SRT_C_ID")
    private int taskPupilId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRT_ID")
    @JsonIgnore
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SRC_ID")
    @JsonIgnore
    private  Class  class2;

    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;

    public int getTaskPupilId() {
        return taskPupilId;
    }

    public void setTaskPupilId(int taskPupilId) {
        this.taskPupilId = taskPupilId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Class getClass2() {
        return class2;
    }

    public void setClass2(Class class2) {
        this.class2 = class2;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }
}
