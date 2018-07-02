package ua.schoolreader.version1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ua.schoolreader.version1.entity.Pupil;
import ua.schoolreader.version1.entity.Task;


public interface UserRepo extends JpaRepository<Pupil,Integer> {
   Pupil findByUsername(String username);


}
