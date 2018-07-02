package ua.schoolreader.version1.entity;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Task {
    @Id
    @Column(name = "task_id")
    private int taskId;
    private String description;
    @OneToMany(mappedBy = "task")
    private Set<TaskPupil> tasksPupil = new HashSet<>();

    public Task(int taskId, String description) {
        this.taskId = taskId;
        this.description = description;

    }

    public Task() {
    }

    public Set<TaskPupil> getTasksPupil() {
        return tasksPupil;
    }

    public void setTasksPupil(Set<TaskPupil> tasksPupil) {
        this.tasksPupil = tasksPupil;
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
