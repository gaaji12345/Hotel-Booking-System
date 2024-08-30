package com.scalops.Scallops.dto;/*  gaajiCode
    99
    29/08/2024
    */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.scalops.Scallops.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<BookingDTO> bookings;

}
