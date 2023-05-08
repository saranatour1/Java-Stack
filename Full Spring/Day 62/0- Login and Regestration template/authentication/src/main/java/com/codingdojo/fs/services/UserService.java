package com.codingdojo.fs.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.fs.models.LoginUser;
import com.codingdojo.fs.models.User;
import com.codingdojo.fs.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepo;

  // TO-DO: Write register and login methods!
  // This method will be called from the controller
  // whenever a user submits a registration form.

  public User register(User newUser, BindingResult result) {

    // Reject if email is taken (present in database)
    if (userRepo.findByEmail(newUser.getEmail()).isPresent()) {
      result.rejectValue("email", "Duplicate",
          "Email is already registered");
      return null;
    }

    // Reject if password doesn't match confirmation
    if (!newUser.getPassword().equals(newUser.getConfirm())) {
      result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
      return null;
    }

    // by this line it is assumed there are no errors
    // Hash and set password, save user to database
    String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    newUser.setPassword(hashedPassword);
    return userRepo.save(newUser);

  }

  // This method will be called from the controller
  // whenever a user submits a login form.
  public User login(LoginUser newLoginObject, BindingResult result) {

    // i see no point of adding these liness:
    // if(result.hasErrors()) {
    // return null;
    // }
    // Find user in the DB by email
    Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());

    // Reject if user not found
    if (potentialUser.isEmpty()) {
      result.rejectValue("email", "Not Found", "User not found");
      return null;
    }

    User user = potentialUser.get();

    // Reject if BCrypt password match fails
    if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
      result.rejectValue("password", "Invalid", "Invalid password");
      return null;
    }
    return user;
  }

  // this returns the user if it is found, else it returns null.
  public User findUserById(Long id) {
    return userRepo.findById(id).get();
  }

}
