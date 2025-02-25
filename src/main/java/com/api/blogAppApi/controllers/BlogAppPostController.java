package com.api.blogAppApi.controllers;

import com.api.blogAppApi.dtos.impls.PostDTO;
import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.services.BlogAppPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class BlogAppPostController {

    private final BlogAppPostService service;
    private final PostConverter converter;

    public BlogAppPostController(BlogAppPostService service, PostConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<BlogAppPostModel> criarPost(@RequestBody PostDTO dto) {
        BlogAppPostModel post = converter.toModel(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarPost(post));
    }

    @GetMapping
    public ResponseEntity<List<BlogAppPostModel>> listarPosts() {
        return ResponseEntity.ok(service.listarTodosPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogAppPostModel> buscarPost(@PathVariable UUID id) {
        Optional<BlogAppPostModel> post = service.buscarPostPorId(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPost(@PathVariable UUID id) {
        service.excluirPost(id);
        return ResponseEntity.noContent().build();
    }
}