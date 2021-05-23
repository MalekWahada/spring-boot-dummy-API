package com.planning.planning.Controller;

import com.planning.planning.Model.Seance;
import com.planning.planning.service.Seance.ISeanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeanceController {
    ISeanceService seanceService;

    public SeanceController(ISeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @PostMapping("/seance")
    public ResponseEntity<?> addSeance(@RequestBody Seance seance) {
        return new ResponseEntity<>(seanceService.addSeance(seance), HttpStatus.CREATED);
    }

    @PutMapping("/seance/{id}")
    public ResponseEntity<?> updateSeance(@PathVariable Long id, @RequestBody Seance seance) {
        Seance seanceToUpdate = seanceService.getSeance(id);
        if (seanceToUpdate != null) {
            return new ResponseEntity<> (seanceService.updateSeance(seanceToUpdate, seance), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/seance/{id}")
    public ResponseEntity<?> getSeance(@PathVariable Long id) {
        Seance seance = seanceService.getSeance(id);
        HttpStatus responseStatus = seance != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(seance, responseStatus);
    }

    @GetMapping("/seances")
    public ResponseEntity<?> getSeances() {
        return new ResponseEntity<>(seanceService.getSeances(), HttpStatus.OK);
    }

    @DeleteMapping("/seance/{id}")
    public ResponseEntity<?> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
