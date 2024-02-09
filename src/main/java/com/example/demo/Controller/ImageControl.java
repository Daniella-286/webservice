package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import com.example.demo.service.UploadService;

@RestController
@RequestMapping("/app")
public class ImageControl {
    private final UploadService imageService;
    private final PhotoService photoService;

    public ImageControl(UploadService imageService,PhotoService photoService) {
        this.imageService = imageService;
        this.photoService = photoService;
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return imageService.upload(multipartFile);
    }

    /*public ResponseEntity<Photo> insertPhoto(@RequestParam("file") MultipartFile multipartFile) {
        String photo =  imageService.upload(multipartFile);
        Photo p = new Photo(1,1,photo);
        return new ResponseEntity<>(photoService.savePhoto(p),HttpStatus.OK);
    }*/
    @GetMapping("/photo")
    public ResponseEntity<Photo> insertPhoto(@RequestParam("file") MultipartFile multipartFile) {
        String photo = upload(multipartFile);
        Photo p = new Photo(1,1,photo);
        return photoService.savePhoto(p);
    }
}
