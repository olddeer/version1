package ua.schoolreader.version1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.schoolreader.version1.entity.Pupil;
import ua.schoolreader.version1.entity.TaskPupil;
import ua.schoolreader.version1.repositories.TaskPupilRepo;
import ua.schoolreader.version1.repositories.UserRepo;
import ua.schoolreader.version1.service.PupilServiceBean;
import ua.schoolreader.version1.service.TaskPupilServiceBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pupil/**")
public class MainController {

    @Autowired
   private PupilServiceBean repo;
@Autowired
private TaskPupilServiceBean taskRepo;

    @RequestMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<Pupil>> findAll(){

    return  new ResponseEntity<List<Pupil>>(repo.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value= "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Pupil> findById(@PathVariable Integer id){
        return  new ResponseEntity<Pupil>(repo.findById(id), HttpStatus.OK);}

    @RequestMapping(value = "/findAllTasks",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<List<TaskPupil>> findTasks(@RequestParam String username){
        return  new ResponseEntity<List<TaskPupil>>(taskRepo.findAllTasksByUsername(username), HttpStatus.OK);}


}
