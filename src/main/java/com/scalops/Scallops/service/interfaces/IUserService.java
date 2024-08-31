package com.scalops.Scallops.service.interfaces;/*  gaajiCode
    99
    31/08/2024
    */

import com.scalops.Scallops.dto.LoginRequest;
import com.scalops.Scallops.dto.Response;
import com.scalops.Scallops.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);
}
