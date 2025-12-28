package com.yxldev.lottstate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yxldev.lottstate.model.ApiDto;

@Slf4j
@RestController
public class ApiController {

    @PostMapping("/submit")
    public ResponseEntity<String> submit(@RequestBody ApiDto apiDto) {
        return ResponseEntity.ok("Success");
    }

}
