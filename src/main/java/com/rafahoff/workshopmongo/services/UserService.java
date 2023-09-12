package com.rafahoff.workshopmongo.services;

import com.rafahoff.workshopmongo.domain.User;
import com.rafahoff.workshopmongo.dto.UserDTO;
import com.rafahoff.workshopmongo.services.exception.ObjectNotFoundException;
import com.rafahoff.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
