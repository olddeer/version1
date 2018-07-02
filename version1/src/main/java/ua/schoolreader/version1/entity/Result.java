package ua.schoolreader.version1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="result")
public class Result {
    @Id
    @Column(name = "result_id")
    private int resultId;


    @JoinColumn(name = "task_pupil_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private TaskPupil taskPupil;
    private String audio;
    private String comment;

    public Result() {
    }

    public Result(int resultId,  String audio, String comment) {
        this.resultId = resultId;

        this.audio = audio;
        this.comment = comment;
    }

    public TaskPupil getTaskPupil() {
        return taskPupil;
    }

    public void setTaskPupil(TaskPupil taskPupil) {
        this.taskPupil = taskPupil;
    }


    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }



    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
