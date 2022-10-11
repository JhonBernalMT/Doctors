package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "doctor")
public class DoctorModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String description;

    @ManyToOne
    @JoinColumn(name = "specialtyId")
    @JsonIgnoreProperties("doctors")
    private SpecialtyModel specialtyModel;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<MessageModel> messageModels;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "messages"})
    private List<ReservationModel> reservationModels;

    //Instancia de uno vacio y necesitamos generar parametros
    //Constructor es una METODO que permite instanciar una clase
    // Caracteristica = Declarar Doctor>DoctorModel>doctor.setname(atributo)
    public DoctorModel() {
    }

    public DoctorModel(String name, String email, Integer age, String description, SpecialtyModel specialtyModel, List<MessageModel> messageModels, List<ReservationModel> reservationModels) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.description = description;
        this.specialtyModel = specialtyModel;
        this.messageModels = messageModels;
        this.reservationModels = reservationModels;
    }

    public DoctorModel(Integer id, String name, String email, Integer age, String description, SpecialtyModel specialtyModel, List<MessageModel> messageModels, List<ReservationModel> reservationModels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.description = description;
        this.specialtyModel = specialtyModel;
        this.messageModels = messageModels;
        this.reservationModels = reservationModels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpecialtyModel getSpecialtyModel() {
        return specialtyModel;
    }

    public void setSpecialtyModel(SpecialtyModel specialtyModel) {
        this.specialtyModel = specialtyModel;
    }

    public List<MessageModel> getMessageModels() {
        return messageModels;
    }

    public void setMessageModels(List<MessageModel> messageModels) {
        this.messageModels = messageModels;
    }

    public List<ReservationModel> getReservationModels() {
        return reservationModels;
    }

    public void setReservationModels(List<ReservationModel> reservationModels) {
        this.reservationModels = reservationModels;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
