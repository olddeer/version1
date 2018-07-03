package ua.schoolreader.version1.service;

import org.springframework.http.ResponseEntity;
import ua.schoolreader.version1.entity.Pupil;
import ua.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface TaskPupilService  extends  TypicalService<TaskPupil> {


    List<TaskPupil> findByTitle(String title);
    List<TaskPupil> findAllTasksByUsername(String name);
    TaskPupil insertTaskPupil(TaskPupil tp);
}
