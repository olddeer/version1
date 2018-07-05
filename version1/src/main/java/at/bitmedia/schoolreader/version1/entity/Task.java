package at.bitmedia.schoolreader.version1.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SR_TASK")
public class Task {
    @Id
    @Column(name = "SRTA_ID")
    private int taskId;
    private String description;
    @OneToMany(mappedBy = "task")
    private Set<TaskPupil> tasksPupil = new HashSet<>();

    public Task(int taskId, String description) {
        this.taskId = taskId;
        this.description = description;

    }
    @Column(name = "CREATE_DATE")
    private LocalDateTime create_date;
    @Column(name = "UPDATE_DATE")
    private LocalDateTime update_date;

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
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
