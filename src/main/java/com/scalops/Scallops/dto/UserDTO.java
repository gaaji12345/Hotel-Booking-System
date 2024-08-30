package com.scalops.Scallops.dto;/*  gaajiCode
    99
    29/08/2024
    */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.scalops.Scallops.entity.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<BookingDTO>bookings=new ArrayList<>();

}
