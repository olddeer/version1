package at.bitmedia.schoolreader.version1.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name ="SR_RESULT")
public class Result {
    @Id
    @Column(name = "SRR_ID")
    private int resultId;


    @JoinColumn(name = "SRT_P_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TaskPupil taskPupil;
    @JoinColumn(name = "SRA_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Audio audio;
    private String comment;
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

    public Result() {
    }

    public Result(int resultId,  Audio audio, String comment) {
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



    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
