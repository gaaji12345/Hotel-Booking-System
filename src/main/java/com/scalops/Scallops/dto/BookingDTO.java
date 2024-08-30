package com.scalops.Scallops.dto;/*  gaajiCode
    99
    29/08/2024
    */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.scalops.Scallops.entity.Room;
import com.scalops.Scallops.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numOfAdults;
    private int numOfChildern;
    private int totalNumOfGuest;
    private String bookingConfirmationCode;

    private UserDTO user;

    private RoomDTO room;
}
