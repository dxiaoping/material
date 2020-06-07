package com.powersi.material.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powersi.material.pojo.User;
import com.powersi.material.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        if(user == null) return ResponseEntity.badRequest().body("错误的请求");
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(userService.verify(user)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/info")
    public ResponseEntity<String> info(String token){
        if(StringUtils.isEmpty(token)) return ResponseEntity.badRequest().body("错误的请求");
        try {
            return ResponseEntity.ok(mapper.writeValueAsString(userService.getUserInfo(token)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(String token){
        if(StringUtils.isEmpty(token)) return ResponseEntity.badRequest().body("错误的请求");
        try {
            return ResponseEntity.ok(userService.logout(token));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
