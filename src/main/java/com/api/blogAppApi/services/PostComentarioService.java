package com.api.blogAppApi.services;

import com.api.blogAppApi.models.PostComentarioModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostComentarioService {
    PostComentarioModel salvarComentario(PostComentarioModel comentario);

    List<PostComentarioModel> listarComentariosPorPost(UUID postId);

    List<PostComentarioModel> listarTodosComentarios();

    Optional<PostComentarioModel> buscarComentarioPorId(UUID id);

    void excluirComentario(UUID id);
}