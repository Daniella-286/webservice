package com.example.demo.Controller;

import com.example.demo.model.Commission;
import com.example.demo.model.CommissionReport;
import com.example.demo.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commissions")
public class CommissionController {

    private final CommissionService commissionService;

    @Autowired
    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @PostMapping
    public ResponseEntity<Commission> createCommission(@RequestBody Commission commission) {
        Commission createdCommission = commissionService.createCommission(commission);
        return new ResponseEntity<>(createdCommission, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Commission>> getAllCommissions() {
        List<Commission> commissions = commissionService.getAllCommissions();
        return new ResponseEntity<>(commissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commission> getCommissionById(@PathVariable String id) {
        Optional<Commission> commissionOptional = commissionService.getCommissionById(id);

        if (commissionOptional.isPresent()) {
            Commission commission = commissionOptional.get();
            return new ResponseEntity<>(commission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Commission> updateCommission(@PathVariable String id, @RequestBody Commission commission) {
        Commission updatedCommission = commissionService.updateCommission(id, commission);
        return new ResponseEntity<>(updatedCommission, HttpStatus.OK);
    }

    // Endpoint pour supprimer une commission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommission(@PathVariable String id) {
        commissionService.deleteCommission(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/monthly-report")
    public List<CommissionReport> getMonthlyCommissionReport() {
        return commissionService.getMonthlyCommissionReport();
    }
}
