package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Photo;
import com.example.demo.repository.PhotoRepository;

@Service
public class PhotoService {
    private final PhotoRepository photoRep;
    @Autowired
    public PhotoService(PhotoRepository photoRep) {
        this.photoRep = photoRep;
    }
    public ResponseEntity<Photo> savePhoto(Photo p) {
        return new ResponseEntity<>(photoRep.save(p),HttpStatus.OK);
    }

    public ResponseEntity<List<Photo>> getPhotoVoiture(int id){
        return new ResponseEntity<>(photoRep.findPhotoAnnonce(id),HttpStatus.OK);
    }
}
