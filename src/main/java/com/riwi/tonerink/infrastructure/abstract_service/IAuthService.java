package com.riwi.tonerink.infrastructure.abstract_service;

import com.riwi.tonerink.api.dto.request.LoginReq;
import com.riwi.tonerink.api.dto.request.RegisterReq;
import com.riwi.tonerink.api.dto.response.AuthResp;

public interface IAuthService {
    
    public AuthResp login(LoginReq request);
    public AuthResp register(RegisterReq request);

}
