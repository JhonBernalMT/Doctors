package com.doctors.controller;

import com.doctors.model.ReservationModel;
import com.doctors.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAllReservations(){
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.saveReservation(reservationModel);
    }

    @PutMapping("/update")
    public ReservationModel updateReservation(ReservationModel reservationModel){
        return  reservationService.updateReservation(reservationModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteReservation(Integer id){
        return reservationService.deleteReservation(id);
    }
}
