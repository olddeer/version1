package ua.schoolreader.version1.service;

import ua.schoolreader.version1.entity.Task;
import ua.schoolreader.version1.entity.TaskPupil;

import java.util.List;

public interface TaskService extends TypicalService<Task> {
    Task insertTask(Task tp);
    Task findByDescription(String desk);
}
