package com.api.blogAppApi.services.impls;

import com.api.blogAppApi.models.PostComentarioModel;
import com.api.blogAppApi.repositories.PostComentarioRepository;
import com.api.blogAppApi.services.PostComentarioService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostComentarioServiceImpls implements PostComentarioService {

    private final PostComentarioRepository repository;

    public PostComentarioServiceImpls(PostComentarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostComentarioModel salvarComentario(PostComentarioModel comentario) {
        return repository.save(comentario);
    }

    @Override
    public List<PostComentarioModel> listarComentariosPorPost(UUID postId) {
        return repository.findByPostId(postId);
    }

    @Override
    public List<PostComentarioModel> listarTodosComentarios() {
        return repository.findAll();
    }

    @Override
    public Optional<PostComentarioModel> buscarComentarioPorId(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void excluirComentario(UUID id) {
        repository.deleteById(id);
    }
}