package com.scalops.Scallops.service.interfaces;/*  gaajiCode
    99
    31/08/2024
    */

import com.scalops.Scallops.dto.Response;
import com.scalops.Scallops.entity.Booking;

public interface IBookingService {
    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
