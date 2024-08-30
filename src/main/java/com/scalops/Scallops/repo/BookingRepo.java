package com.scalops.Scallops.repo;/*  gaajiCode
    99
    30/08/2024
    */

import com.scalops.Scallops.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Long> {
    List<Booking>findByRoomId(Long roomId);

    List<Booking>findByBookingConfirmationCode(String confirmationCode);

    List<Booking>findByUserId(Long userId);



}
