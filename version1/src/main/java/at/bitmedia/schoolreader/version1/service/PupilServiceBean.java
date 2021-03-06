package at.bitmedia.schoolreader.version1.service;

import at.bitmedia.schoolreader.version1.entity.Pupil;
import at.bitmedia.schoolreader.version1.entity.TaskPupil;
import at.bitmedia.schoolreader.version1.repositories.TaskPupilRepo;
import at.bitmedia.schoolreader.version1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PupilServiceBean implements PupilService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TaskPupilRepo taskRepo;

    @Override
    public Pupil findById(int id) {
        Pupil newPupil = userRepo.findById(id).get();
        return newPupil;
    }

    @Override
    public List<Pupil> findAll() {
        List<Pupil> list = userRepo.findAll();
        return list;
    }

    @Override
    public Pupil findByUsername(String name) {
      Pupil newPupil = userRepo.findByUsername(name);
        return newPupil;
    }

    @Override
    public List<TaskPupil> findAllTasksByUsername(String name) {
        List<TaskPupil> list = taskRepo.findAllByPupil_Username(name);
        return list;
    }
}
