package com.course.workshopmongo.service;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.repository.PostRepository;
import com.course.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> optionalPost = repository.findById(id);
        return optionalPost.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // soma um dia na data máxima
        return repository.fullSearch(text, minDate, maxDate);
    }

}
