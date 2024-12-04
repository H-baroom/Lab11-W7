package com.example.lab11w7day4.Controller;

import com.example.lab11w7day4.Api.ApiResponse;
import com.example.lab11w7day4.Model.User;
import com.example.lab11w7day4.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added "));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/getUserByUsername/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username){
        return ResponseEntity.status(200).body(userService.getUserByUsername(username));
    }

    @GetMapping("/getAllUsersByRegistrationDate/{Registration_date}")
    public ResponseEntity getAllUsersByRegistrationDate(@PathVariable LocalDate Registration_date){
        List<User> users = userService.findAllByRegistration_date(Registration_date);
        return ResponseEntity.status(200).body(users);
    }
}
