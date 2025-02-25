package com.api.blogAppApi.services.impls;

import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.repositories.BlogAppPostRepository;
import com.api.blogAppApi.services.BlogAppPostService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogAppPostServiceImpls implements BlogAppPostService {

    private final BlogAppPostRepository repository;

    public BlogAppPostServiceImpls(BlogAppPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogAppPostModel salvarPost(BlogAppPostModel post) {
        return repository.save(post);
    }

    @Override
    public List<BlogAppPostModel> listarTodosPosts() {
        return repository.findAll();
    }

    @Override
    public Optional<BlogAppPostModel> buscarPostPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void excluirPost(UUID id) {
        repository.deleteById(id);
    }
}