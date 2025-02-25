package com.api.blogAppApi.repositories;

import com.api.blogAppApi.models.PostComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostComentarioRepository extends JpaRepository<PostComentarioModel, UUID> {
    List<PostComentarioModel> findByPostId(UUID postId);
}
