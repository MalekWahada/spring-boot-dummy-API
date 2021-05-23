package com.planning.planning.service.Seance;

import com.planning.planning.Model.Seance;

import java.util.List;

public interface ISeanceService {
    public Seance addSeance(Seance seance);
    public Seance updateSeance(Seance seanceToUpdate, Seance seance);
    public Seance getSeance(Long seanceId);
    public List<Seance> getSeances();
    public void deleteSeance(Long seanceId);
}
