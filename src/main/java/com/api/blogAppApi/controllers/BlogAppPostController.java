package com.api.blogAppApi.controllers;

import com.api.blogAppApi.converters.BlogAppPostConverter;
import com.api.blogAppApi.dtos.BlogAppRecordDTO;
import com.api.blogAppApi.models.BlogAppPostModel;
import com.api.blogAppApi.services.BlogAppPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blog")
public class BlogAppPostController {

    private final BlogAppPostService blogAppPostService;
    private final BlogAppPostConverter converter;

    @Autowired
    public BlogAppPostController(BlogAppPostService blogAppPostService, BlogAppPostConverter converter) {
        this.blogAppPostService = blogAppPostService;
        this.converter = converter;
    }

    // Endpoint para adicionar um novo post
    @PostMapping
    public ResponseEntity<BlogAppPostModel> addBlogAppPost(@RequestBody BlogAppRecordDTO blogAppRecordDTO) {
        BlogAppPostModel post = converter.toModel(blogAppRecordDTO);
        BlogAppPostModel savedPost = blogAppPostService.addBlogAppPost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // Endpoint para listar todos os posts
    @GetMapping
    public ResponseEntity<List<BlogAppPostModel>> getAllBlogAppPosts() {
        List<BlogAppPostModel> posts = blogAppPostService.getAllBlogAppPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Endpoint para buscar um post por ID
    @GetMapping("/{id}")
    public ResponseEntity<BlogAppPostModel> getBlogAppPostById(@PathVariable UUID id) {
        return blogAppPostService.getBlogAppPostById(id)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para atualizar um post existente
    @PutMapping("/{id}")
    public ResponseEntity<BlogAppPostModel> updateBlogAppPost(@PathVariable UUID id, @RequestBody BlogAppRecordDTO blogAppRecordDTO) {
        BlogAppPostModel post = converter.toModel(blogAppRecordDTO);
        BlogAppPostModel updatedPost = blogAppPostService.updateBlogAppPost(id, post);
        return updatedPost != null ? new ResponseEntity<>(updatedPost, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para deletar um post por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogAppPost(@PathVariable UUID id) {
        blogAppPostService.deleteBlogAppPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}