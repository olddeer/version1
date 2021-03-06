package at.bitmedia.schoolreader.version1.service;

import at.bitmedia.schoolreader.version1.entity.TaskPupil;
import at.bitmedia.schoolreader.version1.repositories.TaskPupilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskPupilServiceBean implements  TaskPupilService{
   @Autowired
   TaskPupilRepo taskRepo;

    @Override
    public TaskPupil insertTaskPupil(TaskPupil tp) {
        return taskRepo.save(tp);
    }

    @Override
    public List<TaskPupil> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public List<TaskPupil> findByTitle(String title) {
        return taskRepo.findAllByTask_Description(title);
    }

    @Override
    public List<TaskPupil> findAllTasksByUsername(String name) {
        return taskRepo.findAllByPupil_Username(name);
    }

    @Override
    public TaskPupil findById(int id) {
        return taskRepo.findById(id).get();
    }
}
