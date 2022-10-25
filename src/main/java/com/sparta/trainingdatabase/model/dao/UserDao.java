package com.sparta.trainingdatabase.model.dao;

import com.sparta.trainingdatabase.model.dto.UserDto;
import com.sparta.trainingdatabase.model.entity.user.User;
import com.sparta.trainingdatabase.model.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    private final UserRepository repository;

    public UserDao(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> findAll() {
        List<User> users = repository.findAll();
        List<UserDto> convertedUsers = new ArrayList();
        for (User user : users) {
            convertedUsers.add(convert(user));
        }
        return convertedUsers;
    }

    public UserDto findByid(String id) {
        Optional<User> foundUser = repository.findById(new ObjectId(id));
        if (foundUser.isPresent()) {
            return convert(foundUser.get());
        }
        return nullReturn();
    }

    public UserDto findByEmail(String email) {
        Optional<User> foundUser = repository.findByEmail(email);
        if (foundUser.isPresent()) {
            return convert(foundUser.get());
        }
        return nullReturn();
    }

    public UserDto save(UserDto userDto) {
        User userToSave = convertDto(userDto);
        repository.save(userToSave);
        return userDto;
    }

    public UserDto update(UserDto userDto) {
        Optional<User> foundUser = repository.findById(new ObjectId(userDto.getId()));
        if (foundUser.isPresent()) {
            if (userDto.getName() != null) {
                foundUser.get().setName(userDto.getName());
            }
            if (userDto.getEmail() != null) {
                foundUser.get().setEmail(userDto.getEmail());
            }
            if (userDto.getPassword() != null) {
                foundUser.get().setPassword(userDto.getPassword());
            }
            if (userDto.getRole() != null) {
                foundUser.get().setRole(userDto.getRole());
            }
            repository.save(foundUser.get());
            return findByid(userDto.getId());
        }
        return nullReturn();
    }

    public UserDto delete(String id) {
        Optional<User> foundUser = repository.findById(new ObjectId(id));
        if (foundUser.isPresent()) {
            repository.delete(foundUser.get());
            return convert(foundUser.get());
        }
        return nullReturn();
    }

    public UserDto convert(User user) {
        return new UserDto(user.getId().toString(),user.getName(),user.getEmail(),user.getPassword(),user.getRole());
    }

    public User convertDto(UserDto user) {
        return new User(user.getName(),user.getEmail(),user.getPassword(),user.getRole());
    }

    public UserDto nullReturn() {
        return new UserDto(null,null,null,null,null);
    }
}
