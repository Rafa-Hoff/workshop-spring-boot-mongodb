package com.rafahoff.workshopmongo.services;

import com.rafahoff.workshopmongo.domain.Post;
import com.rafahoff.workshopmongo.repository.PostRepository;
import com.rafahoff.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}