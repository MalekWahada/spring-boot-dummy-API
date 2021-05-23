package com.planning.planning.service.Phase;

import com.planning.planning.Model.Phase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhaseService {
    public Phase addPhase(Phase phase);
    public Phase updatePhase(Phase phaseToUpdate, Phase phase);
    public Phase getPhase(Long phaseId);
    public List<Phase> getPhases();
    public void deletePhase(Long phaseId);
}
