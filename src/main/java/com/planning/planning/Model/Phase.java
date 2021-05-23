package com.planning.planning.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String objectif;
    private String rendu;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    @JoinColumn(nullable = true)
    @JsonIgnore
    private Seance seance;

    public Phase() {
    }

    public Phase(String titre, String objectif, String rendu, Date startTime, Date endTime) {
        this.titre = titre;
        this.objectif = objectif;
        this.rendu = rendu;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getRendu() {
        return rendu;
    }

    public void setRendu(String rendu) {
        this.rendu = rendu;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
}
