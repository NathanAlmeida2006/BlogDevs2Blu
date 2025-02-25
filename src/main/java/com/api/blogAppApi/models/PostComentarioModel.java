package com.api.blogAppApi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class PostComentarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private final LocalDateTime data = LocalDateTime.now();

    @Column(nullable = false, length = 500)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private BlogAppPostModel post;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BlogAppPostModel getPost() {
        return post;
    }

    public void setPost(BlogAppPostModel post) {
        this.post = post;
    }
}