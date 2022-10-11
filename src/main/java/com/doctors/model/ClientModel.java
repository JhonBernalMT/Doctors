package com.doctors.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class ClientModel implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<MessageModel> messageModels;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<ReservationModel> reservationModels;

    public ClientModel(String name, String email, String password, Integer age, List<MessageModel> messageModels, List<ReservationModel> reservationModels) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.messageModels = messageModels;
        this.reservationModels = reservationModels;
    }

    public ClientModel(Integer id, String name, String email, String password, Integer age, List<MessageModel> messageModels, List<ReservationModel> reservationModels) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.messageModels = messageModels;
        this.reservationModels = reservationModels;
    }

    public ClientModel() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}


