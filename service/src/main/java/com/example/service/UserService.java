package com.example.service;

import com.example.data.entity.User;
import com.example.data.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  // Create
  public void createUser(User user) {
    userRepository.save(user);
  }

  // Read
  public User getUserById(Long userId) {
    return userRepository
        .findById(userId)
        .orElseThrow(() -> new EntityNotFoundException("Company not found"));
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  // Update
  public void updateUser(Long userId, User user) {
    User existingUser =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + userId));
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setLocation(user.getLocation());
    userRepository.save(existingUser);
  }

  // Delete
  public void deleteUserById(Long companyId) {
    userRepository.deleteById(companyId);
  }
}
