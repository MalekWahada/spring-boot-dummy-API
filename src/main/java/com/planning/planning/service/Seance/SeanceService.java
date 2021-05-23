package com.planning.planning.service.Seance;

import com.planning.planning.Model.Seance;
import com.planning.planning.repositories.Seance.ISeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService implements ISeanceService {

    ISeanceRepository seanceRepository;

    public SeanceService(ISeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    @Override
    public Seance addSeance(Seance seance) {
        seanceRepository.save(seance);
        return seance;
    }

    @Override
    public Seance updateSeance(Seance seanceToUpdate, Seance seance) {
        // TODO add edit subMethods
        seanceRepository.save(seance);
        return seance;
    }

    @Override
    public Seance getSeance(Long seanceId) {
        Optional<Seance> seance = seanceRepository.findById(seanceId);
        return seance.orElse(null);
    }

    @Override
    public List<Seance> getSeances() {
        return (List<Seance>) seanceRepository.findAll();
    }

    @Override
    public void deleteSeance(Long seanceId) {
        Optional<Seance> seance = seanceRepository.findById(seanceId);
        // equivalent to if seance.isPresent ---> delete seance object
        seance.ifPresent(value -> seanceRepository.delete(value));
    }
}
