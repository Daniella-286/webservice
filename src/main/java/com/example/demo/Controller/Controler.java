package com.example.demo.Controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Test;
import com.example.demo.model.TestRepository;
import com.example.demo.model.Utilisateur;

import io.jsonwebtoken.io.IOException;

@RestController
public class Controler {
    @Autowired
    private TestRepository testRepository;
   
    //C:\Users\ASUS\Pictures\Saved Pictures

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file) {
        
        try {
            byte[] fileBytes = file.getBytes();
            String base64EncodedFile = Base64.encodeBase64String(fileBytes);
            
            String destinationFolder = "C:\\Users\\ASUS\\Pictures\\Camera Roll";

            // Nom du fichier de destination
            String fileName = file.getOriginalFilename();

            // Chemin complet du fichier de destination
            Path destinationPath = Path.of(destinationFolder, fileName);

            // Écrire le contenu du fichier dans le dossier de destination
            Files.write(destinationPath, fileBytes);

            //String base64Image = requestBody.get("image");
            /*System.out.println("%%%%%%%% "+base64Image);
            String[] parts = base64Image.split(",");
            String imageData = parts[1];
            System.out.println("%%%%%%%% "+imageData);
            byte[] imageBytes = Base64.decodeBase64(imageData);*/

            // Traitez les bytes de l'image selon vos besoins
            // ...
            return ResponseEntity.ok("Fichier encodé en base64 : " + base64EncodedFile);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
    @GetMapping("/etudiant")
    public List<Test> getEtudiantsParNom() {
        return testRepository.findAll();
    }
    
 

 
}
