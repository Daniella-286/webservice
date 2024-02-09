package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.sql.Timestamp;
import com.example.demo.model.Status;
import com.example.demo.repository.StatusRepository;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public void validerAnnonce(Long idAnnonce) {
        Status status = new Status();
        status.setIdAnnonce(idAnnonce);
        status.setDateStatus(Timestamp.from(Instant.now()));
        status.setStatu(5);

        statusRepository.save(status);
    }


}
