package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.tools.Tool;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "doctor")
    @JsonIgnoreProperties({"messages", "reservations"})
    private DoctorModel doctorModel;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private ClientModel clientModel;

    public MessageModel(String message, DoctorModel doctorModel, ClientModel clientModel) {
        this.message = message;
        this.doctorModel = doctorModel;
        this.clientModel = clientModel;
    }

    public MessageModel(Integer id, String message, DoctorModel doctorModel, ClientModel clientModel) {
        this.id = id;
        this.message = message;
        this.doctorModel = doctorModel;
        this.clientModel = clientModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
