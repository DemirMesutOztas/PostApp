package com.postApp.post.Service;

import com.postApp.post.Entity.User;
import com.postApp.post.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class UserService {
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(int userId) {

        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(int userId, User updateUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(updateUser.getUserName());
            foundUser.setPassword(updateUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else {
            return null;
        }
    }

    public void deleteById(int userId) {

        userRepository.deleteById(userId);
    }
}
