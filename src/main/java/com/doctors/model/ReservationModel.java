package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.tools.Tool;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class ReservationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "doctor")
    @JsonIgnoreProperties("reservations")
    private DoctorModel doctorModel;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations", "messages"})
    private ClientModel clientModel;

    private String score;

    public ReservationModel(Date startDate, Date devolutionDate, String status, DoctorModel doctorModel, ClientModel clientModel, String score) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.doctorModel = doctorModel;
        this.clientModel = clientModel;
        this.score = score;
    }

    public ReservationModel(Integer id, Date startDate, Date devolutionDate, String status, DoctorModel doctorModel, ClientModel clientModel, String score) {
        this.id = id;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.doctorModel = doctorModel;
        this.clientModel = clientModel;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DoctorModel getDoctorModel() {
        return doctorModel;
    }

    public void setDoctorModel(DoctorModel doctorModel) {
        this.doctorModel = doctorModel;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}