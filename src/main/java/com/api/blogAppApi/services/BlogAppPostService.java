package com.api.blogAppApi.services;

import com.api.blogAppApi.models.BlogAppPostModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlogAppPostService {
    BlogAppPostModel salvarPost(BlogAppPostModel post);

    List<BlogAppPostModel> listarTodosPosts();

    Optional<BlogAppPostModel> buscarPostPorId(UUID id);

    void excluirPost(UUID id);
}