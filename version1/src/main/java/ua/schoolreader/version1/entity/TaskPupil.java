package ua.schoolreader.version1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ua.schoolreader.version1.configure.CustomConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "task_pupil", schema = "public", catalog = "SchoolReader v. 1.1")

public class TaskPupil {
    public TaskPupil() {
    }

    public TaskPupil(int taskPupilId,  Status status, int count) {
        this.taskPupilId = taskPupilId;
        this.status = status;
        this.count = count;
    }

    @Id
    @Column(name = "task_pupil_id")
    private int taskPupilId;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "task_id")
        @JsonIgnore
    private Task task;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pupil_id")
    @JsonIgnore
    private  Pupil pupil;
    @Column
    @Convert(converter = CustomConverter.class)
    private  Status status;
    private int count;




    public int getTaskPupilId() {
        return taskPupilId;
    }

    public void setTaskPupilId(int taskPupilId) {
        this.taskPupilId = taskPupilId;
    }



    public Serializable getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
