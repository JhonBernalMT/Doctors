package com.doctors.service;

import com.doctors.model.ReservationModel;
import com.doctors.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservation(){
        return reservationRepository.getAllReservation();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationRepository.saveReservation(reservationModel);
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        return reservationRepository.updateReservation(reservationModel);
    }

    public boolean deleteReservation(Integer id){
        return reservationRepository.deleteReservation(id);
    }
}
