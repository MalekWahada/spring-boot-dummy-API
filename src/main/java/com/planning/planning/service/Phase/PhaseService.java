package com.planning.planning.service.Phase;

import com.planning.planning.Model.Phase;
import com.planning.planning.repositories.Phase.IPhaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhaseService implements IPhaseService {

    IPhaseRepository IPhaseRepository;

    public PhaseService(IPhaseRepository IPhaseRepository) {
        this.IPhaseRepository = IPhaseRepository;
    }

    @Override
    public Phase addPhase(Phase phase) {
        IPhaseRepository.save(phase);
        return phase;
    }

    @Override
    public Phase updatePhase(Phase phaseToUpdate, Phase phase) {
        phaseToUpdate.setTitre(phase.getTitre() != null ? phase.getTitre() : phaseToUpdate.getTitre());
        phaseToUpdate.setObjectif(phase.getObjectif() != null ? phase.getObjectif() : phaseToUpdate.getObjectif());
        phaseToUpdate.setRendu(phase.getRendu() != null ? phase.getRendu() : phaseToUpdate.getRendu());
        phaseToUpdate.setStartTime(phase.getStartTime() != null ? phase.getStartTime() : phaseToUpdate.getStartTime());
        phaseToUpdate.setEndTime(phase.getEndTime()  != null ? phase.getEndTime() : phaseToUpdate.getEndTime());

        if (phase.getSeance() != null) {
            phaseToUpdate.setSeance(phase.getSeance());
        }

        IPhaseRepository.save(phaseToUpdate);
        return phaseToUpdate;
    }

    @Override
    public Phase getPhase(Long phaseId) {
        Optional<Phase> phase = IPhaseRepository.findById(phaseId);
        return phase.orElse(null);
    }

    @Override
    public List<Phase> getPhases() {
        return (List<Phase>) IPhaseRepository.findAll();
    }

    @Override
    public void deletePhase(Long phaseId) {
        Optional<Phase> phase = IPhaseRepository.findById(phaseId);
        // equivalent to if phase.isPresent ---> delete phase object
        phase.ifPresent(value -> IPhaseRepository.delete(value));
    }
}
