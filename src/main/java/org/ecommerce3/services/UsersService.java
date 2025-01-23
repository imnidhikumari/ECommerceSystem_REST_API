package org.ecommerce3.services;

import org.ecommerce3.entity.Users;
import org.ecommerce3.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(Users user) {
        return usersRepository.registerUser(user);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAllUsers();
    }

    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findUserByEmail(email);
    }

    public boolean deleteUser(String email) {
        Optional<Users> user = usersRepository.findUserByEmail(email);
        if (user.isPresent()) {
            usersRepository.deleteUser(user.get());
            return true;
        }
        return false;
    }
}
