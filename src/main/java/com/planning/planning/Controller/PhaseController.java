package com.planning.planning.Controller;

import com.planning.planning.Model.Phase;
import com.planning.planning.service.Phase.IPhaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhaseController {
    IPhaseService phaseService;

    public PhaseController(IPhaseService phaseService) {
        this.phaseService = phaseService;
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @PostMapping("/phase")
    public ResponseEntity<?> addPhase(@RequestBody Phase phase) {
        return new ResponseEntity<>(phaseService.addPhase(phase), HttpStatus.CREATED);
    }

    @PutMapping("/phase/{id}")
    public ResponseEntity<?> updatePhase(@PathVariable Long id, @RequestBody Phase phase) {
        Phase phaseToUpdate = phaseService.getPhase(id);
        if (phaseToUpdate != null) {
            return new ResponseEntity<> (phaseService.updatePhase(phaseToUpdate, phase), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/phase/{id}")
    public ResponseEntity<?> getPhase(@PathVariable Long id) {
        Phase phase = phaseService.getPhase(id);
        HttpStatus responseStatus = phase != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(phase, responseStatus);
    }

    @GetMapping("/phases")
    public ResponseEntity<?> getPhases() {
        return new ResponseEntity<>(phaseService.getPhases(), HttpStatus.OK);
    }

    @DeleteMapping("/phase/{id}")
    public ResponseEntity<?> deletePhase(@PathVariable Long id) {
        phaseService.deletePhase(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
