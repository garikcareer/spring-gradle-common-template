package com.example.service;

import com.example.data.entity.User;
import java.util.List;

public interface UserService {
  void addUser(User User);

  User getUserById(Long userId);

  List<User> getUsers();

  /**
   * @param userId
   * @param user
   */
  void updateUser(Long userId, User user);

  /**
   * Deletes a company from the system based on the given company ID.
   *
   * @param userId the unique identifier of the company to be deleted
   */
  void deleteUserById(Long userId);
}
