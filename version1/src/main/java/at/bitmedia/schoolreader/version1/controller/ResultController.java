package at.bitmedia.schoolreader.version1.controller;


import at.bitmedia.schoolreader.version1.entity.Audio;
import at.bitmedia.schoolreader.version1.entity.Result;
import at.bitmedia.schoolreader.version1.entity.UploadFileResponse;
import at.bitmedia.schoolreader.version1.service.AudioService;
import at.bitmedia.schoolreader.version1.service.ResultServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/secured/result/**")
public class ResultController {
@Autowired
    AudioService fileStorageService;
   @Autowired
    ResultServiceBean resBean;

   @GetMapping("/{id}")
   public Result getResultById(@PathVariable Integer id) {
       return  resBean.findById(id);
   }



   @GetMapping("/all")
   public List<Result> getResultAll() {
       return  resBean.findAll();
   }
    @PostMapping("/add")
             public Result uploadResult(@Valid @RequestBody  Result res) {
        return  resBean.insertResult(res);
    }

    @PostMapping("/uploadAudio")
    public Audio uploadFile(@RequestParam("file") MultipartFile file) {
        return  fileStorageService.storeFile(file);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

        // Load file as Resource
        org.springframework.core.io.Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {

        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename()+ "\"")
                .body(resource);
    }
}
