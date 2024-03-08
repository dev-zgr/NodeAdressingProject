package com.example.nodeadressingproject.Controllers;

import com.example.nodeadressingproject.Services.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserAccountController {
    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(value = "/user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> createUserAccount(@RequestBody @Valid UserAccountDTO userAccountDTO, BindingResult result) {

        userAccountService.saveUserAccount(userAccountDTO);
        if (result.hasErrors()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Invalid data");
        }
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User Account created successfully");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("User Account creation failed");
        }
    }

    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<UserAccountDTO> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        UserAccountDTO userAccountDTO = userAccountService.login(email, password);
        try{
            if (userAccountDTO == null) {
                return ResponseEntity
                        .status(HttpStatus.FORBIDDEN)
                        .body(null);
            } else {
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(userAccountDTO);
            }
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);

    }
    }
}
