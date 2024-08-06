package com.riwi.tonerink.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.tonerink.api.dto.request.LoginReq;
import com.riwi.tonerink.api.dto.request.RegisterReq;
import com.riwi.tonerink.api.dto.response.AuthResp;
import com.riwi.tonerink.infrastructure.abstract_service.IAuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final IAuthService authService;

    @PostMapping(path = "/auth/login")
    public ResponseEntity<AuthResp> login(
        @Validated @RequestBody LoginReq request
    ){
        return ResponseEntity.ok(this.authService.login(request));
    }

    @PostMapping(path = "/auth/register")
    public ResponseEntity<AuthResp> register(
        @Validated @RequestBody RegisterReq request
    ){
        return ResponseEntity.ok(this.authService.register(request));
    }
}
