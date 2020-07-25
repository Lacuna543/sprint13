package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.User;
import com.softserve.sprint13.exception.EntityNotFoundException;
import com.softserve.sprint13.repository.MarathonRepository;
import com.softserve.sprint13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private MarathonRepository marathonRepository;

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) {
            return users;
        }
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else throw new EntityNotFoundException("No user exist for given id");

    }

    @Override
    public User createOrUpdateUser(User entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }

        if (entity != null) {
            Optional<User> users = userRepository.findById(entity.getId());
            if (users.isPresent()) {
                User newUser = users.get();
                newUser.setEmail(entity.getEmail());
                newUser.setFirstName(entity.getFirstName());
                newUser.setLastName(entity.getLastName());
                newUser.setRole(entity.getRole());
                newUser.setPassword(entity.getPassword());
                newUser = userRepository.save(newUser);
                return newUser;
            }
        }
        entity = userRepository.save(entity);
        return entity;
    }

    @Override
    public List<User> getAllByRole(String role) {

        Optional<List<User>> users = Optional.ofNullable(userRepository.getAllByRole(User.Role.valueOf(role.toUpperCase())));
        if (users.isPresent()) {
            return users.get();
        } else throw new EntityNotFoundException("There is no Role");

    }

    @Override
    public boolean addUserToMarathon(User user, Marathon marathon) {
        User userEntity = userRepository.getOne(user.getId());
        Marathon marathonEntity = marathonRepository.getOne(marathon.getId());
        marathonEntity.getUsers().add(userEntity);
        return marathonRepository.save(marathonEntity) != null;
    }

}
