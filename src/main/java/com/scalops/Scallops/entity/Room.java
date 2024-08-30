package com.scalops.Scallops.entity;/*  gaajiCode
    99
    29/08/2024
    */

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roomType;
    private String roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List <Booking> bookings=new ArrayList<>();
}
