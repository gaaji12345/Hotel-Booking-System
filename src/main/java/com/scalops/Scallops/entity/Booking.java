package com.scalops.Scallops.entity;/*  gaajiCode
    99
    28/08/2024
    */

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "check in date required")
    private LocalDate checkInDate;
    @NotNull(message = "check out date required")
    private LocalDate checkOutDate;

    @Min(value = 1,message = "Number of  adults must not be less that 1")
    private int numOfAdults;

    @Min(value = 0,message = "Number of  children must not be less that 0")
    private int numOfChildern;
    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;


    public void  calculateTotalNumberOfGuest(){
        this.totalNumOfGuest=this.numOfAdults +this.numOfChildern;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildern(int numOfChildern) {
        this.numOfChildern = numOfChildern;
        calculateTotalNumberOfGuest();
    }

}
