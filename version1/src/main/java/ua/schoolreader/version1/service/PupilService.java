package ua.schoolreader.version1.service;

import ua.schoolreader.version1.entity.Pupil;
import ua.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface PupilService extends  TypicalService<Pupil>{
    Pupil findByUsername(String name);
    List<TaskPupil> findAllTasksByUsername(String name);
}
