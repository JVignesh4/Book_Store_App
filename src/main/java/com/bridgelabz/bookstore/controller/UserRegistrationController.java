package com.bridgelabz.bookstore.controller;

import com.bridgelabz.bookstore.dto.LoginDTO;
import com.bridgelabz.bookstore.dto.ResponseDTO;
import com.bridgelabz.bookstore.dto.UserRegistrationDTO;
import com.bridgelabz.bookstore.model.UserRegistrationData;
import com.bridgelabz.bookstore.service.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserRegistrationController {

    @Autowired
    private IUserRegistrationService iUserRegistrationService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addUserRegistration(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        String userRegistrationData = iUserRegistrationService.createUser(userRegistrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created UserRegistration Data Succesfully", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getall/{token}")
    public ResponseEntity<ResponseDTO> getAllUsers(@PathVariable String token) {
        List<UserRegistrationData> userRegistrationData = iUserRegistrationService.getAllUsers(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/getby/{token}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable String token) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.getUserById(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/email/{token}")
    public ResponseEntity<ResponseDTO> getUserByEmail(@PathVariable String token) {
        List<UserRegistrationData> userRegistrationData = iUserRegistrationService.getUserByEmail(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success For Id Successfully", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        Optional<UserRegistrationData> userRegistrationData = iUserRegistrationService.login(loginDTO);
        if(userRegistrationData != null) {
            ResponseDTO responseDTO = new ResponseDTO("Login Succesfully", userRegistrationData);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("login Failed", userRegistrationData);
            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
        }
    }

    //localhost:8080/user/update/{token}
    @PutMapping("/update/{token}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable String token, @Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        UserRegistrationData userRegistrationData = iUserRegistrationService.updateUser(token, userRegistrationDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated User Data Successfully", userRegistrationData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
