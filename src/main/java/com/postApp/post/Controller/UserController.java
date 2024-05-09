package com.postApp.post.Controller;

import com.postApp.post.Entity.User;
import com.postApp.post.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/users")
@RestController
@AllArgsConstructor
@Data
public class UserController {

    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){

        return userService.saveOneUser(newUser);
    }

    @GetMapping(path = "/{userId}")
    public User getOneUser(@PathVariable int userId){
        //customexception ekle
        return userService.getOneUser(userId);
    }

    @PutMapping(path = "/update/{userId}")
    public User updateOneUser(@PathVariable int userId, @RequestBody User updateUser){
        return userService.updateOneUser(userId,updateUser);



    }

    @DeleteMapping(path = "/deleteOneUser/{userId}")
    public void deleteOneUser(@PathVariable int userId){
        userService.deleteById(userId);
    }



}
