package ua.schoolreader.version1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.schoolreader.version1.entity.Pupil;
import ua.schoolreader.version1.entity.Task;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    Task findTaskByDescription(String description);
}
